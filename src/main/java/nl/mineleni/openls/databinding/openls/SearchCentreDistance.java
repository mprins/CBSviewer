/*
 * Copyright (c) 2013, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie.
 */
package nl.mineleni.openls.databinding.openls;

import nl.mineleni.openls.XmlNamespaceConstants;

public class SearchCentreDistance implements XmlNamespaceConstants {
	/** serialisation id. */
	private static final long serialVersionUID = 6413552036187763149L;
	private String uom = null;
	private double value = Double.NaN;
	private double accuracy = Double.NaN;

	/**
	 * @return the uom
	 */
	public String getUom() {
		return uom;
	}

	/**
	 * @param uom
	 *            the uom to set
	 */
	public void setUom(String uom) {
		this.uom = uom;
	}

	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * @return the accuracy
	 */
	public double getAccuracy() {
		return accuracy;
	}

	/**
	 * @param accuracy
	 *            the accuracy to set
	 */
	public void setAccuracy(double accuracy) {
		this.accuracy = accuracy;
	}

	@Override
	public String toXML() {
		// <xls:SearchCentreDistance uom="M" value="115.6" />
		StringBuilder sb = new StringBuilder("<");
		sb.append(XmlNamespaceConstants.OPENLS_NAMESPACE_PREFIX);
		sb.append(":SearchCentreDistance");

		if (this.uom != null) {
			sb.append(" uom=\"");
			sb.append(uom);
			sb.append("\"");
		}

		if (!Double.isNaN(this.value)) {
			sb.append(" value=\"");
			sb.append(value);
			sb.append("\"");
		}

		if (!Double.isNaN(this.accuracy)) {
			sb.append(" accuracy=\"");
			sb.append(accuracy);
			sb.append("\"");
		}
		sb.append(" />");

		return sb.toString();
	}
}
