package com.px.framework.network.http.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;

public class PxHttpServletResponseWrapper {

	private HttpServletResponse httpServletResponse;

	public PxHttpServletResponseWrapper(HttpServletResponse httpServletResponse) {
		super();
		this.httpServletResponse = httpServletResponse;
	}
	
	
	public void setResponseBody(String body) throws Exception{
		httpServletResponse.getWriter().println(body);
	}
	
	public void setHttpStatus(int httpStatus){
		httpServletResponse.setStatus(httpStatus);
	}
	
	public void setHttpheaders(HashMap<String,String> responseHeaders){
		if(responseHeaders!=null){
			
			Iterator<Entry<String, String>> it = responseHeaders.entrySet().iterator();
			while(it.hasNext()){
				Entry<String, String> entry = it.next();
				httpServletResponse.addHeader(entry.getKey(), entry.getValue());
			}
			
					
		}
	}


	public HttpServletResponse getHttpServletResponse() {
		return httpServletResponse;
	}
}
