/*
 * Copyright (c) 2012, Dienst Landelijk Gebied - Ministerie van Economische Zaken, Landbouw en Innovatie
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie. 
 */
package nl.mineleni.cbsviewer.servlet.wms.cache;

import java.awt.Image;

/**
 * Interface CachableImage. Beschrijft de functies die een afbeelding cachable
 * maken.
 * 
 * @param <T>
 *            the generic type of the object to cache.
 * @author prinsmc
 */
public interface CachableImage<T extends Image> {

    /**
     * Gets de expire by timestamp.
     * 
     * @return the expire by
     */
    long getExpireBy();

    /**
     * Haalt de opgeslagen afbeelding {@code <T>} op.
     * 
     * @return the image
     */
    T getImage();

    /**
     * Accessor voor de naam van de gecachede afbeelding, bijvoorbeeld de
     * bestandnaam.
     * 
     * @return de naam
     */
    String getName();

    /**
     * Checks of dit object geldig is.
     * 
     * @return {@code true}, indien geldig
     */
    boolean isValid();
}
