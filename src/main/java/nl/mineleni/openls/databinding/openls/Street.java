package nl.mineleni.openls.databinding.openls;

import nl.mineleni.openls.XmlNamespaceConstants;

/**
 * OLS Street. http://schemas.opengis.net/ols/1.2.0/ADT.xsd
 * 
 * <pre>
 * 
 * &lt;complexType name="StreetNameType"&gt;
 *   &lt;annotation&gt;
 *     &lt;documentation&gt;The data elements that make up the name of a
 *     street. There are two valid methods for encoding this
 *     information: 1). Use the structured elements and attributes.
 *     2). The element value may contain a simplified string (e.g.
 *     West 83rd. Street). An example: 
 *     &lt;Street directionalPrefix="W" officialName="83RD" typeSuffix="ST" /&gt;
 *     &lt;/documentation&gt;
 *   &lt;/annotation&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="string"&gt;
 *       &lt;attribute name="directionalPrefix" type="string" use="optional"&gt;
 *         &lt;annotation&gt;
 *           &lt;documentation&gt;The direction for a street (e.g., North),
 *           placed before the official name.&lt;/documentation&gt;
 *         &lt;/annotation&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="typePrefix" type="string" use="optional"&gt;
 *         &lt;annotation&gt;
 *           &lt;documentation&gt;The street type (e.g., Rd or Ave)
 *           specified before the official name&lt;/documentation&gt;
 *         &lt;/annotation&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="officialName" type="string" use="optional"&gt;
 *         &lt;annotation&gt;
 *           &lt;documentation&gt;The name for a street (e.g., Main).&lt;/documentation&gt;
 *         &lt;/annotation&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="typeSuffix" type="string" use="optional"&gt;
 *         &lt;annotation&gt;
 *           &lt;documentation&gt;The street type (e.g., Rd or Ave)
 *           specified after the official name&lt;/documentation&gt;
 *         &lt;/annotation&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="directionalSuffix" type="string" use="optional"&gt;
 *         &lt;annotation&gt;
 *           &lt;documentation&gt;The direction for a street (e.g., North),
 *           placed after the official name.&lt;/documentation&gt;
 *         &lt;/annotation&gt;
 *       &lt;/attribute&gt;
 *       &lt;attribute name="muniOctant" type="gml:CompassPointEnumeration" use="optional" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * &lt;element name="Street" type="xls:StreetNameType"&gt;
 *   &lt;annotation&gt;
 *     &lt;documentation&gt;Structured Street Name.&lt;/documentation&gt;
 *   &lt;/annotation&gt;
 * &lt;/element&gt;
 * 
 * </pre>
 * 
 * @author mprins
 */
public class Street implements XmlNamespaceConstants {
	/**
	 * serialization id.
	 */
	private static final long serialVersionUID = -7318834532989520351L;
	/** The name for a street (e.g., Main). */
	private String street;

	/** The has street. */
	private boolean hasStreet;

	/**
	 * Instantiates a new street.
	 */
	public Street() {
		this.hasStreet = false;
	}

	/**
	 * Sets the street.
	 * 
	 * @param street
	 *            the new street
	 */
	public void setStreet(final String street) {
		this.hasStreet = true;
		this.street = street;
	}

	/**
	 * Gets the street.
	 * 
	 * @return the street
	 */
	public String getStreet() {
		return this.street;
	}

	/**
	 * Checks for street.
	 * 
	 * @return true, if successful
	 */
	public boolean hasStreet() {
		return this.hasStreet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.mineleni.openls.XmlNamespaceConstants#toXML()
	 */
	@Override
	public String toXML() {
		String xml = "<" + XmlNamespaceConstants.OPENLS_NAMESPACE_PREFIX
				+ ":Street>";
		if (this.hasStreet()) {
			xml += this.getStreet();
		}
		xml += "</" + XmlNamespaceConstants.OPENLS_NAMESPACE_PREFIX
				+ ":Street>";
		return xml;
	}
}
