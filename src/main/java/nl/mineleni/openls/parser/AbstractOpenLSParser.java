package nl.mineleni.openls.parser;

import java.util.Stack;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import nl.mineleni.openls.XmlNamespaceConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * gedeelde code voor OpenLS parsing.
 * 
 * @author prinsmc
 *
 */
public abstract class AbstractOpenLSParser extends DefaultHandler {
	/** logger. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AbstractOpenLSParser.class);

	/** val buffer. */
	protected StringBuffer eValBuf;

	/** SAX parser. */
	protected SAXParser parser;

	/** object stack. */
	protected final Stack<XmlNamespaceConstants> objStack = new Stack<>();

	/**
	 * Instantiates a new open ls parser.
	 */
	public AbstractOpenLSParser() {
		final SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setValidating(false);
		try {
			this.parser = factory.newSAXParser();
		} catch (final ParserConfigurationException | SAXException e) {
			LOGGER.error("Configureren of maken van de saxparser is mislukt: ",
					e);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
	 */
	@Override
	public void characters(final char[] ch, final int start, final int length)
			throws SAXException {
		this.eValBuf.append(ch, start, length);
	}

}
