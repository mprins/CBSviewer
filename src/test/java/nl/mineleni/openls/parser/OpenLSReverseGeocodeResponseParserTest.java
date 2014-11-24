/*
 * Copyright (c) 2013-2014, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie.
 */
package nl.mineleni.openls.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import nl.mineleni.openls.AbstractTestUtils;
import nl.mineleni.openls.databinding.gml.Point;
import nl.mineleni.openls.databinding.gml.Pos;
import nl.mineleni.openls.databinding.openls.Address;
import nl.mineleni.openls.databinding.openls.Place;
import nl.mineleni.openls.databinding.openls.ReverseGeocodeResponse;
import nl.mineleni.openls.databinding.openls.ReverseGeocodedLocation;
import nl.mineleni.openls.databinding.openls.SearchCentreDistance;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Testcase voor {@link OpenLSReverseGeocodeResponseParser}.
 * 
 * @author prinsmc
 * 
 */
public class OpenLSReverseGeocodeResponseParserTest extends AbstractTestUtils {
	/** logger. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(OpenLSReverseGeocodeResponseParserTest.class);

	/**
	 * test de parser.
	 * 
	 * @throws IOException
	 *             als er een fout optreed bij inlezen xml bestand
	 */
	@Test
	public void testParser() throws IOException {
		final OpenLSReverseGeocodeResponseParser rp = new OpenLSReverseGeocodeResponseParser();
		final File folder = new File(
				"./target/test-classes/sampleresponses/reversegeocode/");
		final List<File> fileList = new ArrayList<>();
		this.listDirectoryFilenames(folder, fileList);
		final java.util.Iterator<File> fileIt = fileList.iterator();
		while (fileIt.hasNext()) {
			final String fileName = "/sampleresponses/reversegeocode/"
					+ fileIt.next().getName();
			final String requestString = this.readFileAsString(fileName);
			final ReverseGeocodeResponse gcrq = rp
					.parseOpenLSReverseGeocodeResponse(requestString);
			if (gcrq != null) {
				LOGGER.debug(gcrq.toXML());
			}
			assertNotNull(gcrq);
		}
	}

	/**
	 * round trip test van zoeken en parsen.
	 */
	@Test
	public void testRoundTrip() {
		final ReverseGeocodedLocation reverseGeocodedLocation = new ReverseGeocodedLocation();

		final Point point = new Point();
		point.setSrsName("EPSG:4326");
		final Pos p = new Pos();
		p.setDimension(2);
		p.setXY("7.986098 49.4434503");
		point.addPos(p);
		reverseGeocodedLocation.setPoint(point);

		final Address address = new Address();
		address.setCountryCode("de");
		final Place place = new Place();
		place.setType("Municipality");
		place.setPlace("Frankenstein");
		address.addPlace(place);
		reverseGeocodedLocation.setAddress(address);

		final SearchCentreDistance searchCentreDistance = new SearchCentreDistance();
		searchCentreDistance.setAccuracy(5.0);
		searchCentreDistance.setUom("M");
		searchCentreDistance.setValue(100);
		reverseGeocodedLocation.setSearchCentreDistance(searchCentreDistance);
		final ReverseGeocodeResponse resp = new ReverseGeocodeResponse();
		resp.setReverseGeocodedLocation(reverseGeocodedLocation);

		final OpenLSReverseGeocodeResponseParser rp = new OpenLSReverseGeocodeResponseParser();
		final ReverseGeocodeResponse resp2 = rp
				.parseOpenLSReverseGeocodeResponse(resp.toXML());

		assertEquals(resp.toXML(), resp2.toXML());
	}
}
