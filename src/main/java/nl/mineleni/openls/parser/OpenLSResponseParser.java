/*
 * Copyright (c) 2013, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie.
 */
package nl.mineleni.openls.parser;

import java.io.IOException;
import java.io.StringReader;
import java.util.Stack;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import nl.mineleni.openls.XmlNamespaceConstants;
import nl.mineleni.openls.databinding.gml.Point;
import nl.mineleni.openls.databinding.gml.Pos;
import nl.mineleni.openls.databinding.openls.Address;
import nl.mineleni.openls.databinding.openls.Building;
import nl.mineleni.openls.databinding.openls.GeocodeResponse;
import nl.mineleni.openls.databinding.openls.GeocodeResponseList;
import nl.mineleni.openls.databinding.openls.GeocodedAddress;
import nl.mineleni.openls.databinding.openls.Place;
import nl.mineleni.openls.databinding.openls.PostalCode;
import nl.mineleni.openls.databinding.openls.Street;
import nl.mineleni.openls.databinding.openls.StreetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * The Class OpenLSResponseParser.
 * 
 * @since 1.7
 */
public class OpenLSResponseParser extends DefaultHandler {

	/** logger. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(OpenLSResponseParser.class);

	/** The e val buf. */
	private StringBuffer eValBuf;

	/** object stack. */
	private final Stack<XmlNamespaceConstants> objStack = new Stack<>();

	/** SAX parser. */
	private SAXParser parser;

	/**
	 * Instantiates a new open ls response parser.
	 */
	public OpenLSResponseParser() {
		final SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setValidating(false);
		try {
			this.parser = factory.newSAXParser();
		} catch (final ParserConfigurationException | SAXException e) {
			LOGGER.error("Configureren of maken van de saxparser is mislukt: ",
					e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
	 */
	@Override
	public void characters(final char[] ch, final int start, final int length)
			throws SAXException {
		this.eValBuf.append(ch, start, length);
	}

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
		case "geocoderesponselist":
			final GeocodeResponseList gcResList = (GeocodeResponseList) (this.objStack
					.pop());
			if (this.objStack.peek().getClass() == new GeocodeResponse()
					.getClass()) {
				((GeocodeResponse) (this.objStack.peek()))
						.addGeocodeResponseList(gcResList);
			}
			break;
		case "geocodedaddress":
			final GeocodedAddress gcaddress = (GeocodedAddress) (this.objStack
					.pop());
			if (this.objStack.peek().getClass() == new GeocodeResponseList()
					.getClass()) {
				((GeocodeResponseList) (this.objStack.peek()))
						.addGeocodedAddress(gcaddress);
			}
			break;
		case "point":
			final Point point = (Point) (this.objStack.pop());
			if (this.objStack.peek().getClass() == new GeocodedAddress()
					.getClass()) {
				((GeocodedAddress) (this.objStack.peek())).setPoint(point);
			}
			break;
		case "pos":
			final Pos pos = (Pos) (this.objStack.pop());
			pos.setXY(this.eValBuf.toString());
			if (this.objStack.peek().getClass() == new Point().getClass()) {
				((Point) (this.objStack.peek())).addPos(pos);
			}
			break;
		case "address":
			final Address address = (Address) (this.objStack.pop());
			if (this.objStack.peek().getClass() == new GeocodedAddress()
					.getClass()) {
				((GeocodedAddress) (this.objStack.peek())).setAddress(address);
			}
			break;
		case "streetaddress":
			final StreetAddress streetaddress = (StreetAddress) (this.objStack
					.pop());
			if (this.objStack.peek().getClass() == new Address().getClass()) {
				((Address) (this.objStack.peek()))
						.setStreetAddress(streetaddress);
			}
			break;
		case "building":
			final Building building = (Building) (this.objStack.pop());
			if (this.objStack.peek().getClass() == new StreetAddress()
					.getClass()) {
				((StreetAddress) (this.objStack.peek())).setBuilding(building);
			}
			break;
		case "street":
			final Street street = (Street) (this.objStack.pop());
			street.setStreet(this.eValBuf.toString());
			if (this.objStack.peek().getClass() == new StreetAddress()
					.getClass()) {
				((StreetAddress) (this.objStack.peek())).setStreet(street);
			}
			break;
		case "place":
			final Place place = (Place) (this.objStack.pop());
			place.setPlace(this.eValBuf.toString());
			if (this.objStack.peek().getClass() == new Address().getClass()) {
				((Address) (this.objStack.peek())).addPlace(place);
			}
			break;
		case "postalcode":
			final PostalCode pc = (PostalCode) (this.objStack.pop());
			pc.setPostalCode(this.eValBuf.toString());
			if (this.objStack.peek().getClass() == new Address().getClass()) {
				((Address) (this.objStack.peek())).setPostalCode(pc);
			}
			break;
		default:
			return;
		}
	}

	/**
	 * Gets the geocode response.
	 * 
	 * @return the geocode response
	 */
	public GeocodeResponse getGeocodeResponse() {
		GeocodeResponse geocodeResponse = null;
		if ((this.objStack.firstElement() != null)
				&& (this.objStack.firstElement().getClass() == new GeocodeResponse()
						.getClass())) {
			geocodeResponse = (GeocodeResponse) this.objStack.firstElement();
		}
		return geocodeResponse;
	}

	/**
	 * Parses the open ls response.
	 * 
	 * @param data
	 *            the data which is an OpenLS response xml document
	 * @return the geocode response object, will return null if parsing the data
	 *         failed
	 */
	public GeocodeResponse parseOpenLSResponse(final String data) {
		this.objStack.clear();
		try {
			this.parser.parse(new InputSource(new StringReader(data)), this);
		} catch (final SAXException | IOException e) {
			LOGGER.error("OpenLS response XML verwerken is mislukt: " + data
					+ ": ", e);
		}
		return this.getGeocodeResponse();
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
		case "geocoderesponse":
			this.objStack.push(new GeocodeResponse());
			break;
		case "geocoderesponselist":
			final GeocodeResponseList gcResList = new GeocodeResponseList();
			this.objStack.push(gcResList);
			for (int i = 0; i < attributes.getLength(); i++) {
				final String key = attributes.getQName(i);
				final String value = attributes.getValue(i);
				if (key.equalsIgnoreCase("numberOfGeocodedAddresses")) {
					final int val = Integer.parseInt(value);
					gcResList.setNumberOfGeocodedAddresses(val);
				}
			}
			break;
		case "geocodedaddress":
			this.objStack.push(new GeocodedAddress());
			break;
		case "point":
			final Point point = new Point();
			this.objStack.push(point);
			for (int i = 0; i < attributes.getLength(); i++) {
				final String key = attributes.getQName(i);
				final String value = attributes.getValue(i);
				if (key.equalsIgnoreCase("srsName")) {
					point.setSrsName(value);
				}
			}
			break;
		case "pos":
			final Pos pos = new Pos();
			this.objStack.push(pos);
			for (int i = 0; i < attributes.getLength(); i++) {
				final String key = attributes.getQName(i);
				final String value = attributes.getValue(i);
				if (key.equalsIgnoreCase("dimension")) {
					pos.setDimension(Integer.parseInt(value));
				}
			}
			break;
		case "address":
			final Address address = new Address();
			this.objStack.push(address);
			for (int i = 0; i < attributes.getLength(); i++) {
				final String key = attributes.getQName(i);
				final String value = attributes.getValue(i);
				if (key.equalsIgnoreCase("countryCode")) {
					address.setCountryCode(value);
				}
			}
			break;
		case "streetaddress":
			this.objStack.push(new StreetAddress());
			break;
		case "building":
			final Building building = new Building();
			this.objStack.push(building);
			for (int i = 0; i < attributes.getLength(); i++) {
				final String key = attributes.getQName(i);
				final String value = attributes.getValue(i);
				if (key.equalsIgnoreCase("number")) {
					building.setNumber(value);
				}
			}
			break;
		case "street":
			this.objStack.push(new Street());
			break;
		case "place":
			final Place place = new Place();
			this.objStack.push(place);
			for (int i = 0; i < attributes.getLength(); i++) {
				final String key = attributes.getQName(i);
				final String value = attributes.getValue(i);
				if (key.equalsIgnoreCase("type")) {
					place.setType(value);
				}
			}
			break;
		case "postalcode":
			this.objStack.push(new PostalCode());
			break;
		default:
			return;
		}
	}
}
