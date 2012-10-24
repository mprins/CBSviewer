package nl.mineleni.cbsviewer.servlet.wms.cache;

import java.awt.image.BufferedImage;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Interface ImageCaching.
 * 
 * @param <K>
 *            generic type voor de sleutel, bijvoorbeeld een bounding box.
 * @param <V>
 *            generic type voor de waarde, bijvoorlbeeld een Image
 */
public interface ImageCaching<K, V> {

	/** Wist de complete cache. */
	void clear();

	/**
	 * Kijkt of de gegegeven sleuten in de cache voorkomt.
	 * 
	 * @param bbox
	 *            de sleutel
	 * @return true, if successful
	 */
	boolean containsKey(K bbox);

	/**
	 * Geeft de inhoud van de cache als {@code Set<Entry>}.
	 * 
	 * @return Entry set van de cache
	 */
	Set<Entry<K, V>> entrySet();

	/**
	 * Geeft de waarde die bij de gevraagde sleutel hoort, mits aanwezig in de
	 * cache, anders {@code null}. Gebruik {@link #containsKey(Object)} om te
	 * bepalen of er een mapping in de cache is voor deze sleutel.
	 * 
	 * @param bbox
	 *            de sleutel
	 * @return de waarde, of {@code null}
	 */
	BufferedImage get(K bbox);

	/**
	 * Slaat de waarde op in de cache met de gegeven sleutel.
	 * 
	 * @param bbox
	 *            sleutel
	 * @param cacheValue
	 *            waarde
	 */
	void put(K bbox, V cacheValue);

	/**
	 * verwijder de sleutel uit de cache.
	 * 
	 * @param bbox
	 *            sleutel
	 */
	void remove(K bbox);

	/**
	 * Geeft de grootte van de cache.
	 * 
	 * @return het aantal elementen in de cache
	 */
	int size();
}
