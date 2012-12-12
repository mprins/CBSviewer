/*
 * Copyright (c) 2012, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie.
 */
package nl.mineleni.cbsviewer.util;

import org.apache.log4j.Logger;
import org.geotools.geometry.Envelope2D;
import org.geotools.referencing.CRS;
import org.opengis.geometry.BoundingBox;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;

/**
 * Spatial Utilities.
 * 
 * @author prinsmc
 */
public final class SpatialUtil {
	/** logger. */
	private static final Logger LOGGER = Logger.getLogger(SpatialUtil.class);

	/**
	 * Instantiates a new spatial util.
	 */
	private SpatialUtil() {
	}

	/**
	 * Maakt een vierkante bbox met RD CRS met lengte en hoogte van.
	 * 
	 * @param xcoord
	 *            xcoord
	 * @param ycoord
	 *            ycoord
	 * @param afstand
	 *            afstand
	 * @return the bounding box {@code 2 x afstand} (dus straal {@code afstand})
	 *         om het het coordinatenpaar {@code xcoord};{@code ycoord}.
	 */
	public static BoundingBox calcRDBBOX(double xcoord, double ycoord,
			double afstand) {
		try {
			return new Envelope2D(CRS.decode("EPSG:28992"), (xcoord - afstand),
					(ycoord - afstand), 2 * afstand, 2 * afstand);
		} catch (final NoSuchAuthorityCodeException e) {
			LOGGER.fatal("De gevraagde CRS autoriteit is niet gevonden.", e);
		} catch (final FactoryException e) {
			LOGGER.fatal(
					"Gevraagde GeoTools factory voor CRS is niet gevonden.", e);
		}
		return null;
	}
}
