/*
 * Copyright (c) 2013, Dienst Landelijk Gebied - Ministerie van Economische Zaken
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
import nl.mineleni.openls.databinding.openls.Position;
import nl.mineleni.openls.databinding.openls.ReverseGeocodePreference;
import nl.mineleni.openls.databinding.openls.ReverseGeocodeRequest;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Testcase voor {@link OpenLSReverseGeocodeRequestParser}.
 * 
 * @author prinsmc
 * 
 */
public class OpenLSReverseGeocodeRequestParserTest extends AbstractTestUtils {
	/** logger. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(OpenLSReverseGeocodeRequestParserTest.class);

	/**
	 * test de parser op basis van een aantal voorbeeld bestanden.
	 * 
	 * @throws IOException
	 */
	@Test
	public void testParser() throws IOException {
		final OpenLSReverseGeocodeRequestParser rp = new OpenLSReverseGeocodeRequestParser();
		final File folder = new File(
				"./target/test-classes/samplerequests/reversegeocode/");
		final List<File> fileList = new ArrayList<>();
		this.listDirectoryFilenames(folder, fileList);
		final java.util.Iterator<File> fileIt = fileList.iterator();
		while (fileIt.hasNext()) {
			final String fileName = "/samplerequests/reversegeocode/"
					+ fileIt.next().getName();
			final String requestString = this.readFileAsString(fileName);
			final ReverseGeocodeRequest gcrq = rp
					.parseOpenLSReverseGeocodeRequest(requestString);
			if (gcrq != null) {
				LOGGER.debug(gcrq.toXML());
			}
			assertNotNull("Parsing bestand: " + fileName, gcrq);
		}
	}

	/**
	 * round trip test parsing van een request met xml serialisatie.
	 */
	@Test
	public void testRoundTrip() throws Exception {
		final ReverseGeocodeRequest req = new ReverseGeocodeRequest();

		final Pos pos = new Pos();
		pos.setX(new Double(7.986098));
		pos.setY(new Double(49.4434503));
		pos.setDimension(2);

		final Point p = new Point();
		p.addPos(pos);
		p.setSrsName("EPSG:4326");

		final Position position = new Position();
		position.setPoint(p);
		req.setPosition(position);

		final ReverseGeocodePreference pref = new ReverseGeocodePreference();
		pref.setPreference("StreetAddress");
		req.setReverseGeocodePreference(pref);
		final String reqXML = req.toXML();

		final OpenLSReverseGeocodeRequestParser rp = new OpenLSReverseGeocodeRequestParser();
		final ReverseGeocodeRequest req2 = rp
				.parseOpenLSReverseGeocodeRequest(reqXML);
		final String reqXML2 = req2.toXML();

		LOGGER.debug(reqXML);
		LOGGER.debug(reqXML2);

		// vergelijk xml serialisatie
		assertEquals(reqXML, reqXML2);
	}
}
