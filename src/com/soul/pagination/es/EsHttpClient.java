package com.soul.pagination.es;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import com.google.gson.Gson;

public class EsHttpClient {

	
	
	private HttpClient httpClient ; 
	private Gson gson;
	private String url;
	
	public EsHttpClient(String url){
		this.url = url;
		this.httpClient = new DefaultHttpClient();
		this.gson = new Gson(); 
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String postRequest(String uri, String body) throws ClientProtocolException, IOException{
		
		HttpPost req = new HttpPost(url+"/adv/");
		req.setEntity(new StringEntity(body));
		AllResponseHandler r = new AllResponseHandler();
		String res = httpClient.execute(req, r);
		
		return res;
	}
	
	public String getRequest(String uri) throws ClientProtocolException, IOException{
		String resp = "JOB_NOT_FOUND";
		HttpGet req = new HttpGet(url+uri);
		AllResponseHandler r = new AllResponseHandler();
		String res = httpClient.execute(req, r);
		return res;
	}
	
	
	static class AllResponseHandler implements ResponseHandler<String> {

		public String handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
			// TODO Auto-generated method stub
			int status = response.getStatusLine().getStatusCode();
		      
	         HttpEntity entity = response.getEntity();
	         if(entity == null) {
	            return "";
	         } else {
	            return EntityUtils.toString(entity);
	         }
		}

  }

}
