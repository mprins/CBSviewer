/*
 * Copyright (c) 2013, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie.
 */
package nl.mineleni.openls.databinding.openls;

import nl.mineleni.openls.XmlNamespaceConstants;

public class ReverseGeocodeResponse implements XmlNamespaceConstants {

	/** serialization id. */
	private static final long serialVersionUID = 8302539704859544403L;
	private ReverseGeocodedLocation reverseGeocodedLocation;

	/**
	 * @return the reverseGeocodedLocation
	 */
	public ReverseGeocodedLocation getReverseGeocodedLocation() {
		return reverseGeocodedLocation;
	}

	/**
	 * @param reverseGeocodedLocation
	 *            the reverseGeocodedLocation to set
	 */
	public void setReverseGeocodedLocation(
			ReverseGeocodedLocation reverseGeocodedLocation) {
		this.reverseGeocodedLocation = reverseGeocodedLocation;
	}

	@Override
	public String toXML() {
		final StringBuilder sb = new StringBuilder("<"
				+ XmlNamespaceConstants.OPENLS_NAMESPACE_PREFIX
				+ ":ReverseGeocodeResponse " + "xmlns:"
				+ XmlNamespaceConstants.OPENLS_NAMESPACE_PREFIX + "=\""
				+ XmlNamespaceConstants.OPENLS_NAMESPACE_URI + "\" " + "xmlns:"
				+ XmlNamespaceConstants.OGC_GML_NAMESPACE_PREFIX + "=\""
				+ XmlNamespaceConstants.OGC_GML_NAMESPACE_URI + "\" "
				+ XmlNamespaceConstants.OPENLS_NAMESPACE_SCHEMALOCATION + ">");

		sb.append(this.reverseGeocodedLocation.toXML());

		sb.append("</" + XmlNamespaceConstants.OPENLS_NAMESPACE_PREFIX
				+ ":ReverseGeocodeResponse>");
		return sb.toString();
	}

}