package com.codetutr.vehicleTrackingSystem.RestHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.codetutr.vehicleTrackingSystem.Exception.MyCountryException;


public class HttpAdapter 
{
	private static final String CLASS_NAME = HttpAdapter.class.getName();
	private static final Logger LOGGER = Logger.getLogger(CLASS_NAME);
	
	public <T> String post(String url, MyCountryRequest<T> request, int readTimeout, BasicAuthenticationCredentials credentials)
	{
		String methodName = "post(String, MyCountryRequest, int, BasicAuthenticationCredentials)";
		LOGGER.entering(CLASS_NAME, methodName);
		
		String response = executePost(url, request, readTimeout, credentials, Level.INFO);
		LOGGER.exiting(CLASS_NAME, methodName);
		
		return response;
	}
	
	
	
	public <T> String postWithFineLogging(String url, MyCountryRequest<T> request, int readTimeout, BasicAuthenticationCredentials credentials)
	{
		String methodName = "postWithFineLogging(String, MyCountryRequest, int, BasicAuthenticationCredentials)";
		LOGGER.entering(CLASS_NAME, methodName);
		
		String response = executePost(url, request, readTimeout, credentials, Level.FINE);
		LOGGER.exiting(CLASS_NAME, methodName);
		
		return response;
	}
	
	
	public <T> String post(String url, String id,  MyCountryRequest<T> request, int readTimeout, BasicAuthenticationCredentials credentials)
	{
		String methodName = "post(String, String, MyCountryRequest, int, BasicAuthenticationCredentials)";
		LOGGER.entering(CLASS_NAME, methodName);
		
		String fullUrl = StringUtils.replace(url, "{id}", id);
		String response = executePost(fullUrl, request, readTimeout, credentials, Level.INFO);
		LOGGER.exiting(CLASS_NAME, methodName);
		
		return response;
	}
	
	
	public <T> String postWithFineLogging(String url,String id,  MyCountryRequest<T> request, int readTimeout, BasicAuthenticationCredentials credentials)
	{
		String methodName = "postWithFineLogging(String,String, MyCountryRequest, int, BasicAuthenticationCredentials)";
		LOGGER.entering(CLASS_NAME, methodName);
		
		String fullUrl = StringUtils.replace(url, "{id}", id);
		String response = executePost(fullUrl, request, readTimeout, credentials, Level.FINE);
		LOGGER.exiting(CLASS_NAME, methodName);
		
		return response;
	}
	
	
	public <T> String executePost(String url, MyCountryRequest<T> request, int readTimeout, BasicAuthenticationCredentials credentials, Level level)
	{
		String methodName = "executePost(String, MyCountryRequest, int, BasicAuthenticationCredentials, Level)";
		LOGGER.entering(CLASS_NAME, methodName);
		
		String response = null;
		
//		MyCountryRequestContextInfoHelper requestContextInfoHelper = MyCountryRequestContextInfoHelper.getInstance();
//		MyCountryRequestContextInfo requestContextInfo = requestContextInfoHelper.retrieveRequestContextInfo();
//		String transactionId = requestContextInfoHelper.getTransactionId(requestContextInfo);
		
		String transactionId = "44444";
		
		try
		{ 
			
		   RestTemplate restTemplate = getRestTemplate(readTimeout);
		   
		   // Basic auth and request context info
		   HttpHeaders headers = createHeaders(credentials);
		   HttpEntity<MyCountryRequest<T>> httpEntity = new HttpEntity<> (request, headers);
		   
		   LOGGER.logp(Level.INFO, CLASS_NAME, methodName, "transactionId:" + transactionId + " -- post to: " + url + "--post body" + request);
		   
		   //POST
		   ResponseEntity<String> responseEntity  = restTemplate.exchange(url, HttpMethod.POST, httpEntity, String.class);
		   
		   response = responseEntity.getBody();
		   
		   LOGGER.logp(Level.INFO, CLASS_NAME, methodName, "transactionId:" + transactionId + " -- response code: " + responseEntity.getStatusCode() + "--response body:" + response);
		   
		
		   // Make sure the response code is still written out at INFO
		   
		   if(level == Level.FINE)
		   {
			   LOGGER.logp(Level.INFO, CLASS_NAME, methodName, "transactionId:" + transactionId + " -- response code: " + responseEntity.getStatusCode());
		   }
		
		}
		
		catch(Exception e)
		{
			String errMsg = "transactionId: " + transactionId + "--HttpAdapter error: " + e;
			LOGGER.logp(Level.WARNING, CLASS_NAME, methodName, errMsg, e);
			throw new MyCountryException(e.getMessage());
		}
		
		finally
		{
			LOGGER.exiting(CLASS_NAME, methodName);
		}
		
		return response;
		
	}
		
		
	public String get(String url, String id, int readTimeout, BasicAuthenticationCredentials credentials)
	{
		String methodName = "get(String, String, int, BasicAuthenticationCredentials)";
		LOGGER.entering(CLASS_NAME, methodName);
		
		String fullUrl = StringUtils.replace(url, "{id}", id);
		
		String response = get(fullUrl, readTimeout, credentials, Level.INFO);
		LOGGER.exiting(CLASS_NAME, methodName);
		
		return response;
	}
		
		
		
	public String getWithFineLogging(String url, String id, int readTimeout, BasicAuthenticationCredentials credentials)
	{
		String methodName = "getWithFineLogging(String, String, int, BasicAuthenticationCredentials)";
		LOGGER.entering(CLASS_NAME, methodName);
		
		String fullUrl = StringUtils.replace(url, "{id}", id);
		
		String response = get(fullUrl, readTimeout, credentials, Level.FINE);
		
		LOGGER.exiting(CLASS_NAME, methodName);
		
		return response;
	}

	
	public String  get(String url, ArrayList<Pair<String, String>> nameValuePairs, int readTimeout, BasicAuthenticationCredentials credentials)
	{
		String methodName = "get(String, ArrayList<Pair<String, String>>, int,BasicAuthenticationCredentials) ";
		LOGGER.entering(CLASS_NAME, methodName);
		
		String response = get(url, nameValuePairs, readTimeout, credentials, Level.INFO);
		LOGGER.exiting(CLASS_NAME, methodName);
		
		return response;
	}
		
		
	public String getWithFineLogging (String url, ArrayList<Pair<String, String>> nameValuePairs, int readTimeout, BasicAuthenticationCredentials credentials)
	{
		
		String methodName = "getWithFineLogging(String, ArrayList<Pair<String, String>>, int, BasicAuthenticationCredentials";
		LOGGER.entering(CLASS_NAME, methodName);
		
		String response = get(url, nameValuePairs, readTimeout, credentials, Level.FINE);
		LOGGER.exiting(CLASS_NAME, methodName);
		
		return response;
	}
		
		
	private String get(String url, ArrayList<Pair<String, String>> nameValuePairs, int readTimeout, BasicAuthenticationCredentials credentials, Level level)
	{
		String methodName = "get(String, ArrayList<Pair<String, String>>, int, BasicAuthenticationCredentials, Level)";
		LOGGER.entering(CLASS_NAME, methodName);
		
		String fullUrl = url;
		
		for(Pair<String, String> nameValuePair : nameValuePairs)
		{
			// have to uri encode the values ( not urlencode) in case they have special uri/url chars
			//urlencode will change spaces to + instead of %20. + works goeed in querystring values, but since we are
			//sending these up as part of the uri and not querystring need them to be %20 otherwise the jax-rs pathparam 
			// annotation will not decode them
			String value = nameValuePair.getRight();
			fullUrl = StringUtils.replace(fullUrl, nameValuePair.getLeft(), value);
		}
		
		String response = get(fullUrl, readTimeout, credentials, level);
		LOGGER.exiting(CLASS_NAME, methodName);
		
		return response;
	}
	
		
	
	public String get(String url, int readTimeout, BasicAuthenticationCredentials credentials, Level level)
	{
		String methodName = "get(String, int, BasicAuthenticationCredentials, Level)";
		LOGGER.entering(CLASS_NAME, methodName);
		
		String response = null;
		
		String transactionId = "44444";
		
		try
		{   
			RestTemplate restTemplate = getRestTemplate(readTimeout);
			
			//Basic auth
			HttpHeaders headers = createHeaders(credentials);
			HttpEntity<String> httpEntity = new HttpEntity<>(headers);
			
			
			LOGGER.logp(level.INFO, CLASS_NAME, methodName, "transactionId:" + transactionId + " -- get to : " + url) ;
			//GET
			ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
			
			response = responseEntity.getBody(); 
			
			LOGGER.logp(level.INFO, CLASS_NAME, methodName, "transactionId:" + transactionId + " -- response code : " + responseEntity.getStatusCode() + "--response body :" + response) ;
			
			//make sure the response code is still written out at INFO
			if(level ==Level.FINE)
			{
				LOGGER.logp(level.INFO, CLASS_NAME, methodName, "transactionId:" + transactionId + " -- response code : " + responseEntity.getStatusCode()) ;	
			}
			
		}
		
		catch(Exception e)
		{
			String errMsg = "transactionId: " + transactionId + " -- HttpAdapter error: " + e;
			LOGGER.logp(Level.WARNING, CLASS_NAME, methodName, errMsg, e);
			throw new MyCountryException(e.getMessage());
		}
		
		finally
		{
			LOGGER.exiting(CLASS_NAME, methodName);
		}
		
		return response;
	}
	
	
	private HttpHeaders createHeaders(BasicAuthenticationCredentials credentials)
	{
		String methodName = "createHeaders(BasicAuthenticationCredentials)";
		LOGGER.entering(CLASS_NAME, methodName);
		
		
		HttpHeaders httpHeaders = new HttpHeaders();
		
		if(credentials !=null)
		{
			String authorizationHeaderValue = credentials.toAuthorizationHeaderValue();
			
			List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
			acceptableMediaTypes .add(MediaType.APPLICATION_XML);
			acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
            httpHeaders.setAccept(acceptableMediaTypes);
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
			
			httpHeaders.add("Authorization", authorizationHeaderValue);
		}
		
		LOGGER.exiting(CLASS_NAME, methodName);
		
		return httpHeaders;
	}
	
	
	private RestTemplate getRestTemplate(int readTimeout)
	{
		String methodName = "getRestTemplate()";
		LOGGER.entering(CLASS_NAME, methodName);
		
		//Set Timeouts
		
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setReadTimeout(readTimeout);
		requestFactory.setConnectTimeout(5000);
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		LOGGER.exiting(CLASS_NAME, methodName);
		
		return restTemplate;
	}
		


}
