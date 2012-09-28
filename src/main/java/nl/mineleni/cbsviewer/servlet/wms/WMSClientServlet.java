/**
 * 
 */
package nl.mineleni.cbsviewer.servlet.wms;

import static nl.mineleni.cbsviewer.util.NumberConstants.DEFAULT_FONT_SIZE;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.mineleni.cbsviewer.servlet.AbstractWxSServlet;
import nl.mineleni.cbsviewer.servlet.wms.cache.ImageCaching;
import nl.mineleni.cbsviewer.servlet.wms.cache.WMSCache;
import nl.mineleni.cbsviewer.util.SpatialUtil;

import org.geotools.data.ows.Layer;
import org.geotools.data.wms.WMSUtils;
import org.geotools.data.wms.WebMapServer;
import org.geotools.data.wms.request.GetMapRequest;
import org.geotools.data.wms.response.GetMapResponse;
import org.geotools.ows.ServiceException;
import org.opengis.geometry.BoundingBox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * WMS client voor de applicatie.
 * 
 * @author prinsmc
 * @todo implmentatie
 */
public class WMSClientServlet extends AbstractWxSServlet {

	/** serialVersionUID. */
	private static final long serialVersionUID = 4958212343847516071L;
	/** logger. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(WMSClientServlet.class);

	/** voorgrond wms. */
	private transient WebMapServer fgWMS = null;

	/** achtergrond wms. */
	private transient WebMapServer bgWMS = null;

	/**
	 * vaste afmeting van de kaart (hoogte en breedte). {@value}
	 */
	private static final int MAP_DIMENSION = 440;

	/**
	 * helft van de afmeting van de kaart (hoogte en breedte). {@value}
	 * 
	 * @see #MAP_DIMENSION
	 */
	private static final int MAP_DIMENSION_MIDDLE = MAP_DIMENSION / 2;

	/** verzameling lagen voor de achtergrondkaart. */
	private String[] bgWMSlayers = null;

	/** directory in de webapp waar de wms resultaten worden gecached. */
	private static final String MAP_CACHE_DIR = "maps";

	/** cache voor achtergrond kaartjes. */
	private volatile ImageCaching<BoundingBox, BufferedImage> bgWMSCache = null;

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
					.getRealPath(MAP_CACHE_DIR));
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
		final double[] dXcoordYCoordStraal = this.parseLocation(request);
		final double xcoord = dXcoordYCoordStraal[0];
		final double ycoord = dXcoordYCoordStraal[1];
		final double straal = dXcoordYCoordStraal[2];

		// TODO voorgrond kaart uit request halen
		final String fgCapabilitiesURL = "http://geodata.nationaalgeoregister.nl/cbsvierkanten100m2010/ows?request=GetCapabilities&service=WMS&VERSION=1.1.1";
		LOGGER.debug("WMS capabilities url van voorgrond kaart: "
				+ fgCapabilitiesURL);
		try {
			this.fgWMS = new WebMapServer(new URL(fgCapabilitiesURL));
		} catch (final ServiceException e) {
			LOGGER.error(
					"Er is een service exception opgetreden bij benaderen van de voorgrond WMS",
					e);
			throw new ServletException(e);
		} catch (final MalformedURLException e) {
			LOGGER.error(
					"Een url die gebruikt wordt voor de WMS capabilities is misvormd",
					e);
			throw new ServletException(e);
		} catch (final IOException e) {
			LOGGER.error(
					"Er is een I/O fout opgetreden bij benaderen van de WMS services",
					e);
			throw new ServletException(e);
		}

		// TODO layername uit request halen
		String layername = "cbsvierkanten100m2010:cbs_inwoners_2000_per_hectare";
		// TODO style uit request halen
		String style = "cbsvierkant100m_inwoners_2000";

		final BoundingBox bbox = SpatialUtil.calcRDBBOX(xcoord, ycoord, straal);
		try {
			final File img = this.getMap(bbox, new String[] { layername },
					new String[] { style });
			this.renderHTMLResults(request, response, img);
		} catch (final ServiceException e) {
			LOGGER.error(
					"Er is een fout opgetreden bij het benaderen van (één van) de service(s).",
					e);
			throw new ServletException(e);
		}
	}

	/**
	 * kaart ophalen.
	 *
	 * @param bbox the bbox
	 * @param layerNames the layer names
	 * @param styleNames the style names
	 * @return the map
	 * @throws ServiceException the service exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private File getMap(BoundingBox bbox, String[] layerNames,
			String[] styleNames) throws ServiceException, IOException {

		Color drawCol = Color.MAGENTA;
		BufferedImage image = new BufferedImage(MAP_DIMENSION, MAP_DIMENSION,
				BufferedImage.TYPE_INT_ARGB);

		// wms request doen
		final GetMapRequest map = this.fgWMS.createGetMapRequest();
		for (int l = 0; l < layerNames.length; l++) {
			map.addLayer(layerNames[l], styleNames[l]);
		}
		map.setFormat("image/png");
		map.setDimensions(MAP_DIMENSION, MAP_DIMENSION);
		map.setTransparent(true);
		map.setSRS("EPSG:28992");
		map.setBBox(bbox);
		map.setExceptions("application/vnd.ogc.se_inimage");
		map.setBGColour("0xffffff");
		LOGGER.debug("Voorgrond WMS url is: " + map.getFinalURL());

		// thema/voorgrond ophalen
		final GetMapResponse response = this.fgWMS.issueRequest(map);
		image = ImageIO.read(response.getInputStream());
		if (LOGGER.isDebugEnabled()) {
			// voorgrond plaatje bewaren in debug modus
			final File temp = File.createTempFile("fgwms", ".png", new File(
					this.getServletContext().getRealPath(MAP_CACHE_DIR)));
			temp.deleteOnExit();
			ImageIO.write(image, "png", temp);
		}

		final BufferedImage image2 = this.getBackGround(bbox);
		final BufferedImage composite = new BufferedImage(MAP_DIMENSION,
				MAP_DIMENSION, BufferedImage.TYPE_INT_ARGB);
		final Graphics g = composite.getGraphics();
		g.drawImage(image2, 0, 0, null);
		g.drawImage(image, 0, 0, null);

		// zoeklocatie intekenen met halo
		final int width = 4;
		final int[] px = { MAP_DIMENSION_MIDDLE - width,
				MAP_DIMENSION_MIDDLE + width, MAP_DIMENSION_MIDDLE };
		final int[] py = { MAP_DIMENSION_MIDDLE + width,
				MAP_DIMENSION_MIDDLE + width, MAP_DIMENSION_MIDDLE - width };
		final int offset = 2;
		final int[] pxh = { px[0] - offset, px[1] + offset, px[2] };
		final int[] pyh = { py[0] + offset, py[1] + offset, py[2] - offset };
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, DEFAULT_FONT_SIZE
				.intValue()));
		// witte halo voor text/icoon
		g.setColor(Color.WHITE);
		g.drawString("zoeklocatie", MAP_DIMENSION_MIDDLE + 5,
				MAP_DIMENSION_MIDDLE + 5);
		g.drawString("zoeklocatie", MAP_DIMENSION_MIDDLE + 5,
				MAP_DIMENSION_MIDDLE + 7);
		g.drawString("zoeklocatie", MAP_DIMENSION_MIDDLE + 7,
				MAP_DIMENSION_MIDDLE + 7);
		g.drawString("zoeklocatie", MAP_DIMENSION_MIDDLE + 7,
				MAP_DIMENSION_MIDDLE + 5);
		g.fillPolygon(pxh, pyh, pxh.length);
		// text/ikoon
		g.setColor(drawCol);
		g.fillPolygon(px, py, px.length);
		g.drawString("zoeklocatie", MAP_DIMENSION_MIDDLE + 6,
				MAP_DIMENSION_MIDDLE + 6);

		// opslaan van plaatje zodat de browser het op kan halen
		final File temp3 = File.createTempFile("wmscombined", ".png", new File(
				this.getServletContext().getRealPath(MAP_CACHE_DIR)));
		temp3.deleteOnExit();
		ImageIO.write(composite, "png", temp3);

		return temp3;
	}

	/**
	 * Achtergrondkaart ophalen.
	 * 
	 * @param bbox
	 *            the bbox
	 * @return background/basemap image
	 * @throws ServiceException
	 *             the service exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private BufferedImage getBackGround(BoundingBox bbox)
			throws ServiceException, IOException {

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

		final GetMapResponse response = this.bgWMS.issueRequest(map);
		final BufferedImage image = ImageIO.read(response.getInputStream());
		this.bgWMSCache.put(bbox, image);
		return image;
	}

	/**
	 * Render html results.
	 * 
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @param image
	 *            the image
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws ServletException
	 *             the servlet exception
	 */
	private void renderHTMLResults(HttpServletRequest request,
			HttpServletResponse response, File image) throws IOException,
			ServletException {
		// response headers instellen en flush gebeurt al in de aanroepende
		// servlet!
		// response.setContentType("text/html; charset=UTF-8");
		// response.setBufferSize(8192);
		if (image == null) {
			// bijvoorbeeld bij expliciet leeg filter
			return;
		}
		final String imagepath = MAP_CACHE_DIR + "/" + image.getName();
		final PrintWriter out = response.getWriter();
		out.println("<div id=\"kaart\"><img id=\"resultsMap\" class=\"resultsMap\" alt=\"Kaart\" src=\""
				+ imagepath + "\" />");
		out.println("<div id=\"copy\">"
				+ this._RESOURCES.getString("KEY_COPYRIGHT")
				+ "</div></div>");
		// out.flush();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#destroy()
	 */
	@Override
	public void destroy() {
		this.bgWMS = null;
		this.fgWMS = null;
		super.destroy();
	}
}
