package nl.mineleni.cbsviewer.servlet;

import static nl.mineleni.cbsviewer.servlet.AbstractBaseServlet.PROXY_HOST;
import static nl.mineleni.cbsviewer.servlet.AbstractBaseServlet.PROXY_PORT;
import static nl.mineleni.cbsviewer.servlet.AbstractBaseServlet.USER_ID;
import static nl.mineleni.cbsviewer.servlet.AbstractBaseServlet.USER_PASSWORD;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

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
				one(servletConfig).getInitParameter(PROXY_HOST);
				will(returnValue("wpad.agro.nl"));
				one(servletConfig).getInitParameter(PROXY_PORT);
				will(returnValue("8080"));
				one(servletConfig).getInitParameter(USER_ID);
				will(returnValue("userID"));
				one(servletConfig).getInitParameter(USER_PASSWORD);
				will(returnValue("passID"));
			}
		});
		try {
			pxyServlet.init(servletConfig);
		} catch (final ServletException e) {
			fail("Servlet Exception voor init() in test setup.(testInitServletConfig) "
					+ e.getLocalizedMessage());
		}
		assertEquals("wpad.agro.nl", pxyServlet.proxyHost);
		assertEquals(8080, pxyServlet.proxyPort);
		assertEquals("userID", pxyServlet.userID);
		assertEquals("passID", pxyServlet.passID);
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
				one(servletConfig).getInitParameter(PROXY_HOST);
				will(returnValue(null));
				one(servletConfig).getInitParameter(PROXY_PORT);
				will(returnValue(null));
				one(servletConfig).getInitParameter(USER_ID);
				will(returnValue(null));
				one(servletConfig).getInitParameter(USER_PASSWORD);
				will(returnValue(null));
			}
		});
		try {
			pxyServlet.init(servletConfig);
		} catch (final ServletException e) {
			fail("Servlet Exception voor init() in test setup. (testInitServletConfigNull)"
					+ e.getLocalizedMessage());
		}
		assertNull(pxyServlet.proxyHost);
		assertEquals(-1, pxyServlet.proxyPort);
		assertNull(pxyServlet.userID);
		assertNull(pxyServlet.passID);
	}
}
