package nl.mineleni.openls.databinding.openls;

import nl.mineleni.openls.XmlNamespaceConstants;
import nl.mineleni.openls.databinding.gml.Point;

/**
 * OLS GeocodedAddress.
 * http://schemas.opengis.net/ols/1.2.0/LocationUtilityService.xsd
 * 
 * <pre>
 * 
 * &lt;complexType name="GeocodedAddressType"&gt;
 *   &lt;sequence&gt;
 *     &lt;element ref="gml:Point" /&gt;
 *     &lt;element ref="xls:Address" /&gt;
 *     &lt;element ref="xls:GeocodeMatchCode" minOccurs="0" /&gt;
 *   &lt;/sequence&gt;
 * &lt;/complexType&gt;
 * 
 * </pre>
 * 
 * @author mprins
 */
public class GeocodedAddress implements XmlNamespaceConstants {
	/**
	 * serialization id.
	 */
	private static final long serialVersionUID = -2711370703109529657L;

	/** The point. */
	private Point point;

	/** The address. */
	private Address address;

	/** The has point. */
	private boolean hasPoint;

	/** The has address. */
	private boolean hasAddress;

	/**
	 * Instantiates a new geocoded address.
	 */
	public GeocodedAddress() {
		this.hasPoint = false;
		this.hasAddress = false;
	}

	/**
	 * Sets the point.
	 * 
	 * @param point
	 *            the new point
	 */
	public void setPoint(final Point point) {
		this.hasPoint = true;
		this.point = point;
	}

	/**
	 * Gets the point.
	 * 
	 * @return the point
	 */
	public Point getPoint() {
		return this.point;
	}

	/**
	 * Checks for point.
	 * 
	 * @return true, if successful
	 */
	public boolean hasPoint() {
		return this.hasPoint;
	}

	/**
	 * Sets the address.
	 * 
	 * @param address
	 *            the new address
	 */
	public void setAddress(final Address address) {
		this.hasAddress = true;
		this.address = address;
	}

	/**
	 * Gets the address.
	 * 
	 * @return the address
	 */
	public Address getAddress() {
		return this.address;
	}

	/**
	 * Checks for address.
	 * 
	 * @return true, if successful
	 */
	public boolean hasAddress() {
		return this.hasAddress;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.mineleni.openls.XmlNamespaceConstants#toXML()
	 */
	@Override
	public String toXML() {
		String xml = "<" + XmlNamespaceConstants.OPENLS_NAMESPACE_PREFIX
				+ ":GeocodedAddress>";
		if (this.hasPoint()) {
			xml += this.point.toXML();
		}
		if (this.hasAddress()) {
			xml += this.address.toXML();
		}
		xml += "</" + XmlNamespaceConstants.OPENLS_NAMESPACE_PREFIX
				+ ":GeocodedAddress>";
		return xml;
	}
}
