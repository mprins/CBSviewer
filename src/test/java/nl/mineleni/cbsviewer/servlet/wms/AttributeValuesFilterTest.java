/*
 * Copyright (c) 2013, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie.
 */
package nl.mineleni.cbsviewer.servlet.wms;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.custommonkey.xmlunit.XMLUnit;
import org.custommonkey.xmlunit.exceptions.ConfigurationException;
import org.custommonkey.xmlunit.jaxp13.Validator;
import org.junit.Before;
import org.junit.Test;

/**
 * Test case voor
 * {@link nl.mineleni.cbsviewer.servlet.wms.AttributeValuesFilter}.
 * 
 * @author prinsmc
 */
public class AttributeValuesFilterTest {
	/**
	 * set up.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {
		XMLUnit.setIgnoreWhitespace(true);
		XMLUnit.setIgnoreComments(true);
	}

	/**
	 * XML testcase voor {@link AttributeValuesFilter.xsd}.
	 */
	@Test
	public void testAvailableLayersXSD() {
		try {
			// valideer xsd
			final Source schema = new StreamSource(this.getClass()
					.getClassLoader()
					.getResourceAsStream("AttributeValuesFilter.xsd"));
			final Validator v = new Validator();
			v.addSchemaSource(schema);
			assertTrue(v.isSchemaValid());
		} catch (final ConfigurationException e) {
			fail(e.getMessage());
		}
	}

	/**
	 * XML testcase voor deployment {@link AttributeValuesFilter.xml}.
	 * 
	 * @todo xpath tests
	 */
	@Test
	public void testDeploymentAvailableLayersXML() {
		// valideer document
		final Source schema = new StreamSource(this.getClass().getClassLoader()
				.getResourceAsStream("AttributeValuesFilter.xsd"));
		final Source doc = new StreamSource(this.getClass().getClassLoader()
				.getResourceAsStream("../classes/AttributeValuesFilter.xml"));
		final Validator v = new Validator();
		v.addSchemaSource(schema);
		assertTrue(v.isInstanceValid(doc));
	}
}