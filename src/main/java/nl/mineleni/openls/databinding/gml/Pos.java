/*
 * Copyright (c) 2012-2014, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie.
 */
package nl.mineleni.openls.databinding.gml;

import nl.mineleni.openls.XmlNamespaceConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * GML Pos. Beschrijft het Pos element uit GML 3.2.1.
 * http://schemas.opengis.net/gml/3.2.1/geometryBasic0d1d.xsd
 * 
 * <pre>
 * 
 * &lt;complexType name="DirectPositionType"&gt;
 *   &lt;annotation&gt;
 *     &lt;documentation&gt;Direct position instances hold the coordinates
 *     for a position within some coordinate reference system (CRS).
 *     Since direct positions, as data types, will often be included
 *     in larger objects (such as geometry elements) that have
 *     references to CRS, the srsName attribute will in general be
 *     missing, if this particular direct position is included in a
 *     larger element with such a reference to a CRS. In this case,
 *     the CRS is implicitly assumed to take on the value of the
 *     containing object's CRS. if no srsName attribute is given, the
 *     CRS shall be specified as part of the larger context this
 *     geometry element is part of, typically a geometric object like
 *     a point, curve, etc.&lt;/documentation&gt;
 *   &lt;/annotation&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="gml:doubleList"&gt;
 *       &lt;attributeGroup ref="gml:SRSReferenceGroup" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * &lt;element name="pos" type="gml:DirectPositionType" /&gt;
 * 
 * </pre>
 * 
 * @author Mark
 */
public class Pos implements XmlNamespaceConstants {
	/**
	 * serialisation id.
	 */
	private static final long serialVersionUID = -1063398145364381070L;

	/** logger. */
	private static final Logger LOGGER = LoggerFactory.getLogger(Pos.class);

	/** The x. */
	private Double x;

	/** The y. */
	private Double y;

	/** The dimension. */
	private int dimension;

	/** The has x. */
	private boolean hasX;

	/** The has y. */
	private boolean hasY;

	/** The has xy. */
	private boolean hasXY;

	/** The has dimension. */
	private boolean hasDimension;

	/**
	 * Instantiates a new pos.
	 */
	public Pos() {
		this.hasX = false;
		this.hasY = false;
		this.hasXY = false;
		this.hasDimension = false;
	}

	/**
	 * Sets the xy.
	 * 
	 * @param xy
	 *            the new xy
	 */
	public void setXY(final String xy) {
		try {
			final String[] xySplit = xy.split(" ");
			if (xySplit.length == 2) {
				this.setX(Double.parseDouble(xySplit[0]));
				this.setY(Double.parseDouble(xySplit[1]));
			}
			this.hasXY = true;
		} catch (final NumberFormatException e) {
			LOGGER.error("Verwerken van puntlocatie mislukt, waarde: " + xy
					+ ": ", e);
		}
	}

	/**
	 * Sets the x.
	 * 
	 * @param x
	 *            the new x
	 */
	public void setX(final Double x) {
		this.hasX = true;
		if (this.hasY) {
			this.hasXY = true;
		}
		this.x = x;
	}

	/**
	 * Gets the x.
	 * 
	 * @return the x
	 */
	public Double getX() {
		return this.x;
	}

	/**
	 * Sets the y.
	 * 
	 * @param y
	 *            the new y
	 */
	public void setY(final Double y) {
		this.hasY = true;
		if (this.hasX) {
			this.hasXY = true;
		}
		this.y = y;
	}

	/**
	 * Gets the y.
	 * 
	 * @return the y
	 */
	public Double getY() {
		return this.y;
	}

	/**
	 * Gets the xy.
	 * 
	 * @return the xy
	 */
	public String getXY() {
		return this.x.toString() + " " + this.y.toString();
	}

	/**
	 * Checks for xy.
	 * 
	 * @return true, if successful
	 */
	public boolean hasXY() {
		return this.hasXY;
	}

	/**
	 * Sets the dimension.
	 * 
	 * @param dimension
	 *            the new dimension
	 */
	public void setDimension(final int dimension) {
		this.hasDimension = true;
		this.dimension = dimension;
	}

	/**
	 * Gets the dimension.
	 * 
	 * @return the dimension
	 */
	public int getDimension() {
		return this.dimension;
	}

	/**
	 * Checks for dimension.
	 * 
	 * @return true, if successful
	 */
	public boolean hasDimension() {
		return this.hasDimension;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.mineleni.openls.XmlNamespaceConstants#toXML()
	 */
	@Override
	public String toXML() {
		String xml = "<" + XmlNamespaceConstants.OGC_GML_NAMESPACE_PREFIX
				+ ":pos";
		if (this.hasDimension()) {
			xml += " dimension=\"" + this.getDimension() + "\"";
		}
		xml += ">";
		if (this.hasXY()) {
			xml += this.getXY();
		}
		xml += "</" + XmlNamespaceConstants.OGC_GML_NAMESPACE_PREFIX + ":pos>";
		return xml;
	}
}
