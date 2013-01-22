/*
 * Copyright (c) 2013, Dienst Landelijk Gebied - Ministerie van Economische Zaken, Landbouw en Innovatie
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie. 
 */
package nl.mineleni.cbsviewer.util;

import static org.custommonkey.xmlunit.XMLAssert.assertXpathEvaluatesTo;
import static org.custommonkey.xmlunit.XMLAssert.assertXpathExists;
import static org.custommonkey.xmlunit.XMLAssert.assertXpathNotExists;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.custommonkey.xmlunit.XMLUnit;
import org.custommonkey.xmlunit.exceptions.ConfigurationException;
import org.custommonkey.xmlunit.exceptions.XpathException;
import org.custommonkey.xmlunit.jaxp13.Validator;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xml.sax.SAXException;

/**
 * Test case voor {@link nl.mineleni.cbsviewer.util.AvailableLayersBean} en voor
 * {@link AvailableLayers.xml} en {@link AvailableLayers.xsd}.
 * 
 * @author prinsmc
 */
public class AvailableLayersBeanTest {
	private static final String ID1 = "vierkanten500m_oad2000";
	private static final String LAYERS1 = "omgevings_adres_dichtheid_2000";
	private static final String NAME1 = "Vierkant 500m - Omgevingsadressendichtheid 2000";

	@AfterClass
	public static void cleanUp() {

	}

	/**
	 * Converteert een stream naar een string.
	 * 
	 * @param is
	 *            de InputStream met data
	 * @return de data als string
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private static String convertStreamToString(final InputStream is)
			throws IOException {
		if (is != null) {
			final Writer writer = new StringWriter();
			final char[] buffer = new char[1024];
			try {
				final Reader reader = new BufferedReader(new InputStreamReader(
						is, "UTF-8"));
				int n;
				while ((n = reader.read(buffer)) != -1) {
					writer.write(buffer, 0, n);
				}
			} finally {
				is.close();
			}
			return writer.toString();
		} else {
			return "";
		}
	}

	@BeforeClass
	public static void initXmlUnit() throws IOException {

		XMLUnit.setIgnoreWhitespace(true);
		XMLUnit.setIgnoreAttributeOrder(true);
		XMLUnit.setIgnoreComments(true);
		XMLUnit.setIgnoreDiffBetweenTextAndCDATA(true);
	}

	private AvailableLayersBean bean;

	/**
	 * set up.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {
		bean = new AvailableLayersBean();

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
	 * XML testcase voor test {@link AvailableLayers.xml}.
	 * 
	 * @todo xpath tests
	 */
	@Test
	public void testAvailableLayersXML() {
		// valideer document
		final Source schema = new StreamSource(this.getClass().getClassLoader()
				.getResourceAsStream("AvailableLayers.xsd"));
		final Source doc = new StreamSource(this.getClass().getClassLoader()
				.getResourceAsStream("AvailableLayers.xml"));
		final Validator v = new Validator();
		v.addSchemaSource(schema);
		assertTrue(v.isInstanceValid(doc));

		// test inhoud van het test document
		try {
			final String TESTXML = convertStreamToString(this.getClass()
					.getClassLoader()
					.getResourceAsStream("AvailableLayers.xml"));
			// vanwege gekkigheid in XPath werken seleciets in de default
			// namespace niet, bijv.
			// /Layers/Layerdescriptor[1]/id faalt.
			// Daarom local-name functie gebruiken
			assertXpathExists(
					"/*[local-name()='Layers']/*[local-name()='Layerdescriptor']/*[local-name()='id']",
					TESTXML);

			assertXpathEvaluatesTo("" + 2,
					"count(//*[local-name()='Layerdescriptor'])", TESTXML);

			assertXpathEvaluatesTo(
					ID1,
					"//*[local-name()='Layerdescriptor'][1]/*[local-name()='id']",
					TESTXML);

			assertXpathExists(
					"//*[local-name()='Layerdescriptor'][2]/*[local-name()='link']",
					TESTXML);
			assertXpathNotExists(
					"//*[local-name()='Layerdescriptor'][1]/*[local-name()='link']",
					TESTXML);

		} catch (ConfigurationException | XpathException | IOException
				| SAXException e) {
			e.printStackTrace();

			fail(e.getMessage());
		}
	}

	/**
	 * XML testcase voor {@link AvailableLayers.xsd}.
	 */
	@Test
	public void testAvailableLayersXSD() {
		try {
			// valideer xsd
			final Source schema = new StreamSource(this.getClass()
					.getClassLoader()
					.getResourceAsStream("AvailableLayers.xsd"));
			final Validator v = new Validator();
			v.addSchemaSource(schema);
			assertTrue(v.isSchemaValid());
		} catch (final ConfigurationException e) {
			fail(e.getMessage());
		}

	}

	/**
	 * XML testcase voor deployment {@link AvailableLayers.xml}.
	 * 
	 * @todo xpath tests
	 */
	@Test
	public void testDeploymentAvailableLayersXML() {
		// valideer document
		final Source schema = new StreamSource(this.getClass().getClassLoader()
				.getResourceAsStream("AvailableLayers.xsd"));
		final Source doc = new StreamSource(this.getClass().getClassLoader()
				.getResourceAsStream("../classes/AvailableLayers.xml"));
		final Validator v = new Validator();
		v.addSchemaSource(schema);
		assertTrue(v.isInstanceValid(doc));
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