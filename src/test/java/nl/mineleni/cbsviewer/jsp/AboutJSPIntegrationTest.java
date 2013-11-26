/*
 * Copyright (c) 2013, Dienst Landelijk Gebied - Ministerie van Economische Zaken
 * 
 * Gepubliceerd onder de BSD 2-clause licentie, zie https://github.com/MinELenI/CBSviewer/blob/master/LICENSE.md voor de volledige licentie.
 */
package nl.mineleni.cbsviewer.jsp;

import static javax.servlet.http.HttpServletResponse.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.apache.http.client.methods.HttpGet;
import org.junit.Test;

/**
 * Testcases voor about.jsp.
 * 
 * @author mprins
 */
public class AboutJSPIntegrationTest extends JSPIntegrationTest {

	/**
	 * testcase voor about.jsp.
	 * 
	 * @throws Exception
	 */
	@Override
	@Test
	public void testIfValidResponse() throws Exception {
		response = client.execute(new HttpGet(BASE_TEST_URL + "about.jsp"));

		assertThat("Response status is OK.", response.getStatusLine()
				.getStatusCode(), equalTo(SC_OK));

		boilerplateValidationTests(response);
	}
}
