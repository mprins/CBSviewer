/*
 * Copyright (c) 2013-2014, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie.
 */
package nl.mineleni.openls.parser;

import java.io.IOException;
import java.io.StringReader;

import nl.mineleni.openls.databinding.gml.Point;
import nl.mineleni.openls.databinding.gml.Pos;
import nl.mineleni.openls.databinding.openls.Position;
import nl.mineleni.openls.databinding.openls.ReverseGeocodePreference;
import nl.mineleni.openls.databinding.openls.ReverseGeocodeRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Parse reverse geocode requests.
 * 
 * @author prinsmc
 *
 */
public class OpenLSReverseGeocodeRequestParser extends AbstractOpenLSParser {
	/** logger. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(OpenLSReverseGeocodeRequestParser.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void endElement(final String uri, final String localName,
			final String qName) throws SAXException {
		final String[] nsName = qName.split(":");
		String eName = "";
		if (nsName.length > 1) {
			eName = nsName[1];
		} else {
			eName = nsName[0];
		}

		switch (eName.toLowerCase()) {
		case "reversegeocoderequest":
			break;
		case "position":
			final Position position = (Position) (this.objStack.pop());
			if (this.objStack.peek().getClass() == new ReverseGeocodeRequest()
					.getClass()) {
				((ReverseGeocodeRequest) (this.objStack.peek()))
						.setPosition(position);
			}
			break;
		case "point":
			final Point point = (Point) (this.objStack.pop());
			if (this.objStack.peek().getClass() == new Position().getClass()) {
				((Position) (this.objStack.peek())).setPoint(point);
			}
			break;
		case "pos":
			final Pos pos = (Pos) (this.objStack.pop());
			pos.setXY(this.eValBuf.toString());
			if (this.objStack.peek().getClass() == new Point().getClass()) {
				((Point) (this.objStack.peek())).addPos(pos);
			}
			break;
		case "reversegeocodepreference":
			final ReverseGeocodePreference rcp = (ReverseGeocodePreference) (this.objStack
					.pop());
			rcp.setPreference(this.eValBuf.toString());
			if (this.objStack.peek().getClass() == new ReverseGeocodeRequest()
					.getClass()) {
				((ReverseGeocodeRequest) (this.objStack.peek()))
						.setReverseGeocodePreference(rcp);
			}
			break;
		default:
			break;
		}

	}

	/**
	 * Gets the reverse geocode request.
	 * 
	 * @return the reverse geocode request
	 */
	public ReverseGeocodeRequest getReverseGeocodeRequest() {
		ReverseGeocodeRequest geocodeRequest = null;
		if ((this.objStack.firstElement() != null)
				&& (this.objStack.firstElement().getClass() == new ReverseGeocodeRequest()
						.getClass())) {
			geocodeRequest = (ReverseGeocodeRequest) this.objStack
					.firstElement();
		}
		return geocodeRequest;
	}

	/**
	 * Parses the open ls reverse geocode response.
	 * 
	 * @param data
	 *            the data which is an OpenLS response xml document
	 * @return the geocode response object, will return null if parsing the data
	 *         failed
	 */
	public ReverseGeocodeRequest parseOpenLSReverseGeocodeRequest(
			final String data) {
		this.objStack.clear();
		try {
			this.parser.parse(new InputSource(new StringReader(data)), this);
		} catch (final SAXException | IOException e) {
			LOGGER.error("OpenLS request XML verwerken is mislukt: " + data
					+ ": ", e);
		}
		return this.getReverseGeocodeRequest();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String,
	 * java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(final String uri, final String localName,
			final String qName, final Attributes attributes)
			throws SAXException {
		this.eValBuf = new StringBuffer();
		final String[] nsName = qName.split(":");
		String eName = nsName[0];
		if (nsName.length > 1) {
			eName = nsName[1];
		}

		switch (eName.toLowerCase()) {
		case "reversegeocoderequest":
			this.objStack.push(new ReverseGeocodeRequest());
			break;
		case "position":
			this.objStack.push(new Position());
			break;
		case "point":
			final Point point = new Point();
			for (int i = 0; i < attributes.getLength(); i++) {
				final String key = attributes.getQName(i);
				final String value = attributes.getValue(i);
				if (key.equalsIgnoreCase("srsName")) {
					point.setSrsName(value);
				}
			}
			this.objStack.push(point);
			break;
		case "pos":
			final Pos pos = new Pos();
			for (int i = 0; i < attributes.getLength(); i++) {
				final String key = attributes.getQName(i);
				final String value = attributes.getValue(i);
				if (key.equalsIgnoreCase("dimension")) {
					pos.setDimension(Integer.parseInt(value));
				}
			}
			this.objStack.push(pos);
			break;
		case "reversegeocodepreference":
			this.objStack.push(new ReverseGeocodePreference());
			break;
		default:
			LOGGER.warn("Onbekend element '" + eName + "' wordt genegeerd.");
			break;
		}
	}
}
