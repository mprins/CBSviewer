/*
 * Copyright (c) 2013, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie.
 */
package nl.mineleni.cbsviewer.servlet.wms;

import nl.mineleni.cbsviewer.util.AvailableLayersBean;

/**
 * Verzorgt de filterconfiguratie van attribuut namen.
 * 
 * @author prinsmc
 * 
 */
public class AttributesNamesFilter {
	/**
	 * lijst met beschikbare filters.
	 */
	private AvailableLayersBean layers = null;

	/**
	 * default constructor.
	 */
	public AttributesNamesFilter() {
		layers = new AvailableLayersBean();
	}

	/**
	 * Filtert de input.
	 * 
	 * @param input
	 *            een te filteren waarde
	 * @return de gefilterde input zoals in de filtermapping beschreven.
	 */
	public String filterValue(String input, String layerID) {
		String[] aliases = layers.getLayerByID(layerID).getAliases()
				.split(",\\s*");
		for (String alias : aliases) {
			if (alias.equals(input)) {
				return alias;
			}
		}
		return input;
	}

	/**
	 * Geeft aan of het filter inhoud heeft.
	 * 
	 * @return {@code true} als het filter inhoud heeft
	 */
	public boolean hasFilters(String layerID) {
		return (null != layers.getLayerByID(layerID).getAliases());
	}
}
