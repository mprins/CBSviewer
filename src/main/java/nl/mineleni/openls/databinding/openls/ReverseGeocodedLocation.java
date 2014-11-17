/*
 * Copyright (c) 2013-2014, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie.
 */
package nl.mineleni.openls.databinding.openls;

import nl.mineleni.openls.XmlNamespaceConstants;
import nl.mineleni.openls.databinding.gml.Point;

/**
 * The Class ReverseGeocodedLocation.
 */
public class ReverseGeocodedLocation implements XmlNamespaceConstants {
	/** serialization id. */
	private static final long serialVersionUID = 3193746470316264818L;
	/** te coderen punt. */
	private Point point;
	/** resultaat adres. */
	private Address address;
	/** zoek afstand. */
	private SearchCentreDistance searchCentreDistance;

	/**
	 * Gets the te coderen punt.
	 *
	 * @return the point
	 */
	public Point getPoint() {
		return point;
	}

	/**
	 * Sets the te coderen punt.
	 *
	 * @param point
	 *            the point to set
	 */
	public void setPoint(final Point point) {
		this.point = point;
	}

	/**
	 * Gets the resultaat adres.
	 *
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * Sets the resultaat adres.
	 *
	 * @param address
	 *            the address to set
	 */
	public void setAddress(final Address address) {
		this.address = address;
	}

	/**
	 * Gets the zoek afstand.
	 *
	 * @return the searchCentreDistance
	 */
	public SearchCentreDistance getSearchCentreDistance() {
		return searchCentreDistance;
	}

	/**
	 * Sets the zoek afstand.
	 *
	 * @param searchCentreDistance
	 *            the searchCentreDistance to set
	 */
	public void setSearchCentreDistance(
			final SearchCentreDistance searchCentreDistance) {
		this.searchCentreDistance = searchCentreDistance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.mineleni.openls.XmlNamespaceConstants#toXML()
	 */
	@Override
	public String toXML() {
		StringBuilder sb = new StringBuilder("<");
		sb.append(XmlNamespaceConstants.OPENLS_NAMESPACE_PREFIX);
		sb.append(":ReverseGeocodedLocation>");

		sb.append(this.point.toXML());
		sb.append(this.address.toXML());
		sb.append(this.searchCentreDistance.toXML());

		sb.append("</");
		sb.append(XmlNamespaceConstants.OPENLS_NAMESPACE_PREFIX);
		sb.append(":ReverseGeocodedLocation>");
		return sb.toString();
	}

}
