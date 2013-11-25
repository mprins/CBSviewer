/*
 * Copyright (c) 2012-2013, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie.
 */
package nl.mineleni.openls.databinding.gml;

import java.util.Vector;

import nl.mineleni.openls.XmlNamespaceConstants;

/**
 * GML Point. Beschrijft het Point element uit GML 3.2.1.
 * 
 * http://schemas.opengis.net/gml/3.2.1/geometryBasic0d1d.xsd
 * 
 * <pre>
 * 
 * &lt;complexType name="PointType">
 *   &lt;complexContent>
 *     &lt;extension base="gml:AbstractGeometricPrimitiveType">
 *       &lt;sequence>
 *         &lt;choice>
 *           &lt;element ref="gml:pos" />
 *           &lt;element ref="gml:coordinates" />
 *         &lt;/choice>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * 
 * </pre>
 * 
 * @author mprins
 * @since 1.7
 * @composed 1 - 0..* Pos
 */
public class Point implements XmlNamespaceConstants {

	/**
	 * serialisation id.
	 */
	private static final long serialVersionUID = -163863783181316506L;

	/** position list. */
	private final Vector<Pos> pos = new Vector<>();;

	/** The srs name. */
	private String srsName;

	/** The has srs name. */
	private boolean hasSrsName;

	/**
	 * Instantiates a new point.
	 */
	public Point() {
		this.hasSrsName = false;
	}

	/**
	 * Adds the pos.
	 * 
	 * @param p
	 *            the p
	 */
	public void addPos(Pos p) {
		this.pos.add(p);
	}

	/**
	 * Gets the pos at.
	 * 
	 * @param i
	 *            the i
	 * @return the pos at
	 */
	public Pos getPosAt(int i) {
		return this.pos.get(i);
	}

	/**
	 * Gets the pos size.
	 * 
	 * @return the pos size
	 */
	public int getPosSize() {
		return this.pos.size();
	}

	/**
	 * Sets the srs name.
	 * 
	 * @param srsName
	 *            the new srs name
	 */
	public void setSrsName(String srsName) {
		this.hasSrsName = true;
		this.srsName = srsName;
	}

	/**
	 * Gets the srs name.
	 * 
	 * @return the srs name
	 */
	public String getSrsName() {
		return this.srsName;
	}

	/**
	 * Checks for srs name.
	 * 
	 * @return true, if successful
	 */
	public boolean hasSrsName() {
		return this.hasSrsName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.mineleni.openls.XmlNamespaceConstants#toXML()
	 */
	@Override
	public String toXML() {
		final StringBuilder sb = new StringBuilder("<"
				+ XmlNamespaceConstants.OGC_GML_NAMESPACE_PREFIX + ":Point");

		if (this.hasSrsName()) {
			sb.append(" srsName=\"").append(this.getSrsName()).append("\"");
		}
		sb.append(">");
		for (final Pos p : this.pos) {
			sb.append(p.toXML());
		}
		sb.append("</" + XmlNamespaceConstants.OGC_GML_NAMESPACE_PREFIX
				+ ":Point>");
		return sb.toString();
	}
}
