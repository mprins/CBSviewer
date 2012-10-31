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
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Test klasse voor {@link nl.mineleni.cbsviewer.servlet.AbstractBaseServlet}
 * 
 * @author prinsmc
 */
@RunWith(JMock.class)
public class AbstractBaseServletTest {
	/** servlet die we testen. */
	private AbstractBaseServlet pxyServlet;

	/** junit mockery. */
	private final Mockery mockery = new JUnit4Mockery();

	/** ge-mockte servlet config gebruikt in de test. */
	private ServletConfig servletConfig;

	/**
	 * Set up for the tests, init()'s the servlet to test.
	 */
	@SuppressWarnings("serial")
	@Before
	public void setUp() throws Exception {
		servletConfig = mockery.mock(ServletConfig.class);
		// Override getServletConfig/getServletContext to return the mocked
		// config/context
		pxyServlet = new AbstractBaseServlet() {
			/** return de mocked servletConfig. */
			@Override
			public ServletConfig getServletConfig() {
				return servletConfig;
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
		mockery.checking(new Expectations() {
			{
				one(servletConfig).getInitParameter(USER_ID);
				will(returnValue("userID"));
				one(servletConfig).getInitParameter(USER_PASSWORD);
				will(returnValue("passID"));
			}
		});
		System.setProperty("http.proxyPort", "8080");
		System.setProperty("http.proxyHost", "wpad.agro.nl");
		try {
			pxyServlet.init(servletConfig);
			assertEquals("wpad.agro.nl", pxyServlet.proxyHost);
			assertEquals(8080, pxyServlet.proxyPort);
			assertEquals("userID", pxyServlet.userID);
			assertEquals("passID", pxyServlet.passID);
		} catch (final ServletException e) {
			fail("Servlet Exception voor init() in test setup.(testInitServletConfig) "
					+ e.getLocalizedMessage());
		} catch (SecurityException s) {
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
		mockery.checking(new Expectations() {
			{
				one(servletConfig).getInitParameter(USER_ID);
				will(returnValue(null));
				one(servletConfig).getInitParameter(USER_PASSWORD);
				will(returnValue(null));
			}
		});
		System.clearProperty("http.proxyPort");
		System.clearProperty("http.proxyHost");
		try {
			pxyServlet.init(servletConfig);
			assertNull(pxyServlet.proxyHost);
			assertEquals(-1, pxyServlet.proxyPort);
			assertNull(pxyServlet.userID);
			assertNull(pxyServlet.passID);
		} catch (final ServletException e) {
			fail("Servlet Exception voor init() in test setup. (testInitServletConfigNull)"
					+ e.getLocalizedMessage());
		} catch (SecurityException s) {
			assumeNoException(s);
		}

	}
}
