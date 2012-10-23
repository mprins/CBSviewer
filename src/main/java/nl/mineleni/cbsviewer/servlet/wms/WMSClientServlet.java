/**
 * 
 */
package nl.mineleni.cbsviewer.servlet.wms;

import static nl.mineleni.cbsviewer.util.StringConstants.MAP_CACHE_DIR;
import static nl.mineleni.cbsviewer.util.StringConstants.REQ_PARAM_CACHEDIR;
import static nl.mineleni.cbsviewer.util.StringConstants.REQ_PARAM_FEATUREINFO;
import static nl.mineleni.cbsviewer.util.StringConstants.REQ_PARAM_KAART;
import static nl.mineleni.cbsviewer.util.StringConstants.REQ_PARAM_LEGENDAS;
import static nl.mineleni.cbsviewer.util.StringConstants.REQ_PARAM_MAPNAME;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.mineleni.cbsviewer.servlet.AbstractWxSServlet;
import nl.mineleni.cbsviewer.servlet.wms.cache.ImageCaching;
import nl.mineleni.cbsviewer.servlet.wms.cache.WMSCache;
import nl.mineleni.cbsviewer.util.AvailableLayersBean;
import nl.mineleni.cbsviewer.util.SpatialUtil;
import nl.mineleni.cbsviewer.util.xml.LayerDescriptor;

import org.geotools.data.ows.Layer;
import org.geotools.data.ows.WMSCapabilities;
import org.geotools.data.wms.WMSUtils;
import org.geotools.data.wms.WebMapServer;
import org.geotools.data.wms.request.GetFeatureInfoRequest;
import org.geotools.data.wms.request.GetLegendGraphicRequest;
import org.geotools.data.wms.request.GetMapRequest;
import org.geotools.data.wms.response.GetFeatureInfoResponse;
import org.geotools.data.wms.response.GetLegendGraphicResponse;
import org.geotools.data.wms.response.GetMapResponse;
import org.geotools.ows.ServiceException;
import org.opengis.geometry.BoundingBox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * WMS client voor de applicatie.
 * 
 * @author prinsmc
 * @todo implementatie afmaken
 * @todo cache voor voorgrond WMS implementeren
 */
public class WMSClientServlet extends AbstractWxSServlet {

	/** serialVersionUID. */
	private static final long serialVersionUID = 4958212343847516071L;

	/** logger. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(WMSClientServlet.class);
	/**
	 * vaste afmeting van de kaart (hoogte en breedte). {@value}
	 * 
	 * @see #MAP_DIMENSION_MIDDLE
	 */
	private static final int MAP_DIMENSION = 440;

	/**
	 * helft van de afmeting van de kaart (hoogte en breedte). {@value}
	 * 
	 * @see #MAP_DIMENSION
	 */
	private static final int MAP_DIMENSION_MIDDLE = MAP_DIMENSION / 2;
	/**
	 * voorgrond wms.
	 * 
	 * @todo refactor naar lokale variabele
	 */
	private transient WebMapServer fgWMS = null;
	/**
	 * voorgrond wms request.
	 * 
	 * @todo refactor naar lokale variabele
	 */
	private transient GetMapRequest getMapRequest = null;

	/** achtergrond wms. */
	private transient WebMapServer bgWMS = null;

	/** verzameling lagen voor de achtergrondkaart. */
	private String[] bgWMSlayers = null;

	/** layers bean. */
	private final AvailableLayersBean layers = new AvailableLayersBean();

	/** cache voor achtergrond kaartjes. */
	private transient ImageCaching<BoundingBox, BufferedImage> bgWMSCache = null;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * nl.mineleni.cbsviewer.servlet.AbstractBaseServlet#init(javax.servlet.
	 * ServletConfig)
	 */
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			this.bgWMSCache = new WMSCache(this.getServletContext()
					.getRealPath(MAP_CACHE_DIR.code));
		} catch (final IOException e) {
			LOGGER.error(
					"Inititalisatie fout voor de achtergrond bitmap cache.", e);
		}

		// achtergrond kaart
		final String bgCapabilitiesURL = config
				.getInitParameter("bgCapabilitiesURL");
		LOGGER.debug("WMS capabilities url van achtergrond kaart: "
				+ bgCapabilitiesURL);
		try {
			this.bgWMS = new WebMapServer(new URL(bgCapabilitiesURL));
		} catch (final MalformedURLException e) {
			LOGGER.error(
					"Een url die gebruikt wordt voor de WMS capabilities is misvormd",
					e);
			throw new ServletException(e);
		} catch (final ServiceException e) {
			LOGGER.error(
					"Er is een service exception (WMS server fout) opgetreden bij het ophalen van de achtergrond WMS capabilities",
					e);
			throw new ServletException(e);
		} catch (final IOException e) {
			LOGGER.error(
					"Er is een I/O fout opgetreden bij benaderen van de WMS services",
					e);
			throw new ServletException(e);
		}
		final String bgWMSlyrs = config.getInitParameter("bgWMSlayers");
		LOGGER.debug("Achtergrond kaartlagen: " + bgWMSlyrs);
		if ((bgWMSlyrs != null) && (bgWMSlyrs.length() > 0)) {
			this.bgWMSlayers = bgWMSlyrs.split("[,]\\s*");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.ServletRequest,
	 * javax.servlet.ServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		final int[] dXcoordYCoordStraal = this.parseLocation(request);
		final int xcoord = dXcoordYCoordStraal[0];
		final int ycoord = dXcoordYCoordStraal[1];
		final int straal = dXcoordYCoordStraal[2];
		final BoundingBox bbox = SpatialUtil.calcRDBBOX(xcoord, ycoord, straal);

		final boolean forwardResponse = this.parseForward(request);
		BufferedImage fg = null;
		String mapName = request.getParameter(REQ_PARAM_MAPNAME.code);
		LOGGER.debug("WMS layer id: " + mapName);

		if (mapName != null) {
			LayerDescriptor layer = layers.getLayerByID(mapName);
			LOGGER.debug("LayerDescriptor: " + layer);

			final String fgCapabilitiesURL = layer.getUrl();
			LOGGER.debug("WMS capabilities url van voorgrond kaart: "
					+ fgCapabilitiesURL);
			try {
				this.fgWMS = new WebMapServer(new URL(fgCapabilitiesURL));
				fg = getForeGroundMap(bbox, new String[] { layer.getLayers() },
						new String[] { layer.getStyles() });
				final File[] legendas = this.getLegends(
						new String[] { layer.getLayers() },
						new String[] { layer.getStyles() });
				final String fInfo = this.getFeatureInfo(
						new String[] { layer.getLayers() },
						MAP_DIMENSION_MIDDLE, MAP_DIMENSION_MIDDLE);
				request.setAttribute(REQ_PARAM_LEGENDAS.code, legendas);
				request.setAttribute(REQ_PARAM_FEATUREINFO.code, fInfo);
			} catch (final ServiceException e) {
				LOGGER.error(
						"Er is een service exception opgetreden bij benaderen van de voorgrond WMS",
						e);
				throw new ServletException(e);
			} catch (final MalformedURLException e) {
				LOGGER.error(
						"De url die gebruikt wordt voor de WMS capabilities is misvormd.",
						e);
				throw new ServletException(e);
			}
		}
		final BufferedImage bg = this.getBackGroundMap(bbox);
		final File kaart = this.getMap(fg, bg);

		request.setAttribute(REQ_PARAM_CACHEDIR.code, MAP_CACHE_DIR.code);
		request.setAttribute(REQ_PARAM_KAART.code, kaart);

		if (forwardResponse) {
			request.getRequestDispatcher("/index.jsp").forward(request,
					response);
		}

	}

	/**
	 * kaart maken op babis van de opgehaalde afbeeldingen.
	 * 
	 * @param image
	 *            de voorgrondkaart
	 * @param image2
	 *            de achtergrondgrondkaart
	 * @return de file met de afbeelding
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private File getMap(BufferedImage image, BufferedImage image2)
			throws IOException {

		final BufferedImage composite = new BufferedImage(MAP_DIMENSION,
				MAP_DIMENSION, BufferedImage.TYPE_INT_ARGB);
		final Graphics g = composite.getGraphics();
		g.drawImage(image2, 0, 0, null);
		if (image != null) {
			g.drawImage(image, 0, 0, null);
		}

		// zoeklocatie intekenen met plaatje
		final BufferedImage infoImage = ImageIO.read(new File(this.getClass()
				.getClassLoader().getResource("info.png").getFile()));
		g.drawImage(infoImage, MAP_DIMENSION_MIDDLE - 16,
				MAP_DIMENSION_MIDDLE - 37, null);
		/*
		 * // zoeklocatie intekenen met halo
		 * 
		 * final Color drawCol = Color.MAGENTA; final int width = 4; final int[]
		 * px = { MAP_DIMENSION_MIDDLE - width, MAP_DIMENSION_MIDDLE + width,
		 * MAP_DIMENSION_MIDDLE }; final int[] py = { MAP_DIMENSION_MIDDLE +
		 * width, MAP_DIMENSION_MIDDLE + width, MAP_DIMENSION_MIDDLE - width };
		 * final int offset = 2; final int[] pxh = { px[0] - offset, px[1] +
		 * offset, px[2] }; final int[] pyh = { py[0] + offset, py[1] + offset,
		 * py[2] - offset }; g.setFont(new Font(Font.SANS_SERIF, Font.BOLD,
		 * DEFAULT_FONT_SIZE .intValue())); // witte halo voor text/icoon
		 * g.setColor(Color.WHITE); g.drawString("zoeklocatie",
		 * MAP_DIMENSION_MIDDLE + 5, MAP_DIMENSION_MIDDLE + 5);
		 * g.drawString("zoeklocatie", MAP_DIMENSION_MIDDLE + 5,
		 * MAP_DIMENSION_MIDDLE + 7); g.drawString("zoeklocatie",
		 * MAP_DIMENSION_MIDDLE + 7, MAP_DIMENSION_MIDDLE + 7);
		 * g.drawString("zoeklocatie", MAP_DIMENSION_MIDDLE + 7,
		 * MAP_DIMENSION_MIDDLE + 5); g.fillPolygon(pxh, pyh, pxh.length); //
		 * text/ikoon g.setColor(drawCol); g.fillPolygon(px, py, px.length);
		 * g.drawString("zoeklocatie", MAP_DIMENSION_MIDDLE + 6,
		 * MAP_DIMENSION_MIDDLE + 6);
		 */

		// opslaan van plaatje zodat de browser het op kan halen
		final File kaartAfbeelding = File.createTempFile(
				"wmscombined",
				".png",
				new File(this.getServletContext().getRealPath(
						MAP_CACHE_DIR.code)));
		kaartAfbeelding.deleteOnExit();
		ImageIO.write(composite, "png", kaartAfbeelding);
		return kaartAfbeelding;
	}

	/**
	 * haalt de legenda op voor de thema laag.
	 * 
	 * @param layerNames
	 *            WMS laag namen
	 * @param styleNames
	 *            WMS style namen
	 * @return een array met legenda afbeeldings bestanden
	 * @throws ServiceException
	 *             Geeft aan dat er een fout is opgetreden tijden het benaderen
	 *             van de WMS
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private File[] getLegends(String[] layerNames, String[] styleNames)
			throws ServiceException, IOException {

		final File[] legends = new File[layerNames.length];
		final GetLegendGraphicRequest legend = this.fgWMS
				.createGetLegendGraphicRequest();
		BufferedImage image;
		for (int l = 0; l < layerNames.length; l++) {
			legend.setLayer(layerNames[l]);
			legend.setStyle(styleNames[l]);
			legend.setFormat("image/png");
			legend.setExceptions("application/vnd.ogc.se_inimage");

			LOGGER.debug("Voorgrond WMS legenda url is: "
					+ legend.getFinalURL());
			final GetLegendGraphicResponse response = this.fgWMS
					.issueRequest(legend);
			image = ImageIO.read(response.getInputStream());
			legends[l] = File.createTempFile("legenda", ".png", new File(this
					.getServletContext().getRealPath(MAP_CACHE_DIR.code)));
			legends[l].deleteOnExit();
			ImageIO.write(image, "png", legends[l]);
		}
		return legends;
	}

	/**
	 * Haalt de feature info op.
	 * 
	 * @param layerNames
	 *            WMS laag namen
	 * @param x
	 *            de x scherm coordinaat
	 * @param y
	 *            de y scherm coordinaat
	 * @return Een string met feature info
	 * @throws ServiceException
	 *             Geeft aan dat er een fout is opgetreden tijden het benaderen
	 *             van de WMS
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private String getFeatureInfo(String[] layerNames, int x, int y)
			throws ServiceException, IOException {

		final GetFeatureInfoRequest getFeatureInfoRequest = this.fgWMS
				.createGetFeatureInfoRequest(this.getMapRequest);

		final Set<Layer> queryLayers = new HashSet<Layer>();
		final WMSCapabilities caps = this.fgWMS.getCapabilities();

		for (final Layer layer : caps.getLayerList()) {
			if ((layer.getName() != null) && (layer.getName().length() != 0)) {
				for (final String layerName : layerNames) {
					if (layer.getName().equalsIgnoreCase(layerName)) {
						queryLayers.add(layer);
					}
				}
			}
		}
		getFeatureInfoRequest.setQueryLayers(queryLayers);
		// TODO html parsen
		getFeatureInfoRequest.setInfoFormat("text/html");
		// getFeatureInfoRequest.setInfoFormat("text/plain");

		getFeatureInfoRequest.setFeatureCount(10);
		getFeatureInfoRequest.setQueryPoint(x, y);
		LOGGER.debug("WMS feature info request url is: "
				+ getFeatureInfoRequest.getFinalURL());
		final GetFeatureInfoResponse response = this.fgWMS
				.issueRequest(getFeatureInfoRequest);

		return this.convertStreamToString(response.getInputStream());
	}

	/**
	 * converteert een stream naar een string.
	 * 
	 * @param is
	 *            the is
	 * @return the string
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private String convertStreamToString(InputStream is) throws IOException {
		if (is != null) {
			final Writer writer = new StringWriter();
			final char[] buffer = new char[1024];
			try {
				final Reader reader = new BufferedReader(new InputStreamReader(
						is, "UTF-8"));
				int n;
				while ((n = reader.read(buffer)) != -1) {
					writer.write(buffer, 0, n);
				}
			} finally {
				is.close();
			}
			return writer.toString();
		} else {
			return "";
		}
	}

	/**
	 * voorgrondkaart ophalen.
	 * 
	 * @param bbox
	 *            the bbox
	 * @param layerNames
	 *            WMS laag namen
	 * @param styleNames
	 *            WMS style namen
	 * @return voorgrond afbeelding
	 * @throws ServletException
	 *             Geeft aan dat er een fout is opgetreden bij het benaderen van
	 *             de voorgrond WMS service
	 */
	private BufferedImage getForeGroundMap(BoundingBox bbox,
			String[] layerNames, String[] styleNames) throws ServletException {

		// wms request doen
		this.getMapRequest = this.fgWMS.createGetMapRequest();
		for (int l = 0; l < layerNames.length; l++) {
			this.getMapRequest.addLayer(layerNames[l], styleNames[l]);
		}
		this.getMapRequest.setFormat("image/png");
		this.getMapRequest.setDimensions(MAP_DIMENSION, MAP_DIMENSION);
		this.getMapRequest.setTransparent(true);
		this.getMapRequest.setSRS("EPSG:28992");
		this.getMapRequest.setBBox(bbox);
		this.getMapRequest.setExceptions("application/vnd.ogc.se_inimage");
		this.getMapRequest.setBGColour("0xffffff");
		LOGGER.debug("Voorgrond WMS url is: "
				+ this.getMapRequest.getFinalURL());

		try {
			// thema/voorgrond ophalen
			final GetMapResponse response = this.fgWMS
					.issueRequest(this.getMapRequest);
			final BufferedImage image = ImageIO.read(response.getInputStream());

			if (LOGGER.isDebugEnabled()) {
				// voorgrond plaatje bewaren in debug modus
				final File temp = File.createTempFile(
						"fgwms",
						".png",
						new File(this.getServletContext().getRealPath(
								MAP_CACHE_DIR.code)));
				temp.deleteOnExit();
				ImageIO.write(image, "png", temp);
			}
			return image;
		} catch (ServiceException | IOException e) {
			LOGGER.error(
					"Er is een fout opgetreden bij het benaderen van de achtergrond WMS service.",
					e);
			throw new ServletException(e);
		}
	}

	/**
	 * Achtergrondkaart ophalen en opslaan in de cache.
	 * 
	 * @param bbox
	 *            the bbox
	 * @return background/basemap image
	 * @throws ServletException
	 *             Geeft aan dat er een fout is opgetreden bij het benaderen van
	 *             de achtergrondgrond WMS service
	 * 
	 */
	private BufferedImage getBackGroundMap(BoundingBox bbox)
			throws ServletException {

		if (this.bgWMSCache.containsKey(bbox)) {
			// check cache
			return this.bgWMSCache.get(bbox);
		}

		final GetMapRequest map = this.bgWMS.createGetMapRequest();
		if (this.bgWMSlayers != null) {
			for (final String lyr : this.bgWMSlayers) {
				// per laag toevoegen met de default style
				map.addLayer(lyr, "");
			}
		} else {
			// alle lagen toevoegen
			for (final Layer layer : WMSUtils.getNamedLayers(this.bgWMS
					.getCapabilities())) {
				map.addLayer(layer);
			}
		}
		map.setFormat("image/png");
		map.setDimensions(MAP_DIMENSION, MAP_DIMENSION);
		map.setTransparent(true);
		map.setBGColour("0xffffff");
		map.setExceptions("application/vnd.ogc.se_inimage");
		map.setSRS("EPSG:28992");
		map.setBBox(bbox);

		LOGGER.debug("Achtergrond WMS url is: " + map.getFinalURL());

		try {
			GetMapResponse response = this.bgWMS.issueRequest(map);
			final BufferedImage image = ImageIO.read(response.getInputStream());
			this.bgWMSCache.put(bbox, image);

			if (LOGGER.isDebugEnabled()) {
				// achtergrond plaatje bewaren in debug modus
				final File temp = File.createTempFile(
						"bgwms",
						".png",
						new File(this.getServletContext().getRealPath(
								MAP_CACHE_DIR.code)));
				temp.deleteOnExit();
				ImageIO.write(image, "png", temp);
			}

			return image;
		} catch (ServiceException | IOException e) {
			LOGGER.error(
					"Er is een fout opgetreden bij het benaderen van de achtergrond WMS service.",
					e);
			throw new ServletException(e);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#destroy()
	 */
	@Override
	public void destroy() {
		this.bgWMSCache.clear();
		this.bgWMS = null;
		this.fgWMS = null;
		super.destroy();
	}
}
