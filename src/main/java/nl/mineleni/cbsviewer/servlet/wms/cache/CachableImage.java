/**
 * 
 */
package nl.mineleni.cbsviewer.servlet.wms.cache;

import java.awt.Image;

/**
 * Interface CachableImage. Beschrijft de functies die een afbeelding cachable
 * maken.
 * 
 * 
 * @param <T>
 *            the generic type of the object to cache.
 * @author prinsmc
 * 
 */
public interface CachableImage<T extends Image> {

	/**
	 * 
	 * Haalt de opgeslagen afbeelding {@code <T>} op.
	 * 
	 * @return the image
	 */
	T getImage();

	/**
	 * 
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
