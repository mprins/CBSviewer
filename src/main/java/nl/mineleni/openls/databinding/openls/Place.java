package nl.mineleni.openls.databinding.openls;

import nl.mineleni.openls.XmlNamespaceConstants;

/**
 * OLS Place. http://schemas.opengis.net/ols/1.2.0/ADT.xsd
 * 
 * <pre>
 * 
 *  &lt;element name="Place" type="xls:NamedPlaceType">
 *   &lt;annotation>
 *     &lt;documentation>Place represents a hierarchical set of
 *     geographic regions/placenames: country subdivision, country
 *     secondary subdivision, municipality, and municipality
 *     subdivision.&lt;/documentation>
 *   &lt;/annotation>
 * &lt;/element>
 * &lt;complexType name="NamedPlaceType">
 *   &lt;annotation>
 *     &lt;documentation>The NamedPlaceType defines a named place within
 *     an AddressType. A named place has a classification (such as
 *     country, country subdivision, or municipality).&lt;/documentation>
 *   &lt;/annotation>
 *   &lt;simpleContent>
 *     &lt;extension base="string">
 *       &lt;attribute name="type" type="xls:NamedPlaceClassification" use="required" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * 
 * </pre>
 * 
 * @author mprins
 */
public class Place implements XmlNamespaceConstants {
	/**
	 * serialization id.
	 */
	private static final long serialVersionUID = -3969318615339164005L;

	/** The type. */
	private String type;

	/** The place. */
	private String place;

	/** The has type. */
	private boolean hasType;

	/** The has place. */
	private boolean hasPlace;

	/**
	 * Instantiates a new place.
	 */
	public Place() {
		this.hasType = false;
		this.hasPlace = false;
	}

	/**
	 * Sets the type.
	 * 
	 * @param type
	 *            the new type
	 */
	public void setType(String type) {
		this.hasType = true;
		this.type = type;
	}

	/**
	 * Gets the type.
	 * 
	 * @return the type
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Checks for type.
	 * 
	 * @return true, if successful
	 */
	public boolean hasType() {
		return this.hasType;
	}

	/**
	 * Sets the place.
	 * 
	 * @param place
	 *            the new place
	 */
	public void setPlace(String place) {
		this.hasPlace = true;
		this.place = place;
	}

	/**
	 * Gets the place.
	 * 
	 * @return the place
	 */
	public String getPlace() {
		return this.place;
	}

	/**
	 * Checks for place.
	 * 
	 * @return true, if successful
	 */
	public boolean hasPlace() {
		return this.hasPlace;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.mineleni.openls.XmlNamespaceConstants#toXML()
	 */
	@Override
	public String toXML() {
		String xml = "<" + XmlNamespaceConstants.OPENLS_NAMESPACE_PREFIX
				+ ":Place";
		if (this.hasType()) {
			xml += " type=\"" + this.getType() + "\"";
		}
		xml += ">";
		if (this.hasPlace()) {
			xml += this.getPlace();
		}
		xml += "</" + XmlNamespaceConstants.OPENLS_NAMESPACE_PREFIX + ":Place>";
		return xml;
	}
}
