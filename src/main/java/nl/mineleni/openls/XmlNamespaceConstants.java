package nl.mineleni.openls;

import java.io.Serializable;

/**
 * The Interface XmlNamespaceConstants.
 */
public interface XmlNamespaceConstants extends Serializable {

	/** De constante OPENLS_NAMESPACE_URI. {@value} */
	String OPENLS_NAMESPACE_URI = "http://www.opengis.net/xls";

	/** De constante OPENLS_NAMESPACE_SCHEMALOCATION. {@value} */
	String OPENLS_NAMESPACE_SCHEMALOCATION = "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\""
			+ OPENLS_NAMESPACE_URI
			+ " http://schemas.opengis.net/ols/1.1.0/LocationUtilityService.xsd\"";

	/** De constante OPENLS_NAMESPACE_PREFIX. {@value} */
	String OPENLS_NAMESPACE_PREFIX = "xls";

	/** De constante OGC_GML_NAMESPACE_URI. {@value} */
	String OGC_GML_NAMESPACE_URI = "http://www.opengis.net/gml";
	// String OGC_GML_NAMESPACE_URI = "http://www.opengis.net/gml/3.2";

	/** De constante OGC_GML_NAMESPACE_PREFIX. {@value} */
	String OGC_GML_NAMESPACE_PREFIX = "gml";

	/**
	 * geeft een XML string representatie van dit object.
	 * 
	 * @return een XML string die dit object beschrijft
	 */
	String toXML();
}
