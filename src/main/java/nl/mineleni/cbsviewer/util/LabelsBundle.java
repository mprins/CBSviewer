/**
 * 
 */
package nl.mineleni.cbsviewer.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Resourcebundel bundle voor de applicatie.
 * 
 * @author prinsmc
 * @since 1.6
 */
public class LabelsBundle {
	final Logger LOGGER = LoggerFactory.getLogger(LabelsBundle.class);
	private ResourceBundle resBundle;

	public LabelsBundle() {
		try {
			this.resBundle = ResourceBundle
					.getBundle(
							"LabelsBundle",
							ResourceBundle.Control
									.getControl(ResourceBundle.Control.FORMAT_PROPERTIES));
		} catch (final NullPointerException e) {
			LOGGER.error("baseName of control is null.", e);
		} catch (final MissingResourceException e) {
			LOGGER.error(
					"De resourcebundel (LabelsBundle.properties) is niet gevonden",
					e);
		} catch (final IllegalArgumentException e) {
			LOGGER.error(
					"ResourceBundle.Control heeft geen locale kunnen achterhalen.",
					e);
		}
	}

	/**
	 * Geeft de string voor de sleutel, de string kan leeg zijn in het geval van
	 * ontbreken van de key.
	 * 
	 * @param key
	 *            de sleutel
	 * @return de string
	 */
	public String getString(final String key) {
		String s = "";
		try {
			s = this.resBundle.getString(key);
		} catch (final MissingResourceException e) {
			LOGGER.error("Er is geen object gevonden voor de gevraagde key ("
					+ key + ").", e);
		} catch (final NullPointerException e) {
			LOGGER.error("Sleutel (" + key + ") is null.", e);
		} catch (final ClassCastException e) {
			LOGGER.error("Het Object voor de gevraagde sleutel  (" + key
					+ ") is geen String.", e);
		}
		return s;
	}
}
