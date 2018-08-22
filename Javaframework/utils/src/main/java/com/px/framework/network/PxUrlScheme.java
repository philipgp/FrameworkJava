package com.px.framework.network;

public enum PxUrlScheme {
	HTTP,HTTPS;
	public static PxUrlScheme getUrlScheme(String schemeText){
		if("http".equalsIgnoreCase(schemeText)){
			return HTTP;
		}else if("https".equalsIgnoreCase(schemeText)){
			return HTTPS;
		}else
			return null;
			
	}
}
