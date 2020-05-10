package com.soul.pagination.es;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import java.text.ParseException;
import java.util.Collections;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.entity.ContentType;
import org.apache.http.message.BasicHeader;
import org.apache.http.nio.entity.NStringEntity;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.Args;
import org.apache.http.util.CharArrayBuffer;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.RestClient;
import org.json.JSONObject;

public class ESClient {
	public static void main(String args[]) {
		RestClient restClient = RestClient.builder(
		        new HttpHost("localhost", 9200, "http"),
		        new HttpHost("localhost", 9201, "http")).build();
		
		
		Map<String, String> params = Collections.singletonMap("pretty", "true");
		
		
		
		try {
			Response response = restClient.performRequest("GET", "/_cat/indices?v", params, new BasicHeader("Content-type", "application/json"));
			String responseBody;
			try {
				responseBody = readBody(response.getEntity(),null);
				//JSONObject jsonObj = toJson(responseBody);
				
				System.out.println("Response :"+responseBody);
				
				//Search API 
				
				
				/*
				 * {
    "query": {
        "match": {"ios.isActive" : 1}
    }
}
				 */
				HttpEntity e = new NStringEntity("{"+
    "\"query\": {"+
        "\"match\": {\"ios.isActive\" : 1}"+
			    "}"+
			"}", ContentType.APPLICATION_JSON);
				response = restClient.performRequest("GET", "/advertiser/_search", Collections.singletonMap("pretty", "true"),e);
				responseBody = readBody(response.getEntity(),null);
				//JSONObject jsonObj = toJson(responseBody);
				
				System.out.println("SearchResponse :"+responseBody);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static JSONObject toJson(String string) {
		
		 return new JSONObject(string);
	}
	
	
	
	
	
	 public static String readBody(
	            final HttpEntity entity, final Charset defaultCharset) throws IOException, ParseException {
	        Args.notNull(entity, "Entity");
	        final InputStream instream = entity.getContent();
	        if (instream == null) {
	            return null;
	        }
	        try {
	            Args.check(entity.getContentLength() <= Integer.MAX_VALUE,
	                    "HTTP entity too large to be buffered in memory");
	            int i = (int)entity.getContentLength();
	            if (i < 0) {
	                i = 4096;
	            }
	            Charset charset = null;
	            try {
	                final ContentType contentType = ContentType.get(entity);
	                if (contentType != null) {
	                    charset = contentType.getCharset();
	                }
	            } catch (final UnsupportedCharsetException ex) {
	                if (defaultCharset == null) {
	                    throw new UnsupportedEncodingException(ex.getMessage());
	                }
	            }
	            if (charset == null) {
	                charset = defaultCharset;
	            }
	            if (charset == null) {
	                charset = HTTP.DEF_CONTENT_CHARSET;
	            }
	            final Reader reader = new InputStreamReader(instream, charset);
	            final CharArrayBuffer buffer = new CharArrayBuffer(i);
	            final char[] tmp = new char[1024];
	            int l;
	            while((l = reader.read(tmp)) != -1) {
	                buffer.append(tmp, 0, l);
	            }
	            return buffer.toString();
	        } finally {
	            instream.close();
	        }
	    }
	
	
}
