/**
 * 
 */
package nl.mineleni.cbsviewer.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * rudimentaire reverse proxy servlet voor GET requests.
 * 
 * @author Mark
 */
public class ReverseProxyServlet extends AbstractBaseServlet {

    /** Serialization UID. */
    private static final long serialVersionUID = -8380236321235445724L;
    /**
     * urls waarvoor proxy is toegestaan, default is
     * <code>http://localhost/</code>, wordt overschreven in init mits opgenomen
     * in servlet configuratie.
     * 
     * @see #init(ServletConfig)
     */
    private String[] allowedUrls = { "http://localhost/" };

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.GenericServlet#init(javax.servlet.ServletConfig)
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        final String urls = config.getInitParameter("allowedUrls");
        if (urls.length() > 0) {
            urls = urls.replaceAll("\\s", "");
            this.allowedUrls = urls.split(",");
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest
     * , javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        boolean allowed = false;

        String reqUrl = request.getQueryString();
        reqUrl = URLDecoder.decode(reqUrl, "UTF-8");
        for (final String allowedUrl : this.allowedUrls) {
            if (reqUrl.toLowerCase().startsWith(allowedUrl.toLowerCase())) {
                allowed = true;
                break;
            }
        }

        if (!allowed) {
            this.log("Proxy voor request met URL: " + reqUrl
                    + " is niet toegestaan, het verzoek is geweigerd.");
            response.setStatus(403);
            return;
        }
        // set up connection
        final URL url = new URL(reqUrl);
        final HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod(request.getMethod());
        con.setRequestProperty("Referer", "");
        if (request.getContentType() != null) {
            con.setRequestProperty("Content-Type", request.getContentType());
        }

        final int clength = request.getContentLength();
        if (clength > 0) {
            con.setDoInput(true);
            final InputStream istream = request.getInputStream();
            final OutputStream os = con.getOutputStream();
            final int length = 5000;
            final byte[] bytes = new byte[length];
            int bytesRead = 0;
            while ((bytesRead = istream.read(bytes, 0, length)) > 0) {
                os.write(bytes, 0, bytesRead);
            }
        }
        final OutputStream ostream = response.getOutputStream();

        // IE 6 ev. kan "text/xml; subtype=gml/2.1.2" niet aan dus knippen we
        // het subtype stukje eraf.
        if (con.getContentType().contains("subtype=")) {
            final String ctype = con.getContentType();
            response.setContentType(ctype.substring(0, ctype.indexOf(";")));
        } else {
            response.setContentType(con.getContentType());
        }

        final InputStream in = con.getInputStream();
        final int length = 5000;
        final byte[] bytes = new byte[length];
        int bytesRead = 0;
        while ((bytesRead = in.read(bytes, 0, length)) > 0) {
            ostream.write(bytes, 0, bytesRead);
        }
    }
}
