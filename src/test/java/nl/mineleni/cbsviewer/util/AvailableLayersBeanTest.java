/*
 * Copyright (c) 2013, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie. 
 */
package nl.mineleni.cbsviewer.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test case voor {@link nl.mineleni.cbsviewer.util.AvailableLayersBean}.
 * 
 * @author prinsmc
 */
public class AvailableLayersBeanTest {
	private static final String ID1 = "vierkanten500m_oad2000";
	private static final String LAYERS1 = "omgevings_adres_dichtheid_2000";
	private static final String NAME1 = "Vierkant 500m - Omgevingsadressendichtheid 2000";

	/** test subject. */
	private AvailableLayersBean bean;

	/**
	 * set up before each test.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void beforeTest() throws Exception {
		bean = new AvailableLayersBean();
	}

	/**
	 * after each test.
	 * 
	 */
	@After
	public void afterTest() {
		bean = null;
	}

	@Test
	public void testAsJSON() {
		assertTrue(bean.asJSON().startsWith("/* <![CDATA[ */var _layers="));
	}

	@Test
	public void testAsJSONBoolean() {
		assertTrue(bean.asJSON(true).startsWith("/* <![CDATA[ */var _layers="));
		assertFalse(bean.asJSON(false)
				.startsWith("/* <![CDATA[ */var _layers="));
		assertTrue(bean.asJSON(false).startsWith("["));
	}

	/**
	 * testcase voor
	 * {@link nl.mineleni.cbsviewer.util.AvailableLayersBean#getLayerByID(String)}
	 * .
	 */
	@Test
	public void testGetLayerByID() {
		assertEquals(ID1, bean.getLayerByID(ID1).getId());
		assertEquals(NAME1, bean.getLayerByID(ID1).getName());
	}

	/**
	 * testcase voor
	 * {@link nl.mineleni.cbsviewer.util.AvailableLayersBean#getLayerByLayers(String) }
	 * .
	 */
	@Test
	public void testGetLayerByLayers() {
		assertEquals(ID1, bean.getLayerByLayers(LAYERS1).getId());
	}

	/**
	 * testcase voor
	 * {@link nl.mineleni.cbsviewer.util.AvailableLayersBean#getLayerByName(String) }
	 * .
	 */
	@Test
	public void testGetLayerByName() {
		assertEquals(ID1, bean.getLayerByName(NAME1).getId());
		assertEquals(NAME1, bean.getLayerByName(NAME1).getName());
	}

}