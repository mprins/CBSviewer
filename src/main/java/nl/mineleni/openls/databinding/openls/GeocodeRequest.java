package nl.mineleni.openls.databinding.openls;

import java.util.Vector;

import nl.mineleni.openls.XmlNamespaceConstants;

/**
 * OLS GeocodeRequest.
 * http://schemas.opengis.net/ols/1.2.0/LocationUtilityService.xsd
 * 
 * <pre>
 * 
 * &lt;element name="GeocodeRequest" type="xls:GeocodeRequestType" 
 * 		substitutionGroup="xls:_RequestParameters"&gt; 
 *  &lt;annotation&gt;
 *      &lt;documentation&gt;Geocode Service Request&lt;/documentation&gt; 
 *  &lt;/annotation&gt;
 * &lt;/element&gt; 
 * 
 * &lt;complexType name="GeocodeRequestType"&gt; 
 * &lt;annotation&gt;
 *      &lt;documentation&gt;Geocode Request.&lt;/documentation&gt; 
 * &lt;/annotation&gt;
 * &lt;complexContent&gt; 
 *  &lt;extension base="xls:AbstractRequestParametersType"&gt;
 *  &lt;sequence&gt; 
 *      &lt;element ref="xls:Address" maxOccurs="unbounded"/&gt; 
 *  &lt;/sequence&gt;
 *  &lt;attribute name="returnFreeForm" type="boolean" use="optional" default="false"&gt; 
 *      &lt;annotation&gt; 
 *          &lt;documentation&gt;Used to request freeform addresses in the response, as 
 *          opposed to structured adddresses&lt;/documentation&gt; 
 *      &lt;/annotation&gt; 
 *  &lt;/attribute&gt; 
 * &lt;/extension&gt;
 * &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * 
 * </pre>
 * 
 * @author mprins
 * @since 1.7
 */
public class GeocodeRequest implements XmlNamespaceConstants {
	/**
	 * serialization id.
	 */
	private static final long serialVersionUID = -1347583150356760221L;
	/** interne adres lijst. */
	private final Vector<Address> addressList = new Vector<>();

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
