/*
 * Copyright (c) 2012, Dienst Landelijk Gebied - Ministerie van Economische Zaken, Landbouw en Innovatie
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie. 
 */
package nl.mineleni.cbsviewer.servlet.wms.cache;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

import javax.imageio.ImageIO;

import org.opengis.geometry.BoundingBox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Cache voor wms requests.
 * 
 * @author prinsmc
 * @see java.util.concurrent.ConcurrentHashMap
 */
public class WMSCache implements ImageCaching<BoundingBox, BufferedImage> {
    /** logger. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(WMSCache.class);

    /** de cache. */
    private final Map<BoundingBox, CachableImage<BufferedImage>> cache;

    /** cache locatie/pad. */
    private String cacheDir;

    /** aantal cache entries. */
    private final AtomicInteger cacheSize = new AtomicInteger();

    /** max. aantal cache entries. */
    private final int maxSize;
    /**
     * Used to restrict the size of the cache map.
     */
    private final Queue<BoundingBox> queue;

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
            final String cacheDir, final int maxSize, final int secondsToLive)
            throws IOException {
        this(cacheDir, maxSize);
        for (final Entry<BoundingBox, BufferedImage> e : cacheData.entrySet()) {
            this.put(e.getKey(), e.getValue(), secondsToLive);
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
    public WMSCache(final String cacheDir, final int maxSize)
            throws IOException {
        this.maxSize = maxSize;
        this.cache = new ConcurrentHashMap<BoundingBox, CachableImage<BufferedImage>>(
                maxSize);
        this.queue = new ConcurrentLinkedQueue<BoundingBox>();
        final File f = new File(cacheDir);
        final boolean createdDirs = f.mkdirs();
        if (createdDirs && LOGGER.isDebugEnabled()) {
            LOGGER.debug("Directory tree aangemaakt voor "
                    + f.getCanonicalPath());
        }
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
     * @see nl.mineleni.cbsviewer.servlet.wms.cache.ImageCaching#clear()
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
     * @see nl.mineleni.cbsviewer.servlet.wms.cache.ImageCache#containsKey(org.opengis.geometry.BoundingBox)
     */
    @Override
    public boolean containsKey(final BoundingBox bbox) {
        return this.cache.containsKey(bbox);
    }

    /*
     * (non-Javadoc)
     * 
     * @see nl.mineleni.cbsviewer.servlet.wms.cache.ImageCache#entrySet()
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
     * @see nl.mineleni.cbsviewer.servlet.wms.cache.ImageCache#get(org.opengis.geometry.BoundingBox)
     */
    @Override
    public BufferedImage get(final BoundingBox bbox) {
        if (bbox == null) { throw new IllegalArgumentException("Invalid Key."); }

        final CachableImage<BufferedImage> entry = this.cache.get(bbox);
        if (entry == null) { return null; }

        final long timestamp = entry.getExpireBy();
        if ((timestamp != -1) && (System.currentTimeMillis() > timestamp)) {
            this.remove(bbox);
            return null;
        }
        return entry.getImage();
    }

    @Override
    public Map<BoundingBox, BufferedImage> getAll(
            final Collection<BoundingBox> collection) {
        final Map<BoundingBox, BufferedImage> ret = new HashMap<BoundingBox, BufferedImage>();
        for (final BoundingBox o : collection) {
            ret.put(o, this.get(o));
        }
        return ret;
    }

    /**
     * Geeft het pad van de cache.
     * 
     * @return de cacheDir
     */
    public String getCacheDir() {
        return this.cacheDir;
    }

    public int mapSize() {
        return this.cache.size();
    }

    /**
     * plaatst de image in de cache met de sleutel.
     * 
     * @param bbox
     *            de sleutel
     * @param cacheValue
     *            het object dat wordt opgeslagen in de cache
     * @param secondsToLive
     *            the seconds to live
     * @see nl.mineleni.cbsviewer.servlet.wms.cache.ImageCaching#put(org.opengis.geometry.BoundingBox
     *      , java.lang.String)
     */
    @Override
    public void put(final BoundingBox bbox, final BufferedImage cacheValue,
            final int secondsToLive) {
        if (bbox == null) { throw new IllegalArgumentException("Invalid Key."); }
        if (cacheValue == null) { throw new IllegalArgumentException(
                "Invalid Value."); }
        final long expireBy = secondsToLive != -1 ? System.currentTimeMillis()
                + (secondsToLive * 1000) : secondsToLive;
        final boolean exists = this.cache.containsKey(bbox);
        final CacheImage c = new CacheImage(cacheValue, this.cacheDir, expireBy);

        if (!exists) {
            this.cacheSize.incrementAndGet();
            while (this.cacheSize.get() > this.maxSize) {
                this.remove(this.queue.poll());
            }
        }
        this.cache.put(bbox, c);
        this.queue.add(bbox);

        // bestand opslaan/maken
        try {
            final File temp = File.createTempFile("wmscache", ".png", new File(
                    this.cacheDir));
            temp.deleteOnExit();
            ImageIO.write(cacheValue, "png", temp);
            LOGGER.debug("Opslaan in cache: " + bbox + ", pad:"
                    + temp.getCanonicalPath());
        } catch (final IOException e) {
            LOGGER.error("Cache image opslaan is niet gelukt.", e);
        }
    }

    public int queueSize() {
        return this.queue.size();
    }

    /**
     * Verwijder het gevraagde object uit de cache.
     * 
     * @param bbox
     *            de sleutel
     */
    @Override
    public void remove(final BoundingBox bbox) {
        final CachableImage<BufferedImage> entry = this.cache.get(bbox);
        if (entry != null) {
            this.cacheSize.decrementAndGet();
            this.cache.remove(bbox);
            new File(entry.getName()).delete();
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see nl.mineleni.cbsviewer.servlet.wms.cache.ImageCaching#size()
     */
    @Override
    public int size() {
        LOGGER.debug("cache bevat " + this.cache.size() + " elementen.");
        return this.cacheSize.get();
    }
}
