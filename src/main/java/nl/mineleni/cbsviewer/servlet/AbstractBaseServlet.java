/*
 * Copyright (c) 2012, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, 
 * zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie.
 */
package nl.mineleni.cbsviewer.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Gedeelde basis servlet.
 * 
 * @author mprins
 * 
 */
public abstract class AbstractBaseServlet extends HttpServlet {

	/** sleutel voor user id. {@value} */
	public static final String USER_ID = "user_id";

	/** sleutel voor password. {@value} */
	public static final String USER_PASSWORD = "user_password";

	/** default serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** logger. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AbstractBaseServlet.class);
	/** proxyserver address for the this service. {@value} */
	private transient String proxyHost;

	/** proxyserver port for the this service. {@value} */
	private transient int proxyPort = -1;

	/** user id voor bijv. authenticatie. @see #USER_ID */
	private transient String userID;

	/** password voor bijv. authenticatie. @see #USER_PASSWORD */
	private transient String passID;

	/**
	 * Gets the proxy host.
	 * 
	 * @return the proxyHost
	 */
	public String getProxyHost() {
		return this.proxyHost;
	}

	/**
	 * Gets the proxy port.
	 * 
	 * @return the proxyPort
	 */
	public int getProxyPort() {
		return this.proxyPort;
	}

	/**
	 * Gets the user id.
	 * 
	 * @return the userID
	 */
	public String getUserID() {
		return this.userID;
	}

	/**
	 * Gets the pass id.
	 * 
	 * @return the passID
	 */
	public String getPassID() {
		return this.passID;
	}

	/**
	 * Leest de config opties uit de web.xml in; het gaat om {@link #USER_ID} en
	 * {@link #USER_PASSWORD}. Daarnaast wordt expliciet de init van de super
	 * klasse aangeroepen.
	 * 
	 * @param config
	 *            the <code>ServletConfig</code> object that contains
	 *            configutation information for this servlet
	 * @throws ServletException
	 *             if an exception occurs that interrupts the servlet's normal
	 *             operation
	 * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(final ServletConfig config) throws ServletException {
		super.init(config);

		// netwerk data/parameters
		this.proxyHost = System.getProperty("http.proxyHost");
		try {
			this.proxyPort = Integer.valueOf(System
					.getProperty("http.proxyPort"));
		} catch (final NumberFormatException e) {
			LOGGER.debug("Geen proxy poort gedefinieerd.");
		}
		LOGGER.info("Instellen van proxy config: " + this.proxyHost + ":"
				+ this.proxyPort);

		// user data/parameters
		this.userID = config.getInitParameter(USER_ID);
		this.passID = config.getInitParameter(USER_PASSWORD);
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug("User ID is: " + this.userID
					+ "; User password lengte is: "
					+ (null != this.passID ? this.passID.length() : "0"));
		}
	}
}
