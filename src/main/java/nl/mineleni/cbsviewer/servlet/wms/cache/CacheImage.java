/*
 * Copyright (c) 2012, Dienst Landelijk Gebied - Ministerie van Economische Zaken, Landbouw en Innovatie
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie. 
 */
package nl.mineleni.cbsviewer.servlet.wms.cache;

import java.awt.image.BufferedImage;

/**
 * Cachable image implementatie.
 * 
 * @author prinsmc
 * @since 1.6
 */
class CacheImage implements CachableImage<BufferedImage> {

    /** The expire by. */
    private final long expireBy;

    /** bestandsnaam. */
    private final String fName;

    /** image. */
    private BufferedImage image = null;

    /**
     * Maak een nieuwe cache afbeelding aan.
     * 
     * @param image
     *            de afbeelding
     * @param filename
     *            de bestandsnaam
     * @param expireBy
     *            the expire by
     */
    public CacheImage(final BufferedImage image, final String filename,
            final long expireBy) {
        this.image = image;
        this.fName = filename;
        this.expireBy = expireBy;
    }

    /*
     * (non-Javadoc)
     * 
     * @see nl.mineleni.cbsviewer.servlet.wms.cache.CachableImage#getExpireBy()
     */
    @Override
    public long getExpireBy() {
        return this.expireBy;
    }

    /*
     * (non-Javadoc)
     * 
     * @see nl.eleni.gcc.vpziek.cache.CachableImage#getImage()
     */
    @Override
    public BufferedImage getImage() {
        return this.image;
    }

    /*
     * (non-Javadoc)
     * 
     * @see nl.eleni.gcc.vpziek.cache.CachableImage#getName()
     */
    @Override
    public String getName() {
        return this.fName;
    }

    /*
     * (non-Javadoc)
     * 
     * @see nl.eleni.gcc.vpziek.cache.CachableImage#isValid()
     */
    @Override
    public boolean isValid() {
        return ((this.image != null) && (this.fName != null) && (this.expireBy > System
                .currentTimeMillis()));
    }
}
