/*
 * Copyright (c) 2013, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 *
 * Gepubliceerd onder de BSD 2-clause licentie,
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie.
 */
package nl.mineleni.openls.parser;

import java.io.IOException;
import java.io.StringReader;

import nl.mineleni.openls.databinding.openls.Address;
import nl.mineleni.openls.databinding.openls.Building;
import nl.mineleni.openls.databinding.openls.GeocodeRequest;
import nl.mineleni.openls.databinding.openls.Place;
import nl.mineleni.openls.databinding.openls.PostalCode;
import nl.mineleni.openls.databinding.openls.Street;
import nl.mineleni.openls.databinding.openls.StreetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * The Class OpenLSGeocodeRequestParser.
 *
 * @since 1.7
 */
public class OpenLSGeocodeRequestParser extends AbstractOpenLSParser {

	/** logger. */
	private static final Logger LOGGER = LoggerFactory
	        .getLogger(OpenLSGeocodeRequestParser.class);

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
		case "address":
			final Address address = (Address) (this.objStack.pop());
			if (this.objStack.peek().getClass() == GeocodeRequest.class) {
				((GeocodeRequest) (this.objStack.peek())).addAddress(address);
			}
			break;
		case "streetaddress":
			final StreetAddress streetaddress = (StreetAddress) (this.objStack
			        .pop());
			if (this.objStack.peek().getClass() == Address.class) {
				((Address) (this.objStack.peek()))
				        .setStreetAddress(streetaddress);
			}
			break;
		case "building":
			final Building building = (Building) (this.objStack.pop());
			if (this.objStack.peek().getClass() == StreetAddress.class) {
				((StreetAddress) (this.objStack.peek())).setBuilding(building);
			}
			break;
		case "street":
			final Street street = (Street) (this.objStack.pop());
			street.setStreet(this.eValBuf.toString());
			if (this.objStack.peek().getClass() == StreetAddress.class) {
				((StreetAddress) (this.objStack.peek())).setStreet(street);
			}
			break;
		case "place":
			final Place place = (Place) (this.objStack.pop());
			place.setPlace(this.eValBuf.toString());
			if (this.objStack.peek().getClass() == Address.class) {
				((Address) (this.objStack.peek())).addPlace(place);
			}
			break;
		case "postalcode":
			final PostalCode pc = (PostalCode) (this.objStack.pop());
			pc.setPostalCode(this.eValBuf.toString());
			if (this.objStack.peek().getClass() == Address.class) {
				((Address) (this.objStack.peek())).setPostalCode(pc);
			}
			break;
		default:
			return;
		}
	}

	/**
	 * Gets the geocode request.
	 *
	 * @return the geocode request
	 */
	public GeocodeRequest getGeocodeRequest() {
		GeocodeRequest geocodeRequest = null;
		if ((this.objStack.firstElement() != null)
		        && (this.objStack.firstElement().getClass() == GeocodeRequest.class)) {
			geocodeRequest = (GeocodeRequest) this.objStack.firstElement();
		}
		return geocodeRequest;
	}

	/**
	 * Parses the open ls request.
	 *
	 * @param data
	 *            the data
	 * @return the geocode request
	 */
	public GeocodeRequest parseOpenLSRequest(final String data) {
		this.objStack.clear();
		try {
			this.parser.parse(new InputSource(new StringReader(data)), this);
		} catch (final SAXException | IOException e) {
			LOGGER.error("OpenLS response XML verwerken is mislukt: " + data
			        + ": ", e);
		}
		return this.getGeocodeRequest();
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
		case "geocoderequest":
			this.objStack.push(new GeocodeRequest());
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
