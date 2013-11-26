/*
 * Copyright (c) 2013, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie.
 */
package nl.mineleni.cbsviewer.jsp;

import static javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR;
import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.apache.http.client.methods.HttpGet;
import org.junit.Test;

/**
 * Testcases voor error.jsp, error404.jsp en andere fout pagina's.
 * 
 * @author mprins
 */
public class ErrorJSPIntegrationTest extends JSPIntegrationTest {

	/**
	 * testcase voor error.jsp.
	 * 
	 * @throws Exception
	 */
	@Test
	@Override
	public void testIfValidResponse() throws Exception {
		response = client.execute(new HttpGet(BASE_TEST_URL + "error.jsp"));
		assertThat("Response status is SC_INTERNAL_SERVER_ERROR.", response
				.getStatusLine().getStatusCode(),
				equalTo(SC_INTERNAL_SERVER_ERROR));
		boilerplateValidationTests(response);
	}

	/**
	 * testcase voor error404.jsp.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testIfValidResponse404() throws Exception {
		response = client.execute(new HttpGet(BASE_TEST_URL
				+ "non-existant.jsp"));
		assertThat("Response status is SC_NOT_FOUND.", response.getStatusLine()
				.getStatusCode(), equalTo(SC_NOT_FOUND));
		boilerplateValidationTests(response);
	}

}
