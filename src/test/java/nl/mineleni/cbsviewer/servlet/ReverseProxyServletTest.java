package nl.mineleni.cbsviewer.servlet;

import static javax.servlet.http.HttpServletResponse.SC_BAD_GATEWAY;
import static javax.servlet.http.HttpServletResponse.SC_FORBIDDEN;
import static nl.mineleni.cbsviewer.servlet.AbstractBaseServlet.USER_ID;
import static nl.mineleni.cbsviewer.servlet.AbstractBaseServlet.USER_PASSWORD;
import static nl.mineleni.cbsviewer.servlet.ReverseProxyServlet.ALLOWED_HOSTS;
import static nl.mineleni.cbsviewer.servlet.ReverseProxyServlet.ERR_MSG_MISSING_CONFIG;
import static nl.mineleni.cbsviewer.servlet.ReverseProxyServlet.FORCE_XML_MIME;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests voor {@link nl.mineleni.cbsviewer.servlet.ReverseProxyServlet }
 * 
 * @author prinsmc
 * 
 */
public class ReverseProxyServletTest {
	/** servlet die we testen. */
	private ReverseProxyServlet pxyServlet;

	/** junit mockery. */
	private final JUnitRuleMockery mockery = new JUnitRuleMockery();

	/** ge-mockte servlet request gebruikt in de test. */
	private HttpServletRequest request;

	/** ge-mockte servlet config gebruikt in de test. */
	private ServletConfig servletConfig;

	/** ge-mockte servlet context gebruikt in de test. */
	private ServletContext servletContext;

	/** ge-mockte servlet response gebruikt in de test. */
	private HttpServletResponse response;

	/** naam server 1. test waarde. */
	private static final String SERVERNAME_DOESNOTEXIST = "blaat.non-existentserver1.com";

	/** request url op server 1. test waarde. */
	private static final String SERVERNAME_DOESNOTEXIST_URL = "http://"
			+ SERVERNAME_DOESNOTEXIST + "/";

	/** naam niet toegestane server. test waarde. */
	private static final String UNALLOWEDSERVERNAME = "notallowed.minlnv.nl";

	/** request url op niet toegestane server. test waarde. */
	private static final String UNALLOWEDSERVERNAME_URL = "http://"
			+ UNALLOWEDSERVERNAME + "/test/notallowed";

	/** naam server 2. test waarde. */
	public static final String SERVERNAME = "dbr0425s.dbr.agro.nl:8080";

	/** request url op server 2. test waarde. */
	private static final String SERVERNAME_URL = "http://" + SERVERNAME
			+ "/dashboard/";

	/** request url op server 2. test waarde. */
	private static final String INVALID_URL = "/lnv-common-gis/";

	/**
	 * Set up test en mock objecten.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@SuppressWarnings("serial")
	@Before
	public void setUp() throws Exception {
		this.servletConfig = this.mockery.mock(ServletConfig.class);
		this.servletContext = this.mockery.mock(ServletContext.class);
		this.response = this.mockery.mock(HttpServletResponse.class);
		this.request = this.mockery.mock(HttpServletRequest.class);

		// set up mock config, optional add context expectations
		this.mockery.checking(new Expectations() {
			{
				// zitten in de superklasse
				this.allowing(ReverseProxyServletTest.this.servletConfig)
						.getInitParameter(USER_ID);
				this.will(returnValue("userID"));
				this.allowing(ReverseProxyServletTest.this.servletConfig)
						.getInitParameter(USER_PASSWORD);
				this.will(returnValue("passID"));
				// te testen servlet
				this.allowing(ReverseProxyServletTest.this.servletConfig)
						.getInitParameter(FORCE_XML_MIME);
				this.will(returnValue("true"));
				this.oneOf(ReverseProxyServletTest.this.servletConfig)
						.getInitParameter(ALLOWED_HOSTS);
				this.will(returnValue(SERVERNAME_DOESNOTEXIST + ";"
						+ SERVERNAME));
			}
		});
		// Override getServletConfig/getServletContext to return the mocked
		// config/context
		this.pxyServlet = new ReverseProxyServlet() {
			/** return de mocked servletConfig. */
			@Override
			public ServletConfig getServletConfig() {
				return ReverseProxyServletTest.this.servletConfig;
			}

			/** return de mocked servletContext. */
			@Override
			public ServletContext getServletContext() {
				return ReverseProxyServletTest.this.servletContext;
			}
		};
		try {
			this.pxyServlet.init(this.servletConfig);
		} catch (final ServletException e) {
			fail("Servlet Exception voor init() in test setup. "
					+ e.getLocalizedMessage());
		}
	}

	/**
	 * Test methode voor
	 * {@link nl.mineleni.cbsviewer.servlet.ReverseProxyServlet#doGet(HttpServletRequest, javax.servlet.http.HttpServletResponse)}
	 * .
	 * 
	 * @throws IOException
	 *             when it bubbles up from the servletresponse
	 * 
	 */
	public void testDoGetHttpServletRequestHttpServletResponse1()
			throws IOException {
		// (#1)
		this.mockery.checking(new Expectations() {
			{
				this.oneOf(ReverseProxyServletTest.this.request)
						.getQueryString();
				this.will(returnValue(SERVERNAME_URL));
				this.allowing(ReverseProxyServletTest.this.response)
						.setContentType("text/xml");
				this.oneOf(ReverseProxyServletTest.this.response)
						.setContentLength((this.with(greaterThan(1))));
				this.oneOf(ReverseProxyServletTest.this.response).getWriter();
				this.will(returnValue((new PrintWriter(System.out))));
				this.oneOf(ReverseProxyServletTest.this.response).flushBuffer();
			}
		});
		try {
			this.pxyServlet.doGet(this.request, this.response);
		} catch (final ServletException e) {
			fail("Servlet Exception voor doGet test. (#1)" + e);
		}
	}

	/**
	 * Test methode voor
	 * {@link nl.mineleni.cbsviewer.servlet.ReverseProxyServlet#doGet(HttpServletRequest, javax.servlet.http.HttpServletResponse)}
	 * .
	 * 
	 * @throws IOException
	 *             when it bubbles up from the servletresponse
	 * 
	 */
	public void testDoGetHttpServletRequestHttpServletResponse2()
			throws IOException {
		// (#2) this should fail; INVALID_URL is not a valid url
		this.mockery.checking(new Expectations() {
			{
				this.oneOf(ReverseProxyServletTest.this.request)
						.getQueryString();
				this.will(returnValue(INVALID_URL));
			}
		});
		try {
			this.pxyServlet.doGet(this.request, this.response);
			fail("Dit is een overwachte failure. (#2)");
		} catch (final ServletException e) {
			// als servlet api = 2.5
			assertEquals(
					"javax.servlet.ServletException: only HTTP(S) protocol supported",
					e.getMessage());
			// als servlet api < 2.5
			// assertEquals("only HTTP(S) protocol supported", e.getMessage());
		}
	}

	/**
	 * Test methode voor
	 * {@link nl.mineleni.cbsviewer.servlet.ReverseProxyServlet#doGet(HttpServletRequest, javax.servlet.http.HttpServletResponse)}
	 * .
	 * 
	 * @throws IOException
	 *             when it bubbles up from the servletresponse
	 */
	public void testDoGetHttpServletRequestHttpServletResponse3()
			throws IOException {
		// (#3) this should fail w/ ConnectException
		this.mockery.checking(new Expectations() {
			{
				this.oneOf(ReverseProxyServletTest.this.request)
						.getQueryString();
				this.will(returnValue(SERVERNAME_DOESNOTEXIST_URL));
				// omdat we een proxy hebben geconfigurrerd krijgen we een 404
				// this.one(ReverseProxyServletTest.this.response).sendError(
				// SC_NOT_FOUND, "HTTP/1.1 404 Not Found");
				this.oneOf(ReverseProxyServletTest.this.response).sendError(
						SC_BAD_GATEWAY, "HTTP/1.1 502 Bad Gateway");
			}
		});
		try {
			this.pxyServlet.doGet(this.request, this.response);
		} catch (final ServletException e) {
			fail("(#3)" + e.getMessage());
		}
	}

	/**
	 * Test methode voor
	 * {@link nl.mineleni.cbsviewer.servlet.ReverseProxyServlet#doGet(HttpServletRequest, javax.servlet.http.HttpServletResponse)}
	 * .
	 * 
	 * @throws IOException
	 *             when it bubbles up from the servletresponse
	 */
	public void testDoGetHttpServletRequestHttpServletResponse4()
			throws IOException {
		// (#4)
		this.mockery.checking(new Expectations() {
			{
				this.oneOf(ReverseProxyServletTest.this.request)
						.getQueryString();
				this.will(returnValue(UNALLOWEDSERVERNAME_URL));
				this.oneOf(ReverseProxyServletTest.this.response).sendError(
						SC_FORBIDDEN,
						UNALLOWEDSERVERNAME_URL
								+ " is not in the list of allowed servers");
				this.oneOf(ReverseProxyServletTest.this.response).flushBuffer();
			}
		});
		try {
			this.pxyServlet.doGet(this.request, this.response);
		} catch (final ServletException e) {
			fail("Servlet Exception voor doGet test. (#4)" + e);
		}
	}

	/**
	 * Test methode voor
	 * {@link nl.mineleni.cbsviewer.servlet.ReverseProxyServlet#init(javax.servlet.ServletConfig)}
	 * , test voor missende config optie.
	 */
	@Test
	public final void testInitServletConfig() {
		// init is called in setUp()
		this.mockery.checking(new Expectations() {
			{
				this.oneOf(ReverseProxyServletTest.this.servletConfig)
						.getInitParameter(ALLOWED_HOSTS);
				this.will(returnValue(null));
			}
		});
		try {
			// supposed to throw e
			this.pxyServlet.init(this.servletConfig);
			fail("Een overwachte fail conditie is opgetreden. (#2)");
		} catch (final ServletException e) {
			assertSame(ERR_MSG_MISSING_CONFIG, e.getMessage());
		}
	}

	/**
	 * Test methode voor
	 * {@link nl.mineleni.cbsviewer.servlet.ReverseProxyServlet#checkUrlAllowed(java.lang.String)}
	 * . Deze test maakt een mock servletconfig en configureert de servlet. Met
	 * de reflection API wordt de private method van de echte
	 * ReverseProxyServlet aangeroepen.
	 */
	@Test
	public void testCheckUrlAllowed() {
		// init is called in setUp()
		try {
			// superclass gebruiken anders krijg je de "override" class terug;
			// en die heeft deze method niet
			final Method method = this.pxyServlet.getClass().getSuperclass()
					.getDeclaredMethod("checkUrlAllowed", String.class);
			method.setAccessible(true);
			assertFalse((Boolean) method.invoke(this.pxyServlet,
					UNALLOWEDSERVERNAME));
			assertTrue((Boolean) method.invoke(this.pxyServlet, SERVERNAME_URL));
		} catch (final SecurityException e) {
			fail("Reflection call getDeclaredMethod failed:" + e);
		} catch (final NoSuchMethodException e) {
			fail("Reflection call getDeclaredMethod failed:" + e);
		} catch (final IllegalArgumentException e) {
			fail("Reflection call invoke failed:" + e);
		} catch (final IllegalAccessException e) {
			fail("Reflection call invoke failed:" + e);
		} catch (final InvocationTargetException e) {
			fail("Reflection call invoke failed:" + e);
		}
	}
}
