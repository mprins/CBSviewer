/*
 * Copyright (c) 2013-2014, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie.
 */
package nl.mineleni.openls.databinding.openls;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;

import java.io.IOException;

import nl.mineleni.openls.AbstractTestUtils;
import nl.mineleni.openls.databinding.gml.Point;
import nl.mineleni.openls.databinding.gml.Pos;

import org.custommonkey.xmlunit.XMLUnit;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

/**
 * Testcases voor {@link ReverseGeocodeRequest}.
 * 
 * @author mprins
 */
public class ReverseGeocodeRequestTest extends AbstractTestUtils {
	private ReverseGeocodeRequest request;
	/** logger. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ReverseGeocodeRequestTest.class);

	/**
	 * set up xmlunit en testdata.
	 */
	@Before
	public void setUp() {
		XMLUnit.setIgnoreWhitespace(true);
		XMLUnit.setIgnoreComments(true);

		Pos pos = new Pos();
		pos.setXY("7.986098 49.4434503");
		Point point = new Point();
		point.addPos(pos);
		point.setSrsName("EPSG:4326");

		Position p = new Position();
		p.setPoint(point);

		ReverseGeocodePreference pref = new ReverseGeocodePreference();
		pref.setPreference(ReverseGeocodePreference.PREFERENCE.StreetAddress
				.toString());

		request = new ReverseGeocodeRequest();
		request.setPosition(p);
		request.setReverseGeocodePreference(pref);
	}

	/**
	 * Testcase voor {@link ReverseGeocodeRequest#toXML()}.
	 * 
	 * @throws IOException
	 *             als er een fout optreed bij inlezen xml bestand
	 * @throws SAXException
	 *             als er een fout optreed bij parsen xml bestand
	 */
	@Test
	public void testToXML() throws IOException, SAXException {
		String control = readFileAsString("/samplerequests/reversegeocode/openls-reverse-geocode-request.xml");
		String test = request.toXML();
		LOGGER.debug("vergelijk: " + test + " met: " + control);
		assertXMLEqual(control, test);
	}
}