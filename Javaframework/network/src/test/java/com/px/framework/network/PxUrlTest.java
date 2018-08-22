package com.px.framework.network;

import static org.junit.Assert.*;

import org.junit.Test;

public class PxUrlTest {

	
	/**
	 * Testing with null string
	 */
	@Test
	public void getUrlScheme1() {
		PxUrl pxUrl = new PxUrl(null);
		assertNull(pxUrl.getUrlScheme());
	}
	
	/**
	 * Testing with empty string
	 */
	@Test
	public void getUrlScheme1a() {
		PxUrl pxUrl = new PxUrl("");
		assertNull(pxUrl.getUrlScheme());
	}
	
	/**
	 * Testing with invalid url string
	 */
	@Test
	public void getUrlScheme2() {
		PxUrl pxUrl = new PxUrl("abcd");
		assertNull(pxUrl.getUrlScheme());
	}
	
	/**
	 * Testing with valid https url string
	 */
	@Test
	public void getUrlScheme3() {
		PxUrl pxUrl = new PxUrl("https://github.com/philipgp/JavaVO/blob/master/javavo/src/main/java/javavo/network/PxUrl.java");
		assertNotNull(pxUrl.getUrlScheme());
		assertEquals(PxUrlScheme.HTTPS, pxUrl.getUrlScheme());
	}
	
	/**
	 * Testing with valid http url string
	 */
	@Test
	public void getUrlScheme4() {
		PxUrl pxUrl = new PxUrl("http://github.com/philipgp/JavaVO/blob/master/javavo/src/main/java/javavo/network/PxUrl.java");
		assertNotNull(pxUrl.getUrlScheme());
		assertEquals(PxUrlScheme.HTTP, pxUrl.getUrlScheme());
	}
	
	
	/**
	 * Testing with valid http url string but unknown scheme
	 */
	@Test
	public void getUrlScheme5() {
		PxUrl pxUrl = new PxUrl("abcd://github.com/philipgp/JavaVO/blob/master/javavo/src/main/java/javavo/network/PxUrl.java");
		assertNull(pxUrl.getUrlScheme());
	}

	/**
	 * Testing with valid http url string. but having a port
	 */
	@Test
	public void getUrlScheme6() {
		PxUrl pxUrl = new PxUrl("http://github.com:8080/philipgp/JavaVO/blob/master/javavo/src/main/java/javavo/network/PxUrl.java");
		assertNotNull(pxUrl.getUrlScheme());
		assertEquals(PxUrlScheme.HTTP, pxUrl.getUrlScheme());
	}
	
	
	
	
	
	/**
	 * Testing with null string
	 */
	@Test
	public void getHost1() {
		PxUrl pxUrl = new PxUrl(null);
		assertNull(pxUrl.getHost());
	}
	
	/**
	 * Testing with empty string
	 */
	@Test
	public void getHost2() {
		PxUrl pxUrl = new PxUrl("");
		assertNull(pxUrl.getHost());
	}
	
	/**
	 * Testing with invalid url string
	 */
	@Test
	public void getHost3() {
		PxUrl pxUrl = new PxUrl("abcd");
		assertNull(pxUrl.getHost());
	}
	
	/**
	 * Testing with valid https url string
	 */
	@Test
	public void getHost4() {
		PxUrl pxUrl = new PxUrl("https://github.com/philipgp/JavaVO/blob/master/javavo/src/main/java/javavo/network/PxUrl.java");
		assertNotNull(pxUrl.getHost());
		assertEquals("github.com", pxUrl.getHost());
	}
	
	/**
	 * Testing with valid http url string
	 */
	@Test
	public void getHost5() {
		PxUrl pxUrl = new PxUrl("http://github.com/philipgp/JavaVO/blob/master/javavo/src/main/java/javavo/network/PxUrl.java");
		assertNotNull(pxUrl.getHost());
		assertEquals("github.com", pxUrl.getHost());
	}
	
	
	/**
	 * Testing with valid http url string but unknown scheme
	 */
	@Test
	public void getHost6() {
		PxUrl pxUrl = new PxUrl("abcd://github.com/philipgp/JavaVO/blob/master/javavo/src/main/java/javavo/network/PxUrl.java");
		assertNotNull(pxUrl.getHost());
		assertEquals("github.com", pxUrl.getHost());
	}

	/**
	 * Testing with valid http url string. but having a port
	 */
	@Test
	public void getHost7() {
		PxUrl pxUrl = new PxUrl("http://github.com:8080/philipgp/JavaVO/blob/master/javavo/src/main/java/javavo/network/PxUrl.java");
		assertNotNull(pxUrl.getHost());
		assertEquals("github.com", pxUrl.getHost());
	}
	
	/**
	 * Testing with null string
	 */
	@Test
	public void getPort1() {
		PxUrl pxUrl = new PxUrl(null);
		assertNull(pxUrl.getPort());
	}
	
	/**
	 * Testing with empty string
	 */
	@Test
	public void getPort2() {
		PxUrl pxUrl = new PxUrl("");
		assertNull(pxUrl.getPort());
	}
	
	/**
	 * Testing with invalid url string
	 */
	@Test
	public void getPort3() {
		PxUrl pxUrl = new PxUrl("abcd");
		assertNull(pxUrl.getPort());
	}
	
	/**
	 * Testing with valid https url string
	 */
	@Test
	public void getPort4() {
		PxUrl pxUrl = new PxUrl("https://github.com/philipgp/JavaVO/blob/master/javavo/src/main/java/javavo/network/PxUrl.java");
		assertNull(pxUrl.getPort());
		
	}
	
	/**
	 * Testing with valid http url string
	 */
	@Test
	public void getPort5() {
		PxUrl pxUrl = new PxUrl("http://github.com/philipgp/JavaVO/blob/master/javavo/src/main/java/javavo/network/PxUrl.java");
		assertNull(pxUrl.getPort());
	}
	
	
	/**
	 * Testing with valid http url string but unknown scheme
	 */
	@Test
	public void getPort6() {
		PxUrl pxUrl = new PxUrl("abcd://github.com/philipgp/JavaVO/blob/master/javavo/src/main/java/javavo/network/PxUrl.java");
		assertNull(pxUrl.getPort());
	}

	/**
	 * Testing with valid http url string. but having a port
	 */
	@Test
	public void getPort7() {
		PxUrl pxUrl = new PxUrl("http://github.com:8080/philipgp/JavaVO/blob/master/javavo/src/main/java/javavo/network/PxUrl.java");
		assertNotNull(pxUrl.getPort());
		assertEquals(8080, pxUrl.getPort().intValue());
	}
	
	/**
	 * Testing with valid http url string. but having no port
	 */
	@Test
	public void getPort8() {
		PxUrl pxUrl = new PxUrl("http://github.com:/philipgp/JavaVO/blob/master/javavo/src/main/java/javavo/network/PxUrl.java");
		assertNull(pxUrl.getPort());
	}
	
	
	/**
	 * Testing with null string
	 */
	@Test
	public void getContext1() {
		PxUrl pxUrl = new PxUrl(null);
		assertNull(pxUrl.getHost());
	}
	
	/**
	 * Testing with empty string
	 */
	@Test
	public void getContext2() {
		PxUrl pxUrl = new PxUrl("");
		assertNull(pxUrl.getContext());
	}
	
	/**
	 * Testing with invalid url string
	 */
	@Test
	public void getContext3() {
		PxUrl pxUrl = new PxUrl("abcd");
		assertNull(pxUrl.getContext());
	}
	
	/**
	 * Testing with valid https url string
	 */
	@Test
	public void getContext4() {
		PxUrl pxUrl = new PxUrl("https://github.com/philipgp/JavaVO/blob/master/javavo/src/main/java/javavo/network/PxUrl.java");
		assertNotNull(pxUrl.getHost());
		assertEquals("philipgp", pxUrl.getContext());
	}
	
	/**
	 * Testing with valid http url string
	 */
	@Test
	public void getContext5() {
		PxUrl pxUrl = new PxUrl("http://github.com/philipgp/JavaVO/blob/master/javavo/src/main/java/javavo/network/PxUrl.java");
		assertNotNull(pxUrl.getHost());
		assertEquals("philipgp", pxUrl.getContext());
	}
	
	
	/**
	 * Testing with valid http url string but unknown scheme
	 */
	@Test
	public void getContext6() {
		PxUrl pxUrl = new PxUrl("abcd://github.com/philipgp/JavaVO/blob/master/javavo/src/main/java/javavo/network/PxUrl.java");
		assertNotNull(pxUrl.getHost());
		assertEquals("philipgp", pxUrl.getContext());
	}

	/**
	 * Testing with valid http url string. but having a port
	 */
	@Test
	public void getContext7() {
		PxUrl pxUrl = new PxUrl("http://github.com:8080/philipgp/JavaVO/blob/master/javavo/src/main/java/javavo/network/PxUrl.java");
		assertNotNull(pxUrl.getHost());
		assertEquals("philipgp", pxUrl.getContext());
	}
	
	
	/**
	 * Testing with null string
	 */
	@Test
	public void getQueryString1() {
		PxUrl pxUrl = new PxUrl(null);
		assertNull(pxUrl.getQueryParam("param1"));
	}
	
	/**
	 * Testing with empty string
	 */
	@Test
	public void getQueryString2() {
		PxUrl pxUrl = new PxUrl("");
		assertNull(pxUrl.getQueryParam("param1"));
	}
	
	/**
	 * Testing with invalid url string
	 */
	@Test
	public void getQueryString3() {
		PxUrl pxUrl = new PxUrl("abcd");
		assertNull(pxUrl.getQueryParam("param1"));
	}
	
	/**
	 * Testing with valid https url string
	 */
	@Test
	public void getQueryString4() {
		PxUrl pxUrl = new PxUrl("https://github.com/philipgp/JavaVO/blob/master/javavo/src/main/java/javavo/network/PxUrl.java?param1=philipgp");
		assertNotNull(pxUrl.getQueryParam("param1"));
		assertEquals("philipgp", pxUrl.getQueryParam("param1"));
	}
	
	/**
	 * Testing with valid http url string
	 */
	@Test
	public void getQueryString5() {
		PxUrl pxUrl = new PxUrl("http://github.com/philipgp/JavaVO/blob/master/javavo/src/main/java/javavo/network/PxUrl.java?param1=philipgp");
		assertNotNull(pxUrl.getQueryParam("param1"));
		assertEquals("philipgp", pxUrl.getQueryParam("param1"));
	}
	
	
	/**
	 * Testing with valid http url string but unknown scheme
	 */
	@Test
	public void getQueryString6() {
		PxUrl pxUrl = new PxUrl("abcd://github.com/philipgp/JavaVO/blob/master/javavo/src/main/java/javavo/network/PxUrl.java?param1=philipgp");
		assertNotNull(pxUrl.getQueryParam("param1"));
		assertEquals("philipgp", pxUrl.getQueryParam("param1"));
	}

	/**
	 * Testing with valid http url string. but having a port
	 */
	@Test
	public void getQueryString7() {
		PxUrl pxUrl = new PxUrl("http://github.com:8080/philipgp/JavaVO/blob/master/javavo/src/main/java/javavo/network/PxUrl.java?param1=philipgp");
		assertNotNull(pxUrl.getQueryParam("param1"));
		assertEquals("philipgp", pxUrl.getQueryParam("param1"));
	}
	
	/**
	 * Testing with valid http url string. but having a port
	 * two queryString params
	 */
	@Test
	public void getQueryString8() {
		PxUrl pxUrl = new PxUrl("http://github.com:8080/philipgp/JavaVO/blob/master/javavo/src/"
				+ "main/java/javavo/network/PxUrl.java?param1=philipgp&param2=pasd");
		assertNotNull(pxUrl.getQueryParam("param1"));
		assertEquals("philipgp", pxUrl.getQueryParam("param1"));
		assertNotNull(pxUrl.getQueryParam("param2"));
		assertEquals("pasd", pxUrl.getQueryParam("param2"));
	}
	
	/**
	 * Testing with valid http url string. but having a port
	 * null queryString params
	 */
	@Test
	public void getQueryString9() {
		PxUrl pxUrl = new PxUrl("http://github.com:8080/philipgp/JavaVO/blob/master/javavo/src/"
				+ "main/java/javavo/network/PxUrl.java");
		assertNull(pxUrl.getQueryParam("param1"));
		
	}
}
