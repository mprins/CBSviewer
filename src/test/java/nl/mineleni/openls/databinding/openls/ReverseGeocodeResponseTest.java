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
 * Testcases voor {@link ReverseGeocodeResponse}.
 * 
 * @author mprins
 */
public class ReverseGeocodeResponseTest extends AbstractTestUtils {
	private ReverseGeocodeResponse response;
	/** logger. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(ReverseGeocodeRequestTest.class);

	/**
	 * set up testdata en xmlunit.
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

		Street street = new Street();
		street.setStreet("Am Erlenbach");
		StreetAddress streetAddress = new StreetAddress();
		streetAddress.setStreet(street);

		Place place = new Place();
		place.setPlace("Frankenstein");
		place.setType("Municipality");

		Address address = new Address();
		address.setCountryCode("de");
		address.setStreetAddress(streetAddress);
		address.addPlace(place);

		SearchCentreDistance searchCentreDistance = new SearchCentreDistance();
		searchCentreDistance.setUom("M");
		searchCentreDistance.setValue(115.6);

		ReverseGeocodedLocation reverseGeocodedLocation = new ReverseGeocodedLocation();
		reverseGeocodedLocation.setAddress(address);
		reverseGeocodedLocation.setSearchCentreDistance(searchCentreDistance);
		reverseGeocodedLocation.setPoint(point);

		response = new ReverseGeocodeResponse();
		response.setReverseGeocodedLocation(reverseGeocodedLocation);
	}

	/**
	 * Testcase voor {@link ReverseGeocodeResponse#toXML()}.
	 * 
	 * @throws IOException
	 *             als er een fout optreed bij inlezen xml bestand
	 * @throws SAXException
	 *             als er een fout optreed bij parsen xml bestand
	 */
	@Test
	public void testToXML() throws IOException, SAXException {
		String control = readFileAsString("/sampleresponses/reversegeocode/response.xml");
		String test = response.toXML();
		LOGGER.debug("vergelijk: " + test + " met: " + control);
		assertXMLEqual(control, test);
	}
}