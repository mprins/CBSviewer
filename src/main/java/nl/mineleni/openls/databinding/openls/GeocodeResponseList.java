package nl.mineleni.openls.databinding.openls;

import java.util.Vector;

import nl.mineleni.openls.XmlNamespaceConstants;

/**
 * OLS GeocodeResponseList.
 * http://schemas.opengis.net/ols/1.2.0/LocationUtilityService.xsd
 * 
 * <pre>
 * 
 *  &lt;complexType name="GeocodeResponseListType"&gt;
 *   &lt;sequence&gt;
 *     &lt;element name="GeocodedAddress" type="xls:GeocodedAddressType" maxOccurs="unbounded"&gt;
 *       &lt;annotation&gt;
 *         &lt;documentation&gt;The list of 1-n addresses that are returned for each Address 
 *         request, sorted by Accuracy.&lt;/documentation&gt;
 *       &lt;/annotation&gt;
 *     &lt;/element&gt;
 *   &lt;/sequence&gt;
 *   &lt;attribute name="numberOfGeocodedAddresses" type="nonNegativeInteger" use="required"&gt;
 *     &lt;annotation&gt;
 *       &lt;documentation&gt;This is the number of responses generated per the different requests. 
 *       Within each geocoded address it's possible to have multiple candidates.&lt;/documentation&gt;
 *     &lt;/annotation&gt;
 *   &lt;/attribute&gt;
 * &lt;/complexType&gt;
 * 
 * </pre>
 * 
 * @author mprins
 * @since 1.7
 */
public class GeocodeResponseList implements XmlNamespaceConstants {

	/** serialisation id. */
	private static final long serialVersionUID = 6830914161263736467L;

	/** The geocoded address. */
	private final Vector<GeocodedAddress> geocodedAddress = new Vector<>();

	/** The number of geocoded addresses. */
	private int numberOfGeocodedAddresses;

	/**
	 * Adds the geocoded address.
	 * 
	 * @param val
	 *            the val
	 */
	public void addGeocodedAddress(GeocodedAddress val) {
		this.geocodedAddress.add(val);
	}

	/**
	 * Gets the geocoded address at.
	 * 
	 * @param i
	 *            the i
	 * @return the geocoded address at
	 */
	public GeocodedAddress getGeocodedAddressAt(int i) {
		return this.geocodedAddress.get(i);
	}

	/**
	 * Gets the geocoded address size.
	 * 
	 * @return the geocoded address size
	 */
	public int getGeocodedAddressSize() {
		return this.geocodedAddress.size();
	}

	/**
	 * Sets the number of geocoded addresses.
	 * 
	 * @param val
	 *            the new number of geocoded addresses
	 */
	public void setNumberOfGeocodedAddresses(int val) {
		this.numberOfGeocodedAddresses = val;
	}

	/**
	 * Gets the number of geocoded addresses.
	 * 
	 * @return the number of geocoded addresses
	 */
	public int getNumberOfGeocodedAddresses() {
		return this.numberOfGeocodedAddresses;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.mineleni.openls.XmlNamespaceConstants#toXML()
	 */
	@Override
	public String toXML() {
		final StringBuilder sb = new StringBuilder("<"
				+ XmlNamespaceConstants.OPENLS_NAMESPACE_PREFIX
				+ ":GeocodeResponseList " + "numberOfGeocodedAddresses=\""
				+ Integer.toString(this.getGeocodedAddressSize()) + "\">");
		for (final GeocodedAddress gca : this.geocodedAddress) {
			sb.append(gca.toXML());
		}
		sb.append("</" + XmlNamespaceConstants.OPENLS_NAMESPACE_PREFIX
				+ ":GeocodeResponseList>");
		return sb.toString();
	}
}
