/*
 * Copyright (c) 2012, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie.
 */
package nl.mineleni.cbsviewer.servlet.wms;

import static nl.mineleni.cbsviewer.servlet.AbstractBaseServlet.USER_ID;
import static nl.mineleni.cbsviewer.servlet.AbstractBaseServlet.USER_PASSWORD;
import static nl.mineleni.cbsviewer.util.StringConstants.REQ_PARAM_DOWNLOADLINK;
import static nl.mineleni.cbsviewer.util.StringConstants.REQ_PARAM_FEATUREINFO;
import static nl.mineleni.cbsviewer.util.StringConstants.REQ_PARAM_LEGENDAS;
import static nl.mineleni.cbsviewer.util.StringConstants.REQ_PARAM_MAPID;
import static nl.mineleni.cbsviewer.util.StringConstants.REQ_PARAM_STRAAL;
import static nl.mineleni.cbsviewer.util.StringConstants.REQ_PARAM_XCOORD;
import static nl.mineleni.cbsviewer.util.StringConstants.REQ_PARAM_YCOORD;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeNoException;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.mineleni.cbsviewer.util.StringConstants;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test case for {@link nl.mineleni.cbsviewer.servlet.wms.WMSClientServlet}.
 * 
 * @author Mark
 */
@RunWith(JMock.class)
public class WMSClientServletTest {
    /** servlet die we testen. */
    private WMSClientServlet servlet;
    /** junit mockery. */
    private final Mockery mockery = new JUnit4Mockery();
    /** mocked servlet request. */
    private HttpServletRequest request;
    /** ge-mockte servlet config gebruikt in de test. */
    private ServletConfig servletConfig;
    /** ge-mockte servlet context gebruikt in de test. */
    private ServletContext servletContext;
    /** ge-mockte servlet response gebruikt in de test. */
    private HttpServletResponse response;

    /**
     * Set up before each test.
     * 
     * @throws Exception
     *             the exception
     */
    @SuppressWarnings("serial")
    @Before
    public void setUp() throws Exception {
        this.request = this.mockery.mock(HttpServletRequest.class);
        this.servletConfig = this.mockery.mock(ServletConfig.class);
        this.servletContext = this.mockery.mock(ServletContext.class);
        this.response = this.mockery.mock(HttpServletResponse.class);

        this.servlet = new WMSClientServlet() {
            /** return de mocked servletContext. */
            @Override
            public ServletContext getServletContext() {
                return WMSClientServletTest.this.servletContext;
            }

            /** return de mocked servletConfig. */
            @Override
            public ServletConfig getServletConfig() {
                return WMSClientServletTest.this.servletConfig;
            }
        };

        this.mockery.checking(new Expectations() {
            {
                this.atLeast(1).of(WMSClientServletTest.this.servletContext)
                        .getRealPath(StringConstants.MAP_CACHE_DIR.code);
                this.will(returnValue("C:/workspace/CBSviewer/target/"
                        + StringConstants.MAP_CACHE_DIR.code));
            }
        });

    }

    /**
     * Tear down after each test.
     * 
     * @throws Exception
     *             the exception
     */
    @After
    public void tearDown() throws Exception {
        try {
            this.servlet.destroy();
        } catch (final NullPointerException e) {
            assertTrue(true);
        }
    }

    /**
     * Test methode voor.
     * {@link nl.mineleni.cbsviewer.servlet.wms.WMSClientServlet#init(javax.servlet.ServletConfig)}
     * .
     */
    @Test
    public void testInitServletConfigNull() {
        this.mockery.checking(new Expectations() {
            {
                this.ignoring(WMSClientServletTest.this.servletConfig)
                        .getInitParameter(USER_ID);
                this.ignoring(WMSClientServletTest.this.servletConfig)
                        .getInitParameter(USER_PASSWORD);
                this.ignoring(WMSClientServletTest.this.servletConfig)
                        .getServletContext();
                this.atLeast(1).of(WMSClientServletTest.this.servletConfig)
                        .getInitParameter("bgCapabilitiesURL");
                this.will(returnValue(null));
                this.atLeast(0).of(WMSClientServletTest.this.servletConfig)
                        .getInitParameter("bgWMSlayers");
                this.will(returnValue(null));
                this.atLeast(0).of(WMSClientServletTest.this.servletConfig)
                        .getInitParameter("lufoCapabilitiesURL");
                this.will(returnValue(null));
                this.atLeast(0).of(WMSClientServletTest.this.servletConfig)
                        .getInitParameter("lufoWMSlayers");
                this.will(returnValue(null));
            }
        });
        try {
            // supposed to throw e
            this.servlet.init(this.servletConfig);
            fail("Een overwachte fail conditie is opgetreden.");
        } catch (final ServletException e) {
            assertTrue("De verwachte ServletException is opgetreden.", true);
        }
    }

    /**
     * Test methode voor.
     * {@link nl.mineleni.cbsviewer.servlet.wms.WMSClientServlet#init(javax.servlet.ServletConfig)}
     * .
     */
    @Test
    public void testInitServletConfig() {
        this.mockery.checking(new Expectations() {
            {
                this.oneOf(WMSClientServletTest.this.servletConfig)
                        .getInitParameter(USER_ID);
                this.will(returnValue("userID"));
                this.oneOf(WMSClientServletTest.this.servletConfig)
                        .getInitParameter(USER_PASSWORD);
                this.will(returnValue("passID"));

                this.oneOf(WMSClientServletTest.this.servletConfig)
                        .getInitParameter("bgCapabilitiesURL");
                this.will(returnValue("http://osm.wheregroup.com/cgi-bin/osm_basic.xml?REQUEST=GetCapabilities&SERVICE=WMS&amp;VERSION=1.1.1"));
                this.oneOf(WMSClientServletTest.this.servletConfig)
                        .getInitParameter("bgWMSlayers");
                this.will(returnValue("Grenzen"));
                this.oneOf(WMSClientServletTest.this.servletConfig)
                        .getInitParameter("lufoCapabilitiesURL");
                this.will(returnValue("http://gisdemo2.agro.nl/arcgis/services/Luchtfoto2010/MapServer/WMSServer?REQUEST=GetCapabilities&SERVICE=WMS"));
                this.oneOf(WMSClientServletTest.this.servletConfig)
                        .getInitParameter("lufoWMSlayers");
                this.will(returnValue(""));

            }
        });

        try {
            // supposed to throw e
            this.servlet.init(this.servletConfig);
            assertEquals("userID", this.servlet.getUserID());
            assertEquals("passID", this.servlet.getPassID());

        } catch (final SecurityException s) {
            assumeNoException(s);
        } catch (final ServletException e) {
            fail("Servlet Exception voor init() in test setup.(testInitServletConfig) "
                    + e.getLocalizedMessage());
        }
    }

    /**
     * Test methode voor
     * {@link nl.mineleni.cbsviewer.servlet.wms.WMSClientServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)}
     * .
     * 
     * @throws ServletException
     *             the servlet exception
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    @Test
    @Ignore("needs more work")
    public void testServiceHttpServletRequestHttpServletResponse()
            throws ServletException, IOException {
        this.mockery.checking(new Expectations() {
            {
                this.allowing(WMSClientServletTest.this.request)
                        .getAttributeNames();
                this.allowing(WMSClientServletTest.this.request)
                        .getParameterMap();

                this.allowing(WMSClientServletTest.this.request).getParameter(
                        REQ_PARAM_XCOORD.code);
                this.will(returnValue("3000"));
                this.allowing(WMSClientServletTest.this.request).getParameter(
                        REQ_PARAM_YCOORD.code);
                this.will(returnValue("3000"));
                this.allowing(WMSClientServletTest.this.request).getParameter(
                        REQ_PARAM_STRAAL.code);
                this.will(returnValue("3000"));

                this.allowing(WMSClientServletTest.this.request).setAttribute(
                        REQ_PARAM_XCOORD.code, 3000);
                this.allowing(WMSClientServletTest.this.request).setAttribute(
                        REQ_PARAM_YCOORD.code, 3000);
                this.allowing(WMSClientServletTest.this.request).setAttribute(
                        REQ_PARAM_STRAAL.code, 3000);

            }
        });

        this.servlet.service(this.request, this.response);

        assertNotNull(this.request.getAttribute(REQ_PARAM_MAPID.code));
        assertNotNull(this.request.getAttribute(REQ_PARAM_LEGENDAS.code));
        assertNotNull(this.request.getAttribute(REQ_PARAM_FEATUREINFO.code));
        assertNotNull(this.request.getAttribute(REQ_PARAM_DOWNLOADLINK.code));
        /*
         * request.setAttribute(REQ_PARAM_MAPID.code, mapId);
         * request.setAttribute(REQ_PARAM_LEGENDAS.code, legendas);
         * request.setAttribute(REQ_PARAM_FEATUREINFO.code, fInfo);
         * request.setAttribute(REQ_PARAM_DOWNLOADLINK.code, layer.getLink());
         */
    }

}
