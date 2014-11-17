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
 * The Class Position.
 */
public class Position implements XmlNamespaceConstants {

	/**
	 * serialization id.
	 */
	private static final long serialVersionUID = 3277635883084761942L;

	/** point dat deze positie beschrijft. */
	private Point point;

	/**
	 * Gets the point dat deze positie beschrijft.
	 *
	 * @return the point
	 */
	public Point getPoint() {
		return point;
	}

	/**
	 * Sets the point dat deze positie beschrijft.
	 *
	 * @param point
	 *            the point to set
	 */
	public void setPoint(final Point point) {
		this.point = point;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.mineleni.openls.XmlNamespaceConstants#toXML()
	 */
	@Override
	public String toXML() {
		final StringBuilder sb = new StringBuilder("<"
				+ XmlNamespaceConstants.OPENLS_NAMESPACE_PREFIX + ":Position>");
		sb.append(this.point.toXML());
		sb.append("</" + XmlNamespaceConstants.OPENLS_NAMESPACE_PREFIX
				+ ":Position>");
		return sb.toString();
	}

}
