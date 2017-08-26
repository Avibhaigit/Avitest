package com.revolut.http;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.commons.*;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import java.io.IOException;

/**
 * @author Devavratt Bagayat
 *
 */
public class RevolutHttpClient {
	 public static final ClassLoader CLASS_LOADER = RevolutHttpClient.class.getClassLoader();
	 
	
	public String doGet(final String pTargetUrl) {
		HttpResponse httpResponse = null;
		String result = "false";
		//HttpGet httpget = null;
		StatusLine statusLine = null;
		//httpget = createHttpGet(pTargetUrl);
		//httpResponse = execute(httpget);
		String response = getFakeJSONResponse(pTargetUrl);
		if (httpResponse != null) {
			statusLine = httpResponse.getStatusLine();
		}
		if (statusLine != null && statusLine.getStatusCode() == 200) {
		} else {
		}
		return response;
	}

	private void addHttpHeaders(Map<String, String> pHeaders, HttpGet httpget) {
		// TODO Auto-generated method stub

	}

	private HttpResponse execute(HttpGet httpget) {
		// TODO Auto-generated method stub
		HttpResponse httpResponse = null;
		HttpClient httpClient = HttpClientBuilder.create().build();
		try {
			httpResponse= httpClient.execute(httpget);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return httpResponse;
	}
	
	private HttpGet createHttpGet(String pTargetUrl) {
		// TODO Auto-generated method stub
		 HttpGet httpGet = new HttpGet(pTargetUrl);
		    return httpGet;
	}
	
	/**
	   * Get the Fake response for the given target URL.
	   *
	   * @return the fakeResponse String
	   */
	  protected String getFakeJSONResponse(final String targetUrl) {
	    String jsonResponse = null;

	    try {
	      String resourceFilename = "/jsonResponse/account_details.json";
	      jsonResponse = readResourceFromClasspath(resourceFilename);
	        	jsonResponse = readResourceFromFile(resourceFilename);
	    } catch (IOException e) {
	      
	    }
	    return jsonResponse;

	  }
	
	/**
     * Read the given resource from the classpath
     *
     * @param resourcePath
     *            Resource fully qualified path. If resource is in
     *            com.fit.fake.fakeBooking.xml then this method expects the path
     *            to be /com/fit/fake/fakeBooking.xml
     * @return the resource file contents as string
     * @throws IOException
     */
    public static String readResourceFromClasspath(final String resourcePath) throws IOException {
        String xmlAsString = null;
        InputStream inStream = null;
        try {
            if (StringUtils.isNotEmpty(resourcePath)) {
                inStream = RevolutHttpClient.CLASS_LOADER.getResourceAsStream(resourcePath);

                if (inStream != null) {
                    xmlAsString = IOUtils.toString(inStream, "UTF-8");
                }
            }
        } finally {
            IOUtils.closeQuietly(inStream);
        }
        return xmlAsString;
    }
    
    /**
     * Read the given resource from the classpath
     *
     * @param resourcePath
     *            Resource fully qualified path. If resource is in
     *            com.fit.fake.fakeBooking.xml then this method expects the path
     *            to be /com/fit/fake/fakeBooking.xml
     * @return the resource file contents as string
     * @throws IOException
     */
    public static String readResourceFromFile(final String resourcePath) throws IOException {
        String jsonAsString = null;
        InputStream inStream = null;
        try {
            if (StringUtils.isNotEmpty(resourcePath)) {
                final File file = new File(resourcePath);
                if (file.isFile()) {
                    inStream = new FileInputStream(file);
                }

                if (inStream != null) {
                    jsonAsString = IOUtils.toString(inStream, "UTF-8");
                }
            }
        } finally {
            IOUtils.closeQuietly(inStream);
        }
        return jsonAsString;
    }
    
   
}
