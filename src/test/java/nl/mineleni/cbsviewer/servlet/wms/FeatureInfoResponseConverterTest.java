/**
 * 
 */
package nl.mineleni.cbsviewer.servlet.wms;

import static org.custommonkey.xmlunit.XMLAssert.assertXpathEvaluatesTo;
import static org.custommonkey.xmlunit.XMLAssert.assertXpathExists;
import static org.custommonkey.xmlunit.XMLAssert.assertXpathValuesEqual;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import nl.mineleni.cbsviewer.servlet.wms.FeatureInfoResponseConverter.Type;
import nl.mineleni.cbsviewer.util.LabelsBundle;

import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Test case voor
 * {@link nl.mineleni.cbsviewer.servlet.wms.FeatureInfoResponseConverter}.
 * 
 * @author prinsmc
 * 
 */
public class FeatureInfoResponseConverterTest {

	/**
	 * set up.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {
		XMLUnit.setIgnoreWhitespace(true);
	}

	/**
	 * Test method for.
	 * 
	 * @throws Exception
	 *             the exception
	 *             {@link nl.mineleni.cbsviewer.servlet.wms.FeatureInfoResponseConverter#convertToHTMLTable(java.io.InputStream, nl.mineleni.cbsviewer.servlet.wms.FeatureInfoResponseConverter.Type, java.lang.String[])}
	 *             .
	 * @todo verder testen van html
	 */
	@Test
	public final void testConvertToHTMLTableGML0() throws Exception {
		final String[] colNames = { "gemeentecode", "aantal_inwoners" };
		final String testXML = FeatureInfoResponseConverter.convertToHTMLTable(
				this.getClass().getClassLoader()
						.getResourceAsStream("GetFeatureInfoResponse0.gml"),
				Type.GMLTYPE, colNames);
		assertNotNull(testXML);
		assertEquals(new LabelsBundle().getString("KEY_INFO_GEEN_FEATURES"),
				testXML);
	}

	/**
	 * Test method for.
	 * 
	 * @throws Exception
	 *             the exception
	 *             {@link nl.mineleni.cbsviewer.servlet.wms.FeatureInfoResponseConverter#convertToHTMLTable(java.io.InputStream, nl.mineleni.cbsviewer.servlet.wms.FeatureInfoResponseConverter.Type, java.lang.String[])}
	 *             .
	 * @todo verder testen van html
	 */
	@Test
	public final void testConvertToHTMLTableGML1() throws Exception {
		final String[] colNames = { "gemeentecode", "aantal_inwoners" };

		final String testXML = FeatureInfoResponseConverter.convertToHTMLTable(
				this.getClass().getClassLoader()
						.getResourceAsStream("GetFeatureInfoResponse1.gml"),
				Type.GMLTYPE, colNames);
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
	 * Test method for.
	 * 
	 * @throws Exception
	 *             the exception
	 *             {@link nl.mineleni.cbsviewer.servlet.wms.FeatureInfoResponseConverter#convertToHTMLTable(java.io.InputStream, nl.mineleni.cbsviewer.servlet.wms.FeatureInfoResponseConverter.Type, java.lang.String[])}
	 *             .
	 * @todo verder testen van html
	 */
	@Test
	public final void testConvertToHTMLTableGML3() throws Exception {
		final String[] colNames = { "gemeentecode", "aantal_inwoners" };

		final String testXML = FeatureInfoResponseConverter.convertToHTMLTable(
				this.getClass().getClassLoader()
						.getResourceAsStream("GetFeatureInfoResponse3.gml"),
				Type.GMLTYPE, colNames);
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
		assertXpathValuesEqual("//tbody/tr[@class=''][2]", "//tbody/tr[3]",
				testXML);
	}

	/**
	 * Test method for
	 * {@link nl.mineleni.cbsviewer.servlet.wms.FeatureInfoResponseConverter#convertToHTMLTable(java.io.InputStream, nl.mineleni.cbsviewer.servlet.wms.FeatureInfoResponseConverter.Type, java.lang.String[])}
	 * .
	 * 
	 * @throws IOException
	 */
	@Test
	@Ignore("unsupported conversion")
	public final void testConvertToHTMLTableHTML0() throws IOException {
		final String test = FeatureInfoResponseConverter.convertToHTMLTable(
				this.getClass().getClassLoader()
						.getResourceAsStream("GetFeatureInfoResponse0.html"),
				Type.HTMLTYPE, null);
		assertNotNull(test);
	}

	/**
	 * Test method for
	 * {@link nl.mineleni.cbsviewer.servlet.wms.FeatureInfoResponseConverter#convertToHTMLTable(java.io.InputStream, nl.mineleni.cbsviewer.servlet.wms.FeatureInfoResponseConverter.Type, java.lang.String[])}
	 * .
	 * 
	 * @throws IOException
	 */
	@Test
	@Ignore("unsupported conversion")
	public final void testConvertToHTMLTableHTML1() throws IOException {
		final String test = FeatureInfoResponseConverter.convertToHTMLTable(
				this.getClass().getClassLoader()
						.getResourceAsStream("GetFeatureInfoResponse1.html"),
				Type.HTMLTYPE, null);
		assertNotNull(test);
	}

	/**
	 * Test method for
	 * {@link nl.mineleni.cbsviewer.servlet.wms.FeatureInfoResponseConverter#convertToHTMLTable(java.io.InputStream, nl.mineleni.cbsviewer.servlet.wms.FeatureInfoResponseConverter.Type, java.lang.String[])}
	 * .
	 * 
	 * @throws IOException
	 */
	@Test
	@Ignore("unsupported conversion")
	public final void testConvertToHTMLTableHTML3() throws IOException {
		final String test = FeatureInfoResponseConverter.convertToHTMLTable(
				this.getClass().getClassLoader()
						.getResourceAsStream("GetFeatureInfoResponse3.html"),
				Type.HTMLTYPE, null);
		assertNotNull(test);
	}
}
