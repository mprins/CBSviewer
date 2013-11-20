package nl.mineleni.openls.parser;

import java.io.IOException;
import java.io.StringReader;

import nl.mineleni.openls.databinding.gml.Point;
import nl.mineleni.openls.databinding.gml.Pos;
import nl.mineleni.openls.databinding.openls.Address;
import nl.mineleni.openls.databinding.openls.Building;
import nl.mineleni.openls.databinding.openls.Place;
import nl.mineleni.openls.databinding.openls.PostalCode;
import nl.mineleni.openls.databinding.openls.ReverseGeocodeResponse;
import nl.mineleni.openls.databinding.openls.ReverseGeocodedLocation;
import nl.mineleni.openls.databinding.openls.SearchCentreDistance;
import nl.mineleni.openls.databinding.openls.Street;
import nl.mineleni.openls.databinding.openls.StreetAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class OpenLSReverseGeocodeResponseParser extends AbstractOpenLSParser {
	/** logger. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(OpenLSReverseGeocodeResponseParser.class);

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
		case "reversegeocoderesponse":
			break;
		case "reversegeocodedlocation":
			final ReverseGeocodedLocation loc = (ReverseGeocodedLocation) this.objStack
					.pop();
			if (this.objStack.peek().getClass() == new ReverseGeocodeResponse()
					.getClass()) {
				((ReverseGeocodeResponse) (this.objStack.peek()))
						.setReverseGeocodedLocation(loc);
			}
			break;
		case "point":
			final Point point = (Point) (this.objStack.pop());
			if (this.objStack.peek().getClass() == new ReverseGeocodedLocation()
					.getClass()) {
				((ReverseGeocodedLocation) (this.objStack.peek()))
						.setPoint(point);
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
			if (this.objStack.peek().getClass() == new ReverseGeocodedLocation()
					.getClass()) {
				((ReverseGeocodedLocation) (this.objStack.peek()))
						.setAddress(address);
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
		case "searchcentredistance":
			final SearchCentreDistance dist = (SearchCentreDistance) (this.objStack
					.pop());
			if (this.objStack.peek().getClass() == new ReverseGeocodedLocation()
					.getClass()) {
				((ReverseGeocodedLocation) (this.objStack.peek()))
						.setSearchCentreDistance(dist);
			}
			break;
		default:
			break;
		}
	}

	/**
	 * Gets the reverse geocode response.
	 * 
	 * @return the reverse geocode response
	 */
	public ReverseGeocodeResponse getReverseGeocodeResponse() {
		ReverseGeocodeResponse geocodeResponse = null;
		if ((this.objStack.firstElement() != null)
				&& (this.objStack.firstElement().getClass() == new ReverseGeocodeResponse()
						.getClass())) {
			geocodeResponse = (ReverseGeocodeResponse) this.objStack
					.firstElement();
		}
		// LOGGER.debug(geocodeResponse.toXML());
		return geocodeResponse;
	}

	/**
	 * Parses the open ls reverse geocode response.
	 * 
	 * @param data
	 *            the data which is an OpenLS response xml document
	 * @return the geocode response object, will return null if parsing the data
	 *         failed
	 */
	public ReverseGeocodeResponse parseOpenLSReverseGeocodeResponse(
			final String data) {
		this.objStack.clear();
		try {
			this.parser.parse(new InputSource(new StringReader(data)), this);
		} catch (final SAXException | IOException e) {
			LOGGER.error("OpenLS response XML verwerken is mislukt: " + data
					+ ": ", e);
		}
		return this.getReverseGeocodeResponse();
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
		case "reversegeocoderesponse":
			this.objStack.push(new ReverseGeocodeResponse());
			break;
		case "reversegeocodedlocation":
			this.objStack.push(new ReverseGeocodedLocation());
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
		case "address":
			final Address addr = new Address();
			for (int i = 0; i < attributes.getLength(); i++) {
				final String key = attributes.getQName(i);
				final String value = attributes.getValue(i);
				if (key.equalsIgnoreCase("countryCode")) {
					addr.setCountryCode(value);
				}
			}
			this.objStack.push(addr);
			break;
		case "streetaddress":
			final StreetAddress strAddr = new StreetAddress();
			this.objStack.push(strAddr);
			break;
		case "street":
			final Street street = new Street();
			this.objStack.push(street);
			break;
		case "place":
			final Place place = new Place();
			for (int i = 0; i < attributes.getLength(); i++) {
				final String key = attributes.getQName(i);
				final String value = attributes.getValue(i);
				if (key.equalsIgnoreCase("type")) {
					place.setType(value);
				}
			}
			this.objStack.push(place);
			break;
		case "searchcentredistance":
			final SearchCentreDistance dist = new SearchCentreDistance();
			this.objStack.push(dist);
			for (int i = 0; i < attributes.getLength(); i++) {
				final String key = attributes.getQName(i);
				final String value = attributes.getValue(i);
				if (key.equalsIgnoreCase("uom")) {
					dist.setUom(value);
				}
				if (key.equalsIgnoreCase("value")) {
					dist.setValue(Double.parseDouble(value));
				}
				if (key.equalsIgnoreCase("accuracy")) {
					dist.setAccuracy(Double.parseDouble(value));
				}
			}
			break;
		default:
			LOGGER.warn("Onbekend element '" + eName + "' wordt genegeerd.");
			break;
		}
	}

}
