/*
 * Copyright (c) 2012, Dienst Landelijk Gebied - Ministerie van Economische Zaken, Landbouw en Innovatie
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie. 
 */
package nl.mineleni.cbsviewer.servlet.wms.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import nl.mineleni.cbsviewer.util.xml.LayerDescriptor;
import nl.mineleni.cbsviewer.util.xml.ObjectFactory;

import org.geotools.geometry.Envelope2D;
import org.junit.Before;
import org.junit.Test;
import org.opengis.geometry.BoundingBox;

/**
 * test case voor.
 * 
 * {@link nl.mineleni.cbsviewer.servlet.wms.cache.BboxLayerCacheKey}.
 * 
 * @author mprins
 */
public class BboxLayerCacheKeyTest {

	/** key1. */
	private BboxLayerCacheKey key1;

	/** key2. */
	private BboxLayerCacheKey key2;

	/** notequalkey. */
	private BboxLayerCacheKey notequalkey;

	/** bbox1. */
	private final BoundingBox bbox1 = new Envelope2D(null, 0, 0, 200, 200);

	/** bbox2. */
	private final BoundingBox bbox2 = new Envelope2D(null, 0, 0, 200, 200);

	/** ld1. */
	private LayerDescriptor ld1;
	/** ld1. */
	private LayerDescriptor ld2;

	/**
	 * set up.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Before
	public void setUp() throws Exception {
		ld1 = (new ObjectFactory()).createLayerDescriptor();
		ld2 = (new ObjectFactory()).createLayerDescriptor();
		ld2.setId("someId");
		key1 = new BboxLayerCacheKey(bbox1, ld1);
		key2 = new BboxLayerCacheKey(bbox2, ld1);
		notequalkey = new BboxLayerCacheKey(bbox2, ld2);
	}

	/**
	 * Test method for.
	 * 
	 * {@link nl.mineleni.cbsviewer.servlet.wms.cache.BboxLayerCacheKey#equals(java.lang.Object)}
	 * .
	 */
	@Test
	public final void testEqualsObject() {
		assertEquals(key1, key2);
		assertTrue(key1.equals(key2));
		assertTrue(key1.equals(key1));
		assertFalse(key1.equals(new Object()));
		assertFalse(key1.equals(null));
		assertFalse(key1.equals(notequalkey));
	}

	/**
	 * Test method for.
	 * 
	 * {@link nl.mineleni.cbsviewer.servlet.wms.cache.BboxLayerCacheKey#getBbox()}
	 * .
	 */
	@Test
	public final void testGetBbox() {
		assertEquals(bbox1, key1.getBbox());
	}

	/**
	 * Test method for.
	 * 
	 * {@link nl.mineleni.cbsviewer.servlet.wms.cache.BboxLayerCacheKey#getLd()}
	 * .
	 */
	@Test
	public final void testGetLd() {
		assertEquals(ld1, key1.getLd());
	}

	/**
	 * Test method for.
	 * 
	 * {@link nl.mineleni.cbsviewer.servlet.wms.cache.BboxLayerCacheKey#hashCode()}
	 * .
	 */
	@Test
	public final void testHashCode() {
		assertEquals(key1.hashCode(), key2.hashCode());
		assertTrue(key1.hashCode() == key2.hashCode());
		assertFalse(key1.hashCode() == notequalkey.hashCode());
	}
}
