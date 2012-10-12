/**
 * 
 */
package nl.mineleni.cbsviewer.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test case voor {@link nl.mineleni.cbsviewer.util.EncodingUtil}.
 * 
 * @author mprins
 */
public class EncodingUtilTest {

    private final String s = "some quick test straing incl. url http://test.com/?value1=test&value2=zzzzz";
    private final String sEncoded = "some%20quick%20test%20straing%20incl.%20url%20http%3A%2F%2Ftest.com%2F%3Fvalue1%3Dtest%26value2%3Dzzzzz";

    /**
     * Test method for
     * {@link nl.mineleni.cbsviewer.util.EncodingUtil#decodeURIComponent(java.lang.String)}
     * .
     */
    @Test
    public void testDecodeURIComponent() {
        assertEquals(this.s, EncodingUtil.decodeURIComponent(this.sEncoded));
    }

    /**
     * Test method for
     * {@link nl.mineleni.cbsviewer.util.EncodingUtil#encodeURIComponent(java.lang.String)}
     * .
     */
    @Test
    public void testEncodeURIComponent() {
        assertEquals(this.sEncoded, EncodingUtil.encodeURIComponent(this.s));
    }

    /**
     * Test method for
     * {@link nl.mineleni.cbsviewer.util.EncodingUtil#encodeURIComponent(java.lang.String)}
     * and
     * {@link nl.mineleni.cbsviewer.util.EncodingUtil#decodeURIComponent(java.lang.String)}
     * .
     */
    @Test
    public void testRoundTrip() {
        assertEquals(this.s, EncodingUtil.decodeURIComponent(EncodingUtil
                .encodeURIComponent(this.s)));
    }
}
