/**
 * 
 */
package nl.mineleni.cbsviewer.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import nl.mineleni.cbsviewer.util.LabelsBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Gedeelde basis servlet.
 * 
 * @author mprins
 */
public abstract class AbstractBaseServlet extends HttpServlet {

    /**
	 * sleutel voor proxy server. {@value}
	 * 
	 * @deprecated refactor naar omgevings var {@code http.proxyHost}
	 */
	@Deprecated
	public static final String PROXY_HOST = "proxy_host";

	/**
	 * sleutel voor proxy server poort. {@value}
	 * 
	 * @deprecated refactor naar omgevings var {@code http.proxyPort}
	 */
	@Deprecated
	public static final String PROXY_PORT = "proxy_port";

    /** sleutel voor user id. {@value} */
    public static final String USER_ID = "user_id";

    /** sleutel voor password. {@value} */
    public static final String USER_PASSWORD = "user_password";

    /** default serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** logger. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AbstractBaseServlet.class);
    /** proxyserver address for the this service. @see #PROXY_HOST */
    protected String proxyHost = null;

    /** proxyserver port for the this service. @see #PROXY_PORT */
    protected int proxyPort;

    /** user id voor bijv. authenticatie. @see #USER_ID */
    protected String userID = null;

    /** password voor bijv. authenticatie. @see #USER_PASSWORD */
    protected String passID = null;

    /** De gedeelde, read-only, resourcebundel voor de applicatie. */
    protected LabelsBundle _RESOURCES = new LabelsBundle();

    /**
     * Leest de config opties uit de web.xml in; het gaat om {@link #PROXY_HOST}
     * ,{@link #PROXY_PORT}, {@link #USER_ID} en {@link #USER_PASSWORD}.
     * Daarnaast wordt expliciet de init van de super klasse aangeroepen.
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
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        // netwerk data/parameters
        this.proxyHost = config.getInitParameter(PROXY_HOST);
        final String pxyPort = config.getInitParameter(PROXY_PORT);
        this.proxyPort = (null != pxyPort ? Integer.valueOf(pxyPort) : -1);
        LOGGER.debug("Proxy server:poort is: " + this.proxyHost + ":"
                + this.proxyPort);

        // user data/parameters
        this.userID = config.getInitParameter(USER_ID);
        this.passID = config.getInitParameter(USER_PASSWORD);
        LOGGER.debug("User ID is: " + this.userID
                + "; User password lengte is: "
                + (null != this.passID ? this.passID.length() : ""));
    }
}
