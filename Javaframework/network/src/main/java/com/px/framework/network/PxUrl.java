package com.px.framework.network;

import java.util.HashMap;
import java.util.Map;

public class PxUrl {

	private String url;

	public PxUrl(String url) {
		super();
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}





	public String getMethod(){
		Parser parser = new Parser();
		Part urlPart = parser.parseUrl(url);
		String[] directories =  urlPart.getDirectory();
		if(directories != null)
			return directories[directories.length-1];
		else
			return null;
	}


	public String getContext(){
		Parser parser = new Parser();
		Part urlPart = parser.parseUrl(url);
		String[] directories =  urlPart.getDirectory();
		if(directories != null)
			return directories[0];
		else
			return null;
	}

	public Integer getPort(){
		
		Parser parser = new Parser();
		Part urlPart = parser.parseUrl(url);
		return urlPart.getPort();
	}
	
	public String getQueryParam(String paramName){
		Parser parser = new Parser();
		Part urlPart = parser.parseUrl(url);
		QueryString queryString = urlPart.getQueryString();
		if(queryString!=null)
		return queryString.getQueryParameter(paramName);
		else
			return null;
	}
	public String getHost(){
		
		Parser parser = new Parser();
		Part urlPart = parser.parseUrl(url);
		return urlPart.getHost();
	}



	public PxUrlScheme getUrlScheme(){
		Parser parser = new Parser();
		Part urlPart = parser.parseUrl(url);
		return urlPart.getUrlScheme();
	}


	private class Parser{
		public Part parseUrl(String url){
			Part pxUrlPart = new Part();
			if(url!=null){
				String[] firstSplit = url.split("://");
				if(firstSplit.length==2){ //has scheme
					String scheme = firstSplit[0];
					pxUrlPart.setUrlScheme(PxUrlScheme.getUrlScheme(scheme));
					String restOfURL = firstSplit[1];
					String[] restOfUrlSplit = restOfURL.split("/");
					String hostAndPort = restOfUrlSplit[0];
					String[] hostAndPortSplit = hostAndPort.split(":");
					pxUrlPart.setHost(hostAndPortSplit[0]);
					if(hostAndPortSplit.length == 2){
						pxUrlPart.setPort(Integer.parseInt(hostAndPortSplit[1]));
					}
					splitDirectory(restOfUrlSplit, pxUrlPart);

				}
			}
			return pxUrlPart;
		}

		private void splitDirectory(String[] restOfUrlSplit,Part pxUrlPart){
			if(restOfUrlSplit.length>2){
				String lastDirectory = restOfUrlSplit[restOfUrlSplit.length-1];
				String[] queryStringSplit = lastDirectory.split("\\?");
				if(queryStringSplit.length == 2){
					String queryString = queryStringSplit[1];
					pxUrlPart.setQueryString(new QueryString(queryString));
					lastDirectory = queryStringSplit[0];
				}
				String[] directory = new String[restOfUrlSplit.length-1];
				int index =-1;
				for(String dir:restOfUrlSplit){
					if(index !=-1){
						directory[index] =dir;
					}
					index++;
				}
				directory[directory.length-1]  = lastDirectory;
				pxUrlPart.setDirectory(directory);
			}
		}
	}

	private class QueryString{
		private Map<String,String> queryParams = new HashMap<>();
		public QueryString(String queryString){
			String[] queryStringSplit = queryString.split("&");
			for(String queryStringSplitParams:queryStringSplit){
				String[] queryStringPar = queryStringSplitParams.split("=");
				if(queryStringPar.length == 2){
					queryParams.put(queryStringPar[0], queryStringPar[1]);
				}
			}
		}
		public String getQueryParameter(String queryParameterName){
			return queryParams.get(queryParameterName);
		}
	}
	private class Part{
		private PxUrlScheme urlScheme;
		private String host;
		private Integer port;
		private String[] directory;
		private QueryString queryString;
		public PxUrlScheme getUrlScheme() {
			return urlScheme;
		}
		public void setUrlScheme(PxUrlScheme urlScheme) {
			this.urlScheme = urlScheme;
		}
		public String getHost() {
			return host;
		}
		public void setHost(String host) {
			this.host = host;
		}
		public Integer getPort() {
			return port;
		}
		public void setPort(Integer port) {
			this.port = port;
		}
		public String[] getDirectory() {
			return directory;
		}
		public void setDirectory(String[] directory) {
			this.directory = directory;
		}
		public QueryString getQueryString() {
			return queryString;
		}
		public void setQueryString(QueryString queryString) {
			this.queryString = queryString;
		}

	}


}
