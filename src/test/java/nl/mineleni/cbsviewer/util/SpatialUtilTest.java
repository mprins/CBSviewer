/*
 * Copyright (c) 2012-2013, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie. 
 */
package nl.mineleni.cbsviewer.util;

import static org.junit.Assert.assertTrue;

import org.geotools.geometry.GeneralEnvelope;
import org.junit.Test;
import org.opengis.geometry.BoundingBox;

/**
 * Testcase voor {@link SpatialUtil}.
 * 
 * @author prinsmc
 * 
 */
public class SpatialUtilTest {

	/** de constante STRAAL. {@value} */
	private static final double STRAAL = 1500;

	/** de constante YCOORD. {@value} */
	private static final double YCOORD = 469199;

	/** de constante XCOORD. {@value} */
	private static final double XCOORD = 148082;

	/**
	 * Test methode voor {@link SpatialUtil#calcRDBBOX(double, double, double)}.
	 */
	@Test
	public final void testCalcRDBBOX() {
		final GeneralEnvelope expected = new GeneralEnvelope(new double[] {
				(XCOORD - (STRAAL)), (YCOORD - (STRAAL)) }, new double[] {
				(XCOORD + (STRAAL)), (YCOORD + (STRAAL)) });

		final BoundingBox actual = SpatialUtil.calcRDBBOX(XCOORD, YCOORD,
				STRAAL);
		assertTrue(expected.contains(actual, true));
	}
}
