/*
 * Copyright (c) 2013, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie.
 */
package nl.mineleni.openls.databinding.openls;

import nl.mineleni.openls.XmlNamespaceConstants;

/**
 * OLS ReverseGeocodeRequest.
 * http://schemas.opengis.net/ols/1.2.0/LocationUtilityService.xsd
 * 
 * <pre>
 * &lt;element name="ReverseGeocodeRequest" type="xls:ReverseGeocodeRequestType" substitutionGroup="xls:_RequestParameters"&gt;
 * 	&lt;annotation&gt;
 * 		&lt;documentation&gt;Reverse Geocode Service Request&lt;/documentation&gt;
 * 	&lt;/annotation&gt;
 * &lt;/element&gt;
 * 
 * &lt;complexType name="ReverseGeocodeRequestType"&gt;
 * 	&lt;annotation&gt;
 * 		&lt;documentation&gt;Reverse Geocode Request.&lt;/documentation&gt;
 * 	&lt;/annotation&gt;
 * 	&lt;complexContent&gt;
 * 	&lt;extension base="xls:AbstractRequestParametersType"&gt;
 * 	&lt;sequence&gt;
 * 		&lt;element ref="xls:Position"/&gt;
 * 		&lt;element ref="xls:ReverseGeocodePreference" minOccurs="0" maxOccurs="unbounded"/&gt;
 * 	&lt;/sequence&gt;
 * 	&lt;/extension&gt;
 * 	&lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * 
 * </pre>
 * 
 * @author prinsmc
 * @since 1.7
 */
public class ReverseGeocodeRequest implements XmlNamespaceConstants {

	/**
	 * serialization id.
	 */
	private static final long serialVersionUID = 9041529530016571218L;

	/**
	 * reverse geocoding voorkeur.
	 */
	private ReverseGeocodePreference reverseGeocodePreference;

	/**
	 * reverse geocoding positie.
	 */
	private Position position;

	/**
	 * @return the reverseGeocodePreference
	 */
	public ReverseGeocodePreference getReverseGeocodePreference() {
		return reverseGeocodePreference;
	}

	/**
	 * @param reverseGeocodePreference
	 *            the reverseGeocodePreference to set
	 */
	public void setReverseGeocodePreference(
			final ReverseGeocodePreference reverseGeocodePreference) {
		this.reverseGeocodePreference = reverseGeocodePreference;
	}

	/**
	 * @return the position
	 */
	public Position getPosition() {
		return position;
	}

	/**
	 * set de positie voor dit verzoek.
	 * 
	 * @param position
	 *            positie
	 */
	public void setPosition(final Position position) {
		this.position = position;
	}

	@Override
	public String toXML() {
		final StringBuilder sb = new StringBuilder("<"
				+ XmlNamespaceConstants.OPENLS_NAMESPACE_PREFIX
				+ ":ReverseGeocodeRequest " + "xmlns:"
				+ XmlNamespaceConstants.OPENLS_NAMESPACE_PREFIX + "=\""
				+ XmlNamespaceConstants.OPENLS_NAMESPACE_URI + "\" " + "xmlns:"
				+ XmlNamespaceConstants.OGC_GML_NAMESPACE_PREFIX + "=\""
				+ XmlNamespaceConstants.OGC_GML_NAMESPACE_URI + "\" "
				+ XmlNamespaceConstants.OPENLS_NAMESPACE_SCHEMALOCATION + ">");

		sb.append(position.toXML());
		if (null != reverseGeocodePreference) {
			sb.append(reverseGeocodePreference.toXML());
		}

		sb.append("</" + XmlNamespaceConstants.OPENLS_NAMESPACE_PREFIX
				+ ":ReverseGeocodeRequest>");
		return sb.toString();
	}

}
