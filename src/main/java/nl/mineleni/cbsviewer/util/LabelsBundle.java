/**
 * 
 */
package nl.mineleni.cbsviewer.util;

import java.util.Enumeration;
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

	/** LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(LabelsBundle.class);

	/** resource bundle. */
	private ResourceBundle resBundle;

	/**
	 * Instantiates a new labels bundle.
	 */
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

	/**
	 * Geeft sleutel/waarde paren als javascript OpenLayers object.
	 * 
	 * @return the open layers lang bundle
	 */
	public String getOpenLayersLangBundle() {
		final StringBuilder sb = new StringBuilder(
				"//<![CDATA[\nOpenLayers.Lang.nl = OpenLayers.Util.extend({");

		for (final Enumeration<String> keys = this.resBundle.getKeys(); keys
				.hasMoreElements();) {
			final String key = keys.nextElement();
			sb.append("'");
			sb.append(key);
			sb.append("'");
			sb.append(":'");
			sb.append(this.getString(key));
			sb.append("',");
			if (LOGGER.isDebugEnabled()) {
				sb.append("\n");
			}
		}

		sb.deleteCharAt(sb.length() - 1);
		sb.append("}, OpenLayers.Lang.nl);\n//]]>\n");
		return sb.toString();
	}
}
