package nl.mineleni.openls.databinding.openls;

import nl.mineleni.openls.XmlNamespaceConstants;

/**
 * OLS StreetAddress. http://schemas.opengis.net/ols/1.2.0/ADT.xsd
 * 
 * <pre>
 * 
 * &lt;complexType name="StreetAddressType"&gt;
 *   &lt;annotation&gt;
 *     &lt;documentation&gt;A set of precise and complete data elements that
 *     cannot be subdivided and that describe the physical location of
 *     a place.&lt;/documentation&gt;
 *   &lt;/annotation&gt;
 *   &lt;sequence&gt;
 *     &lt;element ref="xls:_StreetLocation" minOccurs="0" /&gt;
 *     &lt;element ref="xls:Street" maxOccurs="unbounded" /&gt;
 *   &lt;/sequence&gt;
 *   &lt;attribute name="locator"&gt;
 *     &lt;annotation&gt;
 *       &lt;documentation&gt;typically used for the street number (e.g. 23)
 *       a. Can accommodate a number, or any other building locator b.
 *       "windmill house", "24E" and "323" are acceptable uses of the
 *       locator c. We will adopt the following conventions for
 *       representing address ranges in the locator attribute: i.
 *       Discontinuous range example: "1-9" means 1,3,5,7,9 ii. Two
 *       discontinous ranges: "1-9,2-10" implies 1,3,5,7,9 on one side
 *       of block and 2,4,6,8,10 on other side of block iii.
 *       Continuous range: "1...10" means
 *       1,2,3,4,5,6,7,8,9,10&lt;/documentation&gt;
 *     &lt;/annotation&gt;
 *   &lt;/attribute&gt;
 * &lt;/complexType&gt;
 * &lt;element name="StreetAddress" type="xls:StreetAddressType"&gt;
 *   &lt;annotation&gt;
 *     &lt;documentation&gt;Structured street address.&lt;/documentation&gt;
 *   &lt;/annotation&gt;
 * &lt;/element&gt;
 * 
 * </pre>
 * 
 * @author Mark
 */
public class StreetAddress implements XmlNamespaceConstants {
	/**
	 * serialization id.
	 */
	private static final long serialVersionUID = 4263464123444246781L;

	/** The building. */
	private Building building;

	/** The street. */
	private Street street;

	/** The has building. */
	private boolean hasBuilding;

	/** If this address has a street. */
	private boolean hasStreet;

	/**
	 * Instantiates a new street address.
	 */
	public StreetAddress() {
		this.hasBuilding = false;
		this.hasStreet = false;
	}

	/**
	 * Sets the building.
	 * 
	 * @param building
	 *            the new building
	 */
	public void setBuilding(final Building building) {
		this.hasBuilding = true;
		this.building = building;
	}

	/**
	 * Gets the building.
	 * 
	 * @return the building
	 */
	public Building getBuilding() {
		return this.building;
	}

	/**
	 * Checks for building.
	 * 
	 * @return true, if successful
	 */
	public boolean hasBuilding() {
		return this.hasBuilding;
	}

	/**
	 * Sets the street.
	 * 
	 * @param street
	 *            the new street
	 */
	public void setStreet(final Street street) {
		this.hasStreet = true;
		this.street = street;
	}

	/**
	 * Gets the street.
	 * 
	 * @return the street
	 */
	public Street getStreet() {
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
				+ ":StreetAddress>";
		if (this.hasBuilding()) {
			xml += this.building.toXML();
		}
		if (this.hasStreet()) {
			xml += this.street.toXML();
		}
		xml += "</" + XmlNamespaceConstants.OPENLS_NAMESPACE_PREFIX
				+ ":StreetAddress>";
		return xml;
	}
}
