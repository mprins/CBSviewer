package nl.mineleni.openls.databinding.openls;

import java.util.Vector;

import nl.mineleni.openls.XmlNamespaceConstants;

/**
 * OLS GeocodeResponse.
 * http://schemas.opengis.net/ols/1.2.0/LocationUtilityService.xsd
 * 
 * <pre>
 * 
 *  &lt;complexType name="GeocodeResponseType"&gt;
 *   &lt;annotation&gt;
 *     &lt;documentation&gt;GeocodeResponse. The addresses returned will be normalized 
 *     Address ADTs as a result of any parsing by the geocoder, etc.&lt;/documentation&gt;
 *   &lt;/annotation&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="xls:AbstractResponseParametersType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element ref="xls:GeocodeResponseList" maxOccurs="unbounded" /&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * 
 * </pre>
 * 
 * @author Mark
 * @since 1.7
 */
public class GeocodeResponse implements XmlNamespaceConstants {
	/**
	 * serialization id.
	 */
	private static final long serialVersionUID = -8343502033013447204L;

	/** The geocode response list. */
	private final Vector<GeocodeResponseList> geocodeResponseList = new Vector<>();

	/**
	 * Adds the geocode response list.
	 * 
	 * @param val
	 *            the val
	 */
	public void addGeocodeResponseList(GeocodeResponseList val) {
		this.geocodeResponseList.add(val);
	}

	/**
	 * Gets the geocode response list at.
	 * 
	 * @param i
	 *            the i
	 * @return the geocode response list at
	 */
	public GeocodeResponseList getGeocodeResponseListAt(int i) {
		return this.geocodeResponseList.get(i);
	}

	/**
	 * Gets the geocode response list size.
	 * 
	 * @return the geocode response list size
	 */
	public int getGeocodeResponseListSize() {
		return this.geocodeResponseList.size();
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
				+ ":GeocodeResponse " + "xmlns:"
				+ XmlNamespaceConstants.OPENLS_NAMESPACE_PREFIX + "=\""
				+ XmlNamespaceConstants.OPENLS_NAMESPACE_URI + "\" " + "xmlns:"
				+ XmlNamespaceConstants.OGC_GML_NAMESPACE_PREFIX + "=\""
				+ XmlNamespaceConstants.OGC_GML_NAMESPACE_URI + "\">");
		for (final GeocodeResponseList gcrl : this.geocodeResponseList) {
			sb.append(gcrl.toXML());
		}
		sb.append("</" + XmlNamespaceConstants.OPENLS_NAMESPACE_PREFIX
				+ ":GeocodeResponse>");
		return sb.toString();
	}
}
