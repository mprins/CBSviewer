/*
 * Copyright (c) 2013, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie.
 */
package nl.mineleni.cbsviewer.servlet.wms;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * Test case voor
 * {@link nl.mineleni.cbsviewer.servlet.wms.AttributesNamesFilter}.
 * 
 * @author mprins
 */
public class AttributesNamesFilterTest {
	/** test subject. */
	private AttributesNamesFilter filter;

	/** layer id voor layer met aliases. */
	private final String hasFilterID = "vierkanten500m_oad2000";

	/** layer id voor layer zonder aliases. */
	private final String hasNoFilterID = "wijkenbuurten2011_thema_gemeenten2011_aantal_inwoners";

	/**
	 * set up.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {
		filter = new AttributesNamesFilter();
	}

	/**
	 * Test voor
	 * {@link nl.mineleni.cbsviewer.servlet.wms.AttributesNamesFilter#filterValue(String, String) }
	 * .
	 */
	@Test
	public void testFilterValue() {
		assertEquals("expected", filter.filterValue("expected", hasFilterID));
		assertEquals("dichtheid", filter.filterValue("oad2000", hasFilterID));
		assertEquals("expected", filter.filterValue("expected", hasNoFilterID));
	}

	/**
	 * Test voor
	 * {@link nl.mineleni.cbsviewer.servlet.wms.AttributesNamesFilter#hasFilters()}
	 * .
	 */
	@Test
	public void testHasFilters() {
		assertTrue(filter.hasFilters(hasFilterID));
		assertFalse(filter.hasFilters(hasNoFilterID));
	}
}
