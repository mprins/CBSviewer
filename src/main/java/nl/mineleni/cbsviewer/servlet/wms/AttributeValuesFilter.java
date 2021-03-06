/*
 * Copyright (c) 2013, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 *
 * Gepubliceerd onder de BSD 2-clause licentie,
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie.
 */
package nl.mineleni.cbsviewer.servlet.wms;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import nl.mineleni.cbsviewer.servlet.wms.xml.AttributeValueFilter;
import nl.mineleni.cbsviewer.servlet.wms.xml.FilterList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Verzorgt de filterconfiguratie van attribuut waarden.
 *
 * @author prinsmc
 *
 * @composed 1 - 0..* AttributeValueFilter
 * @depend - attributeValueFilters - FilterList
 */
public class AttributeValuesFilter {

	/** de LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AttributeValuesFilter.class);

	/**
	 * lijst met beschikbare filters.
	 */
	private transient List<AttributeValueFilter> filters;

	/** cached flag telling about filters. */
	private transient boolean hasFilters;

	/**
	 * default constructor.
	 */
	public AttributeValuesFilter() {
		try {
			final JAXBContext jc = JAXBContext
					.newInstance("nl.mineleni.cbsviewer.servlet.wms.xml");
			final Unmarshaller u = jc.createUnmarshaller();
			final File f = new File(this.getClass().getClassLoader()
					.getResource("AttributeValuesFilter.xml").getFile());
			@SuppressWarnings("unchecked")
			final JAXBElement<FilterList> element = (JAXBElement<FilterList>) u
			.unmarshal(f);
			final FilterList fList = element.getValue();
			this.filters = fList.getFilter();
			this.hasFilters = (!this.filters.isEmpty());
		} catch (final JAXBException e) {
			LOGGER.error(
					"Er is een fout opgetreden bij het inlezen van de filters.",
					e);
		}
	}

	/**
	 * Filtert de input.
	 *
	 * @param input
	 *            een te filteren waarde
	 * @return de gefilterde input zoals in de filtermapping beschreven.
	 */
	public String filterValue(final Object input) {
		if (null != input) {
			for (final AttributeValueFilter filter : this.filters) {
				if (input.toString().equals(filter.getInputAttributeValue())) {
					return filter.getOutputAttributeValue();
				}
			}
			return input.toString();
		}
		return null;
	}

	/**
	 * Geeft aan of het filter inhoud heeft.
	 *
	 * @return {@code true} als het filter inhoud heeft
	 */
	public boolean hasFilters() {
		return this.hasFilters;
	}

}
