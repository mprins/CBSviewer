package nl.mineleni.openls.databinding.openls;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import nl.mineleni.openls.XmlNamespaceConstants;

/**
 * OLS Address.
 * 
 * http://schemas.opengis.net/ols/1.2.0/ADT.xsd
 * 
 * <pre>
 * 
 * &lt;complexType name="AddressType"&gt;
 *   &lt;annotation&gt;
 *     &lt;documentation&gt;Defines an address&lt;/documentation&gt;
 *   &lt;/annotation&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="xls:AbstractAddressType"&gt;
 *       &lt;choice&gt;
 *         &lt;element name="freeFormAddress" type="string"&gt;
 *           &lt;annotation&gt;
 *             &lt;documentation&gt;An unstructured free form address.&lt;/documentation&gt;
 *           &lt;/annotation&gt;
 *         &lt;/element&gt;
 *         &lt;sequence&gt;
 *           &lt;element ref="xls:StreetAddress" /&gt;
 *           &lt;element ref="xls:Place" minOccurs="0" maxOccurs="unbounded" /&gt;
 *           &lt;element ref="xls:PostalCode" minOccurs="0" /&gt;
 *         &lt;/sequence&gt;
 *       &lt;/choice&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * 
 * </pre>
 * 
 * @author mprins
 * @since 1.7
 */
public class Address implements XmlNamespaceConstants {
	/**
	 * serialization id.
	 */
	private static final long serialVersionUID = -4508692290538906979L;

	/** The country code. */
	private String countryCode;

	/** The street address. */
	private StreetAddress streetAddress;

	/** The postal code. */
	private PostalCode postalCode;

	/** The place. */
	private final Vector<Place> place = new Vector<>();

	/** The place map. */
	private final Map<String, String> placeMap = new HashMap<>();

	/** The has country code. */
	private boolean hasCountryCode;

	/** The has street address. */
	private boolean hasStreetAddress;

	/** The has postal code. */
	private boolean hasPostalCode;

	/**
	 * Instantiates a new address.
	 */
	public Address() {
		this.hasCountryCode = false;
		this.hasStreetAddress = false;
		this.hasPostalCode = false;
	}

	/**
	 * Instantiates a new address.
	 * 
	 * @param countryCode
	 *            the country code
	 * @param streetAddress
	 *            the street address
	 * @param postalCode
	 *            the postal code
	 */
	public Address(final String countryCode, final StreetAddress streetAddress,
			final PostalCode postalCode) {
		this.hasCountryCode = true;
		this.countryCode = countryCode;
		this.hasStreetAddress = true;
		this.streetAddress = streetAddress;
		this.hasPostalCode = true;
		this.postalCode = postalCode;
	}

	/**
	 * Sets the country code.
	 * 
	 * @param countryCode
	 *            the new country code
	 */
	public void setCountryCode(final String countryCode) {
		this.hasCountryCode = true;
		this.countryCode = countryCode;
	}

	/**
	 * Gets the country code.
	 * 
	 * @return the country code
	 */
	public String getCountryCode() {
		return this.countryCode;
	}

	/**
	 * Checks for country code.
	 * 
	 * @return true, if successful
	 */
	public boolean hasCountryCode() {
		return this.hasCountryCode;
	}

	/**
	 * Sets the street address.
	 * 
	 * @param streetAddress
	 *            the new street address
	 */
	public void setStreetAddress(final StreetAddress streetAddress) {
		this.hasStreetAddress = true;
		this.streetAddress = streetAddress;
	}

	/**
	 * Gets the street address.
	 * 
	 * @return the street address
	 */
	public StreetAddress getStreetAddress() {
		return this.streetAddress;
	}

	/**
	 * Checks for street address.
	 * 
	 * @return true, if successful
	 */
	public boolean hasStreetAddress() {
		return this.hasStreetAddress;
	}

	/**
	 * Sets the postal code.
	 * 
	 * @param postalCode
	 *            the new postal code
	 */
	public void setPostalCode(final PostalCode postalCode) {
		this.hasPostalCode = true;
		this.postalCode = postalCode;
	}

	/**
	 * Gets the postal code.
	 * 
	 * @return the postal code
	 */
	public PostalCode getPostalCode() {
		return this.postalCode;
	}

	/**
	 * Checks for postal code.
	 * 
	 * @return true, if successful
	 */
	public boolean hasPostalCode() {
		return this.hasPostalCode;
	}

	/**
	 * Adds the place.
	 * 
	 * @param val
	 *            the val
	 */
	public void addPlace(final Place val) {
		this.place.add(val);
		if (!val.getType().equals("")) {
			this.placeMap.put(val.getType(), val.getPlace());
		}
	}

	/**
	 * Gets the place at.
	 * 
	 * @param i
	 *            the i
	 * @return the place at
	 */
	public Place getPlaceAt(final int i) {
		return this.place.get(i);
	}

	/**
	 * Gets the place size.
	 * 
	 * @return the place size
	 */
	public int getPlaceSize() {
		return this.place.size();
	}

	/**
	 * Gets the place by type.
	 * 
	 * @param type
	 *            the type
	 * @return the place by type
	 */
	public String getPlaceByType(final String type) {
		return this.placeMap.get(type);
	}

	/**
	 * Checks for place type.
	 * 
	 * @param type
	 *            the type
	 * @return true, if successful
	 */
	public boolean hasPlaceType(final String type) {
		return (this.placeMap.get(type) != null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.mineleni.openls.databinding.common.XmlNamespaceConstants#toXML()
	 */
	@Override
	public String toXML() {
		final StringBuilder sb = new StringBuilder("<"
				+ XmlNamespaceConstants.OPENLS_NAMESPACE_PREFIX + ":Address");
		if (this.hasCountryCode()) {
			sb.append(" countryCode=\"" + this.getCountryCode() + "\"");
		}
		sb.append(">");
		if (this.hasStreetAddress()) {
			sb.append(this.streetAddress.toXML());
		}
		for (final Place pla : this.place) {
			sb.append(pla.toXML());
		}
		if (this.hasPostalCode()) {
			sb.append(this.postalCode.toXML());
		}
		sb.append("</" + XmlNamespaceConstants.OPENLS_NAMESPACE_PREFIX
				+ ":Address>");
		return sb.toString();
	}
}
