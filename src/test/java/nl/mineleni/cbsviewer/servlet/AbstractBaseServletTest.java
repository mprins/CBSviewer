/*
 * Copyright (c) 2012-2013, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie.
 */
package nl.mineleni.cbsviewer.servlet;

import static nl.mineleni.cbsviewer.servlet.AbstractBaseServlet.USER_ID;
import static nl.mineleni.cbsviewer.servlet.AbstractBaseServlet.USER_PASSWORD;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeNoException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.jmock.Expectations;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Test;

/**
 * Test klasse voor {@link nl.mineleni.cbsviewer.servlet.AbstractBaseServlet}
 * 
 * @author prinsmc
 */
public class AbstractBaseServletTest {
	/** servlet die we testen. */
	private AbstractBaseServlet pxyServlet;

	/** junit mockery. */
	private final JUnitRuleMockery mockery = new JUnitRuleMockery();

	/** ge-mockte servlet config gebruikt in de test. */
	private ServletConfig servletConfig;

	/**
	 * Set up for the tests, init()'s the servlet to test.
	 */
	@SuppressWarnings("serial")
	@Before
	public void setUp() throws Exception {
		this.servletConfig = this.mockery.mock(ServletConfig.class);
		// Override getServletConfig/getServletContext to return the mocked
		// config/context
		this.pxyServlet = new AbstractBaseServlet() {
			/** return de mocked servletConfig. */
			@Override
			public ServletConfig getServletConfig() {
				return AbstractBaseServletTest.this.servletConfig;
			}
		};
	}

	/**
	 * Test methode voor
	 * {@link nl.mineleni.cbsviewer.servlet.AbstractBaseServlet#init(javax.servlet.ServletConfig)}
	 * , test met geldige waarden.
	 * 
	 * @see #setUp()
	 */
	@Test
	public void testInitServletConfig() {
		// set up mock config
		this.mockery.checking(new Expectations() {
			{
				this.oneOf(AbstractBaseServletTest.this.servletConfig)
						.getInitParameter(USER_ID);
				this.will(returnValue("userID"));
				this.oneOf(AbstractBaseServletTest.this.servletConfig)
						.getInitParameter(USER_PASSWORD);
				this.will(returnValue("passID"));
			}
		});
		System.setProperty("http.proxyPort", "8080");
		System.setProperty("http.proxyHost", "wpad.agro.nl");
		try {
			this.pxyServlet.init(this.servletConfig);
			assertEquals("wpad.agro.nl", this.pxyServlet.getProxyHost());
			assertEquals(8080, this.pxyServlet.getProxyPort());
			assertEquals("userID", this.pxyServlet.getUserID());
			assertEquals("passID", this.pxyServlet.getPassID());
		} catch (final ServletException e) {
			fail("Servlet Exception voor init() in test setup.(testInitServletConfig) "
					+ e.getLocalizedMessage());
		} catch (final SecurityException s) {
			assumeNoException(s);
		}

	}

	/**
	 * Test methode voor
	 * {@link nl.mineleni.cbsviewer.servlet.AbstractBaseServlet#init(javax.servlet.ServletConfig)}
	 * , test met null waarden.
	 * 
	 * @see #setUp()
	 */
	@Test
	public void testInitServletConfigNull() {
		this.mockery.checking(new Expectations() {
			{
				this.oneOf(AbstractBaseServletTest.this.servletConfig)
						.getInitParameter(USER_ID);
				this.will(returnValue(null));
				this.oneOf(AbstractBaseServletTest.this.servletConfig)
						.getInitParameter(USER_PASSWORD);
				this.will(returnValue(null));
			}
		});
		System.clearProperty("http.proxyPort");
		System.clearProperty("http.proxyHost");
		try {
			this.pxyServlet.init(this.servletConfig);
			assertNull(this.pxyServlet.getProxyHost());
			assertEquals(-1, this.pxyServlet.getProxyPort());
			assertNull(this.pxyServlet.getUserID());
			assertNull(this.pxyServlet.getPassID());
		} catch (final ServletException e) {
			fail("Servlet Exception voor init() in test setup. (testInitServletConfigNull)"
					+ e.getLocalizedMessage());
		} catch (final SecurityException s) {
			assumeNoException(s);
		}

	}
}
