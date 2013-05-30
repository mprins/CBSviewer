/*
 * Copyright (c) 2013, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie.
 */
package nl.mineleni.openls.databinding.openls;

import nl.mineleni.openls.XmlNamespaceConstants;
import nl.mineleni.openls.databinding.gml.Point;

public class ReverseGeocodedLocation implements XmlNamespaceConstants {
	/** serialization id. */
	private static final long serialVersionUID = 3193746470316264818L;
	private Point point;
	private Address address;
	private SearchCentreDistance searchCentreDistance;

	/**
	 * @return the point
	 */
	public Point getPoint() {
		return point;
	}

	/**
	 * @param point
	 *            the point to set
	 */
	public void setPoint(Point point) {
		this.point = point;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the searchCentreDistance
	 */
	public SearchCentreDistance getSearchCentreDistance() {
		return searchCentreDistance;
	}

	/**
	 * @param searchCentreDistance
	 *            the searchCentreDistance to set
	 */
	public void setSearchCentreDistance(
			SearchCentreDistance searchCentreDistance) {
		this.searchCentreDistance = searchCentreDistance;
	}

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
