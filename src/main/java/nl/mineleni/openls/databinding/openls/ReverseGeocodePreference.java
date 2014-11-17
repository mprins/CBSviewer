/*
 * Copyright (c) 2013-2014, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie.
 */
package nl.mineleni.openls.databinding.openls;

import nl.mineleni.openls.XmlNamespaceConstants;

/**
 * OLS ReverseGeocodePreference.
 * http://schemas.opengis.net/ols/1.2.0/LocationUtilityService.xsd
 * 
 * <pre>
 * &lt;simpleType name="ReverseGeocodePreferenceType"&gt;
 * &lt;annotation&gt;
 * 	&lt;documentation&gt;Defines a Preference for Reverse Geocode response.&lt;/documentation&gt;
 * &lt;/annotation&gt;
 * &lt;restriction base="string"&gt;
 * &lt;enumeration value="StreetAddress"/&gt;
 * &lt;enumeration value="IntersectionAddress"/&gt;
 * &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * &lt;element name="ReverseGeocodePreference" type="xls:ReverseGeocodePreferenceType"&gt;
 * &lt;annotation&gt;
 * 	&lt;documentation&gt;Describes the preference for what the Reverse Geocoder service should return: 
 * 	StreetAddress, IntersectionAddress, or PositionOfInterest (Place and/or PostalCode). 
 * 	If not specified, then the service will return the nearest StreetAddress. .
 * 	&lt;/documentation&gt;
 * &lt;/annotation&gt;
 * &lt;/element&gt;
 * </pre>
 * 
 * @author prinsmc
 * 
 */
public class ReverseGeocodePreference implements XmlNamespaceConstants {

	/**
	 * serialization id.
	 */
	private static final long serialVersionUID = -7570918027344077813L;
	/** geocodeer voorkeur. */
	private String preference;

	/**
	 * The Enum PREFERENCE.
	 */
	public enum PREFERENCE {

		/** The Street address. */
		StreetAddress("StreetAddress"),
		/** The Intersection address. */
		IntersectionAddress("IntersectionAddress"),
		/** The Position of interest. */
		PositionOfInterest("PositionOfInterest");

		/** The preference. */
		public final String preference;

		/**
		 * Instantiates a new preference.
		 *
		 * @param preference
		 *            the preference
		 */
		PREFERENCE(final String preference) {
			this.preference = preference;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Enum#toString()
		 */
		@Override
		public String toString() {
			return this.preference;
		}
	}

	/**
	 * Gets the geocodeer voorkeur.
	 *
	 * @return the preference
	 */
	public String getPreference() {
		return preference;
	}

	/**
	 * set gewenste preference.
	 * 
	 * @param preference
	 *            de preference
	 */
	public void setPreference(final String preference) {
		this.preference = preference;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.mineleni.openls.XmlNamespaceConstants#toXML()
	 */
	@Override
	public String toXML() {
		if (this.preference != null) {
			final StringBuilder sb = new StringBuilder("<"
					+ XmlNamespaceConstants.OPENLS_NAMESPACE_PREFIX
					+ ":ReverseGeocodePreference>");
			sb.append(this.preference);
			sb.append("</" + XmlNamespaceConstants.OPENLS_NAMESPACE_PREFIX
					+ ":ReverseGeocodePreference>");
			return sb.toString();
		}
		return "";
	}

}
