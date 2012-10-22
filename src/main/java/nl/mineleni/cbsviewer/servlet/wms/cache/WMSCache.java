package nl.mineleni.cbsviewer.servlet.wms.cache;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.imageio.ImageIO;

import org.opengis.geometry.BoundingBox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * Cache voor wms requests.
 * 
 * @author prinsmc
 * @todo implementatie, thans is het een naïve wrapper om een
 *       {@link java.util.concurrent.ConcurrentHashMap} zonder expiry/cleanup
 *       zie bijvoorbeeld {@link https://code.google.com/p/kitty-cache/}
 * @see java.util.concurrent.ConcurrentHashMap
 */
public class WMSCache implements ImageCaching<BoundingBox, BufferedImage> {
	/** logger. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(WMSCache.class);

	/** de cache. */
	private final ConcurrentHashMap<BoundingBox, CachableImage<BufferedImage>> cache = new ConcurrentHashMap<BoundingBox, CachableImage<BufferedImage>>();

	/** cache locatie/pad. */
	private String cacheDir;

	/**
	 * constructor met pad voor de cache en initiële cache data.
	 * 
	 * @param cacheData
	 *            cache data
	 * @param cacheDir
	 *            pad voor de cache
	 * @throws IOException
	 *             als de gevraagde directory niet schrijfbaar is.
	 * @see WMSCache#WMSCache(String)
	 */
	public WMSCache(final Map<BoundingBox, BufferedImage> cacheData,
			final String cacheDir) throws IOException {
		this(cacheDir);
		for (final Entry<BoundingBox, BufferedImage> e : cacheData.entrySet()) {
			this.put(e.getKey(), e.getValue());
		}
	}

	/**
	 * constructor met pad voor de cache.
	 * 
	 * @param cacheDir
	 *            pad voor de cache
	 * @throws IOException
	 *             als de gevraagde directory niet schrijfbaar is.
	 */
	public WMSCache(final String cacheDir) throws IOException {
		final File f = new File(cacheDir);
		f.mkdirs();
		if (f.isDirectory() && f.canWrite()) {
			LOGGER.debug("Cache directory is: " + f.getCanonicalPath());
			this.cacheDir = cacheDir;
		} else {
			LOGGER.debug("Cache directory: " + f.getCanonicalPath()
					+ " is niet geldig.");
			throw new IOException("De gevraagde cache directory (" + cacheDir
					+ ") is niet schrijfbaar.");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.eleni.gcc.vpziek.servlet.ImageCache#clear()
	 */
	@Override
	public void clear() {
		this.cache.clear();
	}

	/**
	 * Kijkt of de gevraagde sleutel in de cache voorkomt.
	 * 
	 * @param bbox
	 *            de sleutel
	 * @return true, if successful
	 * @throws NullPointerException
	 *             als de sleutel {@code null} is
	 * @see nl.eleni.gcc.vpziek.servlet.ImageCache#containsKey(org.opengis.geometry
	 *      .BoundingBox)
	 * @see java.util.concurrent.ConcurrentHashMap#containsKey(Object)
	 */
	@Override
	public boolean containsKey(final BoundingBox bbox)
			throws NullPointerException {
		return this.cache.containsKey(bbox);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.eleni.gcc.vpziek.servlet.ImageCache#entrySet()
	 * 
	 * @see java.util.concurrent.ConcurrentHashMap#entrySet()
	 */
	@Override
	public Set<Entry<BoundingBox, BufferedImage>> entrySet() {
		final HashMap<BoundingBox, BufferedImage> s = new HashMap<BoundingBox, BufferedImage>();
		for (final Entry<BoundingBox, CachableImage<BufferedImage>> e : this.cache
				.entrySet()) {
			s.put(e.getKey(), e.getValue().getImage());
		}
		return s.entrySet();
	}

	/**
	 * haalt de gevraagde afbeelding op uit de cache, mits aanwezig.
	 * 
	 * @param bbox
	 *            de sleutel
	 * @return het object dat wordt opgehaalt uit de cache (mogelijk
	 *         {@code null})
	 * @see nl.eleni.gcc.vpziek.servlet.ImageCache#get(org.opengis.geometry.BoundingBox
	 *      )
	 * @see java.util.concurrent.ConcurrentHashMap#get(Object)
	 */
	@Override
	public BufferedImage get(final BoundingBox bbox) {
		try {
			return this.cache.get(bbox).getImage();
		} catch (final NullPointerException e) {
			return null;
		}
	}

	/**
	 * Geeft het pad van de cache.
	 * 
	 * @return de cacheDir
	 */
	public String getCacheDir() {
		return this.cacheDir;
	}

	/**
	 * plaatst de image in de cache met de sleutel.
	 * 
	 * @param bbox
	 *            de sleutel
	 * @param cacheValue
	 *            het object dat wordt opgeslagen in de cache
	 * @throws NullPointerException
	 *             als de sleutel of de waarde {@code null} is
	 * @see nl.eleni.gcc.vpziek.servlet.ImageCache#put(org.opengis.geometry.BoundingBox
	 *      , java.lang.String)
	 * @see java.util.concurrent.ConcurrentHashMap#put(Object, Object)
	 */
	@Override
	public void put(final BoundingBox bbox, final BufferedImage cacheValue)
			throws NullPointerException {
		final CacheImage c = new CacheImage(cacheValue, this.cacheDir);
		this.cache.put(bbox, c);
		// bestand opslaan
		try {
			final File temp = File.createTempFile("wmscache", ".png", new File(
					this.cacheDir));
			temp.deleteOnExit();
			ImageIO.write(cacheValue, "png", temp);
			LOGGER.debug("Opslaan in cache: " + bbox + ", pad:"
					+ temp.getCanonicalPath());
		} catch (final IOException e) {
			LOGGER.error("cache image opslaan is niet gelukt.", e);
		}
	}

	/**
	 * Verwijder het gevraagde object uit de cache.
	 * 
	 * @param bbox
	 *            de sleutel
	 * @throws NullPointerException
	 *             als de sleutel of de waarde {@code null} is
	 */
	@Override
	public void remove(final BoundingBox bbox) throws NullPointerException {
		this.cache.remove(bbox);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.eleni.gcc.vpziek.servlet.ImageCache#size()
	 * 
	 * @see java.util.concurrent.ConcurrentHashMap#size()
	 */
	@Override
	public int size() {
		LOGGER.debug("cache bevat " + this.cache.size() + " elementen.");
		return this.cache.size();
	}
}
