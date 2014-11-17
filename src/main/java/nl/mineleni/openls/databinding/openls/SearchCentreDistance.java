/*
 * Copyright (c) 2013-2014, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie.
 */
package nl.mineleni.openls.databinding.openls;

import nl.mineleni.openls.XmlNamespaceConstants;

/**
 * The Class SearchCentreDistance.
 */
public class SearchCentreDistance implements XmlNamespaceConstants {
	/** serialisation id. */
	private static final long serialVersionUID = 6413552036187763149L;

	/** The Units of Measure. */
	private String uom = null;

	/** The value. */
	private double value = Double.NaN;

	/** The accuracy. */
	private double accuracy = Double.NaN;

	/**
	 * Units of Measure accessor.
	 * 
	 * @return the uom
	 */
	public String getUom() {
		return uom;
	}

	/**
	 * Units of Measure setter.
	 * 
	 * @param uom
	 *            the uom to set
	 */
	public void setUom(final String uom) {
		this.uom = uom;
	}

	/**
	 * value accessor.
	 * 
	 * @return the value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * value setter.
	 * 
	 * @param value
	 *            the value to set
	 */
	public void setValue(final double value) {
		this.value = value;
	}

	/**
	 * Accuracy accessor.
	 * 
	 * @return the accuracy
	 */
	public double getAccuracy() {
		return accuracy;
	}

	/**
	 * Accuracy setter.
	 * 
	 * @param accuracy
	 *            the accuracy to set
	 */
	public void setAccuracy(final double accuracy) {
		this.accuracy = accuracy;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see nl.mineleni.openls.XmlNamespaceConstants#toXML()
	 */
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
