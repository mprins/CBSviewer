/**
 * 
 */
package nl.mineleni.cbsviewer.servlet;

import static nl.mineleni.cbsviewer.util.NumberConstants.OPENLS_ZOOMSCALE_STANDAARD;
import static nl.mineleni.cbsviewer.util.StringConstants.REQ_PARAM_STRAAL;
import static nl.mineleni.cbsviewer.util.StringConstants.REQ_PARAM_XCOORD;
import static nl.mineleni.cbsviewer.util.StringConstants.REQ_PARAM_YCOORD;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Algemene initialisatie code en gedeelde functies voor de WxS servlets.
 * 
 * @author prinsmc
 * @since 1.6
 * @since Servlet API 2.5
 * @note gedeelde basis voor de WxS servlets
 */
public abstract class AbstractWxSServlet extends AbstractBaseServlet {
	final Logger LOGGER = LoggerFactory.getLogger(AbstractWxSServlet.class);
	/** serialization id. */
	private static final long serialVersionUID = -5563479037661945586L;

	/**
	 * Parse locatie uit een request.
	 * 
	 * @param request
	 *            Het servlet request
	 * @return een {@code double[xcoord,ycoord,straal]}
	 * @throws ServletException
	 *             Als parsen is mislukt
	 */
	protected double[] parseLocation(HttpServletRequest request)
			throws ServletException {
		try {
			// request params uitlezen voor het zoeken
			final double xcoord = Double.valueOf(request
					.getParameter(REQ_PARAM_XCOORD.code));
			final double ycoord = Double.valueOf(request
					.getParameter(REQ_PARAM_YCOORD.code));
			final double straal = Double
					.valueOf((null == request
							.getParameter(REQ_PARAM_STRAAL.code) ? OPENLS_ZOOMSCALE_STANDAARD
							.toString() : request
							.getParameter(REQ_PARAM_STRAAL.code)));
			LOGGER.debug("request params:" + xcoord + ":" + ycoord + " straal:"
					+ straal);
			return new double[] { xcoord, ycoord, straal };
		} catch (final NullPointerException e) {
			LOGGER.error(
					"Een van de vereiste parameters werd niet in het request gevonden.",
					e);
			throw new ServletException(e);
		} catch (final NumberFormatException e) {
			LOGGER.error(
					"Een van de vereiste parameters kon niet geparsed worden als Double.",
					e);
			throw new ServletException(e);
		}
	}
}
