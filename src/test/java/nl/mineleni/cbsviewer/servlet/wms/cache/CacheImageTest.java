package nl.mineleni.cbsviewer.servlet.wms.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.image.BufferedImage;

import org.junit.Before;
import org.junit.Test;

/**
 * Test case voor {@link CacheImage }.
 */
public class CacheImageTest {
    /** to cache object. */
    private final BufferedImage rgbImage = new BufferedImage(100, 100,
            BufferedImage.TYPE_INT_RGB);

    /** naam */
    private final String name = "NAAM";

    /** test subject. */
    private CacheImage cImage;

    @Before
    public void setUp() throws Exception {
        this.cImage = new CacheImage(this.rgbImage, this.name);
    }

    /**
     * Test methode voor {@link CacheImage#getImage() }.
     */
    @Test
    public final void testGetImage() {
        assertEquals(this.rgbImage, this.cImage.getImage());
    }

    /**
     * Test methode voor {@link CacheImage#getName() }.
     */
    @Test
    public final void testGetName() {
        assertEquals(this.name, this.cImage.getName());
    }

    /**
     * Test methode voor {@link CacheImage#isValid() }.
     */
    @Test
    public final void testIsValid() {
        assertTrue(this.cImage.isValid());

        final CacheImage invalid = new CacheImage(this.rgbImage, null);
        assertFalse(invalid.isValid());

        final CacheImage invalid2 = new CacheImage(null, null);
        assertFalse(invalid2.isValid());

        final CacheImage invalid3 = new CacheImage(null, this.name);
        assertFalse(invalid3.isValid());
    }
}
