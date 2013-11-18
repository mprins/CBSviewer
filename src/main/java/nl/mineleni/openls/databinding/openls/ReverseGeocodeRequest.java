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
 * &lt;element name="ReverseGeocodeRequest" type="xls:ReverseGeocodeRequestType" substitutionGroup="xls:_RequestParameters">
 * 	&lt;annotation>
 * 		&lt;documentation>Reverse Geocode Service Request</documentation>
 * 	&lt;/annotation>
 * &lt;/element>
 * 
 * &lt;complexType name="ReverseGeocodeRequestType">
 * 	&lt;annotation>
 * 		&lt;documentation>Reverse Geocode Request.&lt;/documentation>
 * 	&lt;/annotation>
 * 	&lt;complexContent>
 * 	&lt;extension base="xls:AbstractRequestParametersType">
 * 	&lt;sequence>
 * 		&lt;element ref="xls:Position"/>
 * 		&lt;element ref="xls:ReverseGeocodePreference" minOccurs="0" maxOccurs="unbounded"/>
 * 	&lt;/sequence>
 * 	&lt;/extension>
 * 	&lt;/complexContent>
 * &lt;/complexType>
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
			ReverseGeocodePreference reverseGeocodePreference) {
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
	 */
	public void setPosition(Position position) {
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
		sb.append(reverseGeocodePreference.toXML());

		sb.append("</" + XmlNamespaceConstants.OPENLS_NAMESPACE_PREFIX
				+ ":ReverseGeocodeRequest>");
		return sb.toString();
	}

}
