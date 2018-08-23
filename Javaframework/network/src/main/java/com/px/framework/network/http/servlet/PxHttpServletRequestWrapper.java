package com.px.framework.network.http.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public class PxHttpServletRequestWrapper {
	private HttpServletRequest servletRequest;
	private String requestBody=null;

	public HttpServletRequest getServletRequest() {
		return servletRequest;
	}

	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;
	}

	public String getRequestBody(){
		if(requestBody==null){
			StringBuilder buffer = new StringBuilder();
			try {
				BufferedReader reader = servletRequest.getReader();
				
				String line;
				while ((line = reader.readLine()) != null) {
					buffer.append(line);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			requestBody = buffer.toString();
		}
		return requestBody;
	}
	
	
	public HashMap<String,String> getHeaderMap(){ 
		HashMap<String,String> headerMap = new HashMap<String, String>();
		Enumeration<String> headerNames = servletRequest.getHeaderNames();
		while(headerNames.hasMoreElements()){
			String nextHeaderName = headerNames.nextElement();
			String headerValue = servletRequest.getHeader(nextHeaderName);
			headerMap.put(nextHeaderName, headerValue);
		}
		return headerMap;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();



		sb.append("requestBody:").append(getRequestBody()).append(",URI:").append(servletRequest.getRequestURI());
		return sb.toString();
	}

	/*public String getRequestBody(){
		servletRequest.get
	}*/

}
