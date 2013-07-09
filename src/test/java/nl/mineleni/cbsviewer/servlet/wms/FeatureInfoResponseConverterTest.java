/*
 * Copyright (c) 2012-2013, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie.
 */
package nl.mineleni.cbsviewer.servlet.wms;

import static org.custommonkey.xmlunit.XMLAssert.assertXpathEvaluatesTo;
import static org.custommonkey.xmlunit.XMLAssert.assertXpathExists;
import static org.custommonkey.xmlunit.XMLAssert.assertXpathValuesEqual;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.io.IOException;

import nl.mineleni.cbsviewer.util.LabelsBundle;
import nl.mineleni.cbsviewer.util.xml.LayerDescriptor;

import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Before;
import org.junit.Test;

/**
 * Test case voor
 * {@link nl.mineleni.cbsviewer.servlet.wms.FeatureInfoResponseConverter}.
 * 
 * @author prinsmc
 */
public class FeatureInfoResponseConverterTest {
	/** resource bundle. */
	private static final LabelsBundle RESOURCES = new LabelsBundle();

	private LayerDescriptor layer;

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

		this.layer = new LayerDescriptor();

		this.layer
				.setId("wijkenbuurten2011_thema_gemeenten2011_aantal_inwoners");
		this.layer.setName("CBS Gemeenten 2011 - Aantal inwoners");
		this.layer.setLayers("gemeenten2011");
		this.layer
				.setUrl("http://geodata.nationaalgeoregister.nl/wijkenbuurten2011/wms");
		this.layer
				.setStyles("wijkenbuurten2011_thema_gemeenten2011_aantal_inwoners");
		this.layer.setAttributes("gemeentecode,aantal_inwoners");
		// this.layer.setAliases("gemeentecode, aantal inwoners");
		this.layer
				.setLink("http://geodata.nationaalgeoregister.nl/wijkenbuurten2011/wfs?request=GetFeature&amp;typeName=wijkenbuurten2011:gemeenten2011&amp;outputFormat=SHAPE-ZIP");

	}

	/**
	 * Test methode voor
	 * {@link nl.mineleni.cbsviewer.servlet.wms.FeatureInfoResponseConverter#convertToHTMLTable(java.io.InputStream, nl.mineleni.cbsviewer.servlet.wms.FeatureInfoResponseConverter.Type, java.lang.String[])}
	 * . Test met een lege response.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public final void testConvertToHTMLTableGML0() throws Exception {
		final String testXML = FeatureInfoResponseConverter
				.convertToHTMLTable(this.getClass().getClassLoader()
						.getResourceAsStream("GetFeatureInfoResponse0.gml"),
						FeatureInfoResponseConverter.CONVERTER_TYPE.GMLTYPE,
						this.layer);
		assertNotNull(testXML);
		assertEquals(new LabelsBundle().getString("KEY_INFO_GEEN_FEATURES"),
				testXML);
	}

	/**
	 * Test methode voor
	 * {@link nl.mineleni.cbsviewer.servlet.wms.FeatureInfoResponseConverter#convertToHTMLTable(java.io.InputStream, nl.mineleni.cbsviewer.servlet.wms.FeatureInfoResponseConverter.Type, java.lang.String[])}
	 * . Test met een response met 1 item.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public final void testConvertToHTMLTableGML1() throws Exception {
		final String[] colNames = this.layer.getAttributes().split(",\\s*");
		final String testXML = FeatureInfoResponseConverter
				.convertToHTMLTable(this.getClass().getClassLoader()
						.getResourceAsStream("GetFeatureInfoResponse1.gml"),
						FeatureInfoResponseConverter.CONVERTER_TYPE.GMLTYPE,
						this.layer);
		assertNotNull(testXML);

		// Validator v = new Validator(testXML);
		// v.assertIsValid();

		assertXpathExists("//caption", testXML);
		assertXpathExists("/table/caption", testXML);
		assertXpathEvaluatesTo("" + colNames.length, "count(//th)", testXML);
		assertXpathEvaluatesTo(colNames[0], "/table//th[@scope='col']", testXML);
		assertXpathEvaluatesTo(colNames[1], "/table//th[2][@scope='col']",
				testXML);
	}

	/**
	 * Test methode voor
	 * {@link nl.mineleni.cbsviewer.servlet.wms.FeatureInfoResponseConverter#convertToHTMLTable(java.io.InputStream, nl.mineleni.cbsviewer.servlet.wms.FeatureInfoResponseConverter.Type, java.lang.String[])}
	 * . Test met een response met 3 items.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	public final void testConvertToHTMLTableGML3() throws Exception {
		final String[] colNames = this.layer.getAttributes().split(",\\s*");

		final String testXML = FeatureInfoResponseConverter
				.convertToHTMLTable(this.getClass().getClassLoader()
						.getResourceAsStream("GetFeatureInfoResponse3.gml"),
						FeatureInfoResponseConverter.CONVERTER_TYPE.GMLTYPE,
						this.layer);
		assertNotNull(testXML);
		assertXpathExists("//caption", testXML);
		assertXpathExists("/table/caption", testXML);
		assertXpathEvaluatesTo("" + colNames.length, "count(//th)", testXML);
		assertXpathEvaluatesTo(colNames[0], "/table//th[@scope='col']", testXML);
		assertXpathEvaluatesTo(colNames[1], "/table//th[2][@scope='col']",
				testXML);
		assertXpathEvaluatesTo("3", "count(//tbody/tr)", testXML);
		assertXpathValuesEqual("//tbody/tr[@class='even']", "//tbody/tr[2]",
				testXML);
		assertXpathValuesEqual("//tbody/tr[@class='odd'][2]", "//tbody/tr[3]",
				testXML);
	}

	/**
	 * Test methode voor
	 * {@link nl.mineleni.cbsviewer.servlet.wms.FeatureInfoResponseConverter#convertToHTMLTable(java.io.InputStream, nl.mineleni.cbsviewer.servlet.wms.FeatureInfoResponseConverter.Type, java.lang.String[])}
	 * . Test met een response met 0 items.
	 * 
	 * @throws IOException
	 */
	@Test
	public final void testConvertToHTMLTableHTML0() throws IOException {
		final String test = FeatureInfoResponseConverter.convertToHTMLTable(
				this.getClass().getClassLoader()
						.getResourceAsStream("GetFeatureInfoResponse0.html"),
				FeatureInfoResponseConverter.CONVERTER_TYPE.HTMLTYPE,
				this.layer);
		assertNotNull(test);
		assertSame(RESOURCES.getString("KEY_INFO_GEEN_FEATURES"), test);
	}

	/**
	 * Test methode voor
	 * {@link nl.mineleni.cbsviewer.servlet.wms.FeatureInfoResponseConverter#convertToHTMLTable(java.io.InputStream, nl.mineleni.cbsviewer.servlet.wms.FeatureInfoResponseConverter.Type, java.lang.String[])}
	 * . Test met een response met 1 item.
	 * 
	 * @throws IOException
	 */
	@Test
	public final void testConvertToHTMLTableHTML1() throws IOException {
		final String test = FeatureInfoResponseConverter.convertToHTMLTable(
				this.getClass().getClassLoader()
						.getResourceAsStream("GetFeatureInfoResponse1.html"),
				FeatureInfoResponseConverter.CONVERTER_TYPE.HTMLTYPE,
				this.layer);
		assertNotNull(test);
	}

	/**
	 * Test methode voor
	 * {@link nl.mineleni.cbsviewer.servlet.wms.FeatureInfoResponseConverter#convertToHTMLTable(java.io.InputStream, nl.mineleni.cbsviewer.servlet.wms.FeatureInfoResponseConverter.Type, java.lang.String[])}
	 * . Test met een response met 3 items.
	 * 
	 * @throws IOException
	 */
	@Test
	public final void testConvertToHTMLTableHTML3() throws IOException {
		final String test = FeatureInfoResponseConverter.convertToHTMLTable(
				this.getClass().getClassLoader()
						.getResourceAsStream("GetFeatureInfoResponse3.html"),
				FeatureInfoResponseConverter.CONVERTER_TYPE.HTMLTYPE,
				this.layer);
		assertNotNull(test);
	}

	public final void testConvert0() throws IOException {
		final String testHTML = FeatureInfoResponseConverter
				.convertToHTMLTable(this.getClass().getClassLoader()
						.getResourceAsStream("GetFeatureInfoResponse0.html"),
						FeatureInfoResponseConverter.CONVERTER_TYPE.HTMLTYPE,
						this.layer);
		final String testXML = FeatureInfoResponseConverter
				.convertToHTMLTable(this.getClass().getClassLoader()
						.getResourceAsStream("GetFeatureInfoResponse0.gml"),
						FeatureInfoResponseConverter.CONVERTER_TYPE.GMLTYPE,
						this.layer);
		assertEquals(testHTML, testXML);
	}

	public final void testConvert2() throws IOException {
		final String testHTML = FeatureInfoResponseConverter
				.convertToHTMLTable(this.getClass().getClassLoader()
						.getResourceAsStream("GetFeatureInfoResponse1.html"),
						FeatureInfoResponseConverter.CONVERTER_TYPE.HTMLTYPE,
						this.layer);
		final String testXML = FeatureInfoResponseConverter
				.convertToHTMLTable(this.getClass().getClassLoader()
						.getResourceAsStream("GetFeatureInfoResponse1.gml"),
						FeatureInfoResponseConverter.CONVERTER_TYPE.GMLTYPE,
						this.layer);
		assertEquals(testHTML, testXML);
	}

	public final void testConvert3() throws IOException {
		final String testHTML = FeatureInfoResponseConverter
				.convertToHTMLTable(this.getClass().getClassLoader()
						.getResourceAsStream("GetFeatureInfoResponse3.html"),
						FeatureInfoResponseConverter.CONVERTER_TYPE.HTMLTYPE,
						this.layer);
		final String testXML = FeatureInfoResponseConverter
				.convertToHTMLTable(this.getClass().getClassLoader()
						.getResourceAsStream("GetFeatureInfoResponse3.gml"),
						FeatureInfoResponseConverter.CONVERTER_TYPE.GMLTYPE,
						this.layer);
		assertEquals(testHTML, testXML);
	}
}
