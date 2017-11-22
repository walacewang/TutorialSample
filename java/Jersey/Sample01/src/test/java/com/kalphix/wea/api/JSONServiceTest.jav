package com.kalphix.wea.api;

import static org.junit.Assert.*;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JSONServiceTest {
	
	private WebTarget target;

	@Before
	public void setUp() throws Exception {

		Client c = ClientBuilder.newClient();
		target = c.target("http://localhost:8080/WeaApi01/rest/");
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test to see that the message "Got it!" is sent in the response.
	 */
	@Test
	public void testGET() {
		String responseMsg = target.path("/json/metallica").request().get(String.class);
		System.out.println(">>>>>" + responseMsg);
		//assertEquals("Got it!", responseMsg);
	}
}
