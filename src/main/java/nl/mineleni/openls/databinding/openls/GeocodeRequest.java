package nl.mineleni.openls.databinding.openls;

import java.util.Vector;

import nl.mineleni.openls.XmlNamespaceConstants;

/**
 * http://schemas.opengis.net/ols/1.2.0/LocationUtilityService.xsd
 * 
 * <pre>
 * 
 * &lt;element name="GeocodeRequest" type="xls:GeocodeRequestType" substitutionGroup="xls:_RequestParameters"> 
 *  &lt;annotation>
 *      &lt;documentation>Geocode Service Request&lt;/documentation> 
 *  &lt;/annotation>
 * &lt;/element> 
 * 
 * &lt;complexType name="GeocodeRequestType"> 
 * &lt;annotation>
 *      &lt;documentation>Geocode Request.&lt;/documentation> 
 * &lt;/annotation>
 * &lt;complexContent> 
 *  &lt;extension base="xls:AbstractRequestParametersType">
 *  &lt;sequence> 
 *      &lt;element ref="xls:Address" maxOccurs="unbounded"/> 
 *  &lt;/sequence>
 *  &lt;attribute name="returnFreeForm" type="boolean" use="optional" default="false"> 
 *      &lt;annotation> 
 *          &lt;documentation>Used to request freeform addresses in the response, as 
 *          opposed to structured adddresses&lt;/documentation> 
 *      &lt;/annotation> 
 *  &lt;/attribute> 
 * &lt;/extension>
 * &lt;/complexContent>
 * &lt;/complexType>
 * 
 * </pre>
 * 
 * @author mprins
 * @since 1.6
 */
public class GeocodeRequest implements XmlNamespaceConstants {
	/**
	 * serialization id.
	 */
	private static final long serialVersionUID = -1347583150356760221L;
	/** interne adres lijst. */
	private final Vector<Address> addressList = new Vector<Address>();

	/**
	 * Adds the address.
	 * 
	 * @param val
	 *            the val
	 */
	public void addAddress(final Address val) {
		this.addressList.add(val);
	}

	/**
	 * Gets the address at.
	 * 
	 * @param i
	 *            the i
	 * @return the address at
	 */
	public Address getAddressAt(final int i) {
		return this.addressList.get(i);
	}

	/**
	 * Gets the address size.
	 * 
	 * @return the address size
	 */
	public int getAddressSize() {
		return this.addressList.size();
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
				+ ":GeocodeRequest " + "xmlns:"
				+ XmlNamespaceConstants.OPENLS_NAMESPACE_PREFIX + "=\""
				+ XmlNamespaceConstants.OPENLS_NAMESPACE_URI + "\" " + "xmlns:"
				+ XmlNamespaceConstants.OGC_GML_NAMESPACE_PREFIX + "=\""
				+ XmlNamespaceConstants.OGC_GML_NAMESPACE_URI + "\">");
		for (final Address addrl : this.addressList) {
			sb.append(addrl.toXML());
		}
		sb.append("</" + XmlNamespaceConstants.OPENLS_NAMESPACE_PREFIX
				+ ":GeocodeRequest>");
		return sb.toString();
	}
}
