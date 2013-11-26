/*
 * Copyright (c) 2013, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie.
 */
package nl.mineleni.cbsviewer.jsp;

import static javax.servlet.http.HttpServletResponse.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import nl.mineleni.cbsviewer.IntegrationTestConstants;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Testcases voor jsp's in het project.
 * 
 * @author mprins
 */
public abstract class JSPIntegrationTest extends IntegrationTestConstants {
	/**
	 * test client.
	 */
	protected static CloseableHttpClient client;

	private static final Logger LOGGER = LoggerFactory
			.getLogger(JSPIntegrationTest.class);

	/**
	 * validation string.
	 */
	public static final String RESPONSEPROLOG = "<!DOCTYPE html SYSTEM \"about:legacy-compat\">"
			+ "\n<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"nl\" xml:lang=\"nl\">";;

	/** http client voor communicatie met de validator. */
	private static CloseableHttpClient validatorclient;

	@AfterClass
	public static void disconnect() throws Exception {
		client.close();
		validatorclient.close();
	}

	/**
	 * init XMLUnit.
	 * 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpClass() throws Exception {
		// XMLUnit.setIgnoreWhitespace(false);
		// XMLUnit.setIgnoreAttributeOrder(true);
		// XMLUnit.setIgnoreComments(true);
		// XMLUnit.setIgnoreDiffBetweenTextAndCDATA(true);

		client = HttpClientBuilder.create().build();
		validatorclient = HttpClients.createSystem();
	}

	/**
	 * test response.
	 */
	protected HttpResponse response;

	protected void boilerplateValidationTests(final HttpResponse response)
			throws Exception {

		final String body = new String(EntityUtils.toByteArray(response
				.getEntity()), "UTF-8");
		assertNotNull("Response body mag geen null zijn.", body);
		assertTrue("Response body dient met juiste prolog te starten.",
				body.startsWith(RESPONSEPROLOG));

		// online validation
		final HttpPost validatorrequest = new HttpPost(
				"http://html5.validator.nu/");
		final HttpEntity entity = MultipartEntityBuilder
				.create()
				.setMode(HttpMultipartMode.STRICT)
				.addTextBody("content", body, ContentType.APPLICATION_XHTML_XML)
				.addTextBody("level", "error", ContentType.DEFAULT_TEXT)
				.addTextBody("parser", "xml", ContentType.DEFAULT_TEXT)
				// .addTextBody("parser", "html5", ContentType.DEFAULT_TEXT)
				.addTextBody("out", "json", ContentType.DEFAULT_TEXT).build();
		validatorrequest.setEntity(entity);

		final HttpResponse validatorresponse = validatorclient
				.execute(validatorrequest);
		assertThat("Validator response code.",
				Integer.valueOf(validatorresponse.getStatusLine()
						.getStatusCode()), equalTo(SC_OK));

		final String validatorbody = new String(
				EntityUtils.toByteArray(validatorresponse.getEntity()), "UTF-8");
		LOGGER.debug("validator body:\n" + validatorbody);
		// controle op succes paragraaf in valadator response
		assertTrue(validatorbody.contains("<p class=\"success\">"));
	}

	/**
	 * http verbindingen sluiten na afloop testcases.
	 * 
	 * @throws IOException
	 */
	@After
	public void closeConnection() throws Exception {

	}

	/**
	 * voorbereidingen voor testcases.
	 */
	@Before
	public void prepareTestCase() {

	}

	/**
	 * test of de response geldig is.
	 */
	public abstract void testIfValidResponse() throws Exception;
}
