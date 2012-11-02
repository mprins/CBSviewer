package nl.mineleni.cbsviewer.servlet.wms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import javax.xml.parsers.ParserConfigurationException;

import org.geotools.GML;
import org.geotools.GML.Version;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.opengis.feature.simple.SimpleFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;

public class FeatureInfoResponseConverter {
    public enum type {
        GMLTYPE, HTMLTYPE;
    }

    /** logger. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(FeatureInfoResponseConverter.class);

    /**
     * @todo implementatie
     * @param htmlStream
     * @return
     * @throws IOException
     */
    private static String cleanupHTML(final InputStream htmlStream)
            throws IOException {
        LOGGER.warn("unsported feature");
        return convertStreamToString(htmlStream);
    }

    private static String convertGML(final InputStream gmlStream,
            String[] attributes) throws IOException {
        final StringBuilder sb = new StringBuilder();
        try {
            final GML gml = new GML(Version.WFS1_0);
            final SimpleFeatureIterator iter = gml
                    .decodeFeatureIterator(gmlStream);

            sb.append("<table id=\"attribuutTabel\" class=\"attribuutTabel\">");
            sb.append("<caption>");
            sb.append("Informatie over de zoeklocatie.");
            sb.append("</caption>");
            sb.append("<thead><tr>");
            for (final String n : attributes) {
                sb.append("<th scope=\"col\">" + n + "</th>");
            }
            sb.append("</tr></thead>");
            sb.append("<tbody>");
            int i = 0;
            while (iter.hasNext()) {
                sb.append("<tr class=\"" + (((i++ % 2) == 0) ? "" : "even")
                        + "\">");
                final SimpleFeature f = iter.next();
                for (final String n : attributes) {
                    sb.append("<td>" + f.getAttribute(n) + "</td>");
                }
                sb.append("</tr>");
            }
            sb.append("</tbody>");
            sb.append("</table>");
            LOGGER.debug("returning:\n" + sb);

        } catch (ParserConfigurationException | SAXException e) {
            LOGGER.error("Fout tijdens parsen van GML. ", e);
        } finally {
            gmlStream.close();
        }
        return sb.toString();
    }

    /**
     * converteert een stream naar een string.
     * 
     * @param is
     *            de InputStream met data
     * @return de data als string
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private static String convertStreamToString(final InputStream is)
            throws IOException {
        if (is != null) {
            final Writer writer = new StringWriter();
            final char[] buffer = new char[1024];
            try {
                final Reader reader = new BufferedReader(new InputStreamReader(
                        is, "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                is.close();
            }
            return writer.toString();
        } else {
            return "";
        }
    }

    /**
     * converteer de input naar een html tabel.
     * 
     * @param input
     * @param type
     * @return een html tabel
     * @throws IOException
     */
    public static String convertToHTMLTable(final InputStream input,
            final FeatureInfoResponseConverter.type type, String[] attributes)
            throws IOException {
        switch (type) {
        case GMLTYPE:
            return convertGML(input, attributes);
        case HTMLTYPE:
            return cleanupHTML(input);
        default:
            return convertStreamToString(input);
        }
    }

    /**
     * private constructor.
     */
    private FeatureInfoResponseConverter() {
        // private constructor voor utility klasse
    }
}
