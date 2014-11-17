/*
 * Copyright (c) 2013-2014, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie.
 */
package nl.mineleni.openls.databinding.openls;

import nl.mineleni.openls.XmlNamespaceConstants;

/**
 * The Class ReverseGeocodeResponse.
 */
public class ReverseGeocodeResponse implements XmlNamespaceConstants {

	/** serialization id. */
	private static final long serialVersionUID = 8302539704859544403L;

	/** de teruggerekende locatie. */
	private ReverseGeocodedLocation reverseGeocodedLocation;

	/**
	 * Gets the de teruggerekende locatie.
	 *
	 * @return the reverseGeocodedLocation
	 */
	public ReverseGeocodedLocation getReverseGeocodedLocation() {
		return reverseGeocodedLocation;
	}

	/**
	 * Sets the de teruggerekende locatie.
	 *
	 * @param reverseGeocodedLocation
	 *            the reverseGeocodedLocation to set
	 */
	public void setReverseGeocodedLocation(
			final ReverseGeocodedLocation reverseGeocodedLocation) {
		this.reverseGeocodedLocation = reverseGeocodedLocation;
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
