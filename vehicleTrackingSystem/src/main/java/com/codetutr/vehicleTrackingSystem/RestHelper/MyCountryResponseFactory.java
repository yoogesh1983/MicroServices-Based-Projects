package com.codetutr.vehicleTrackingSystem.RestHelper;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

import com.codetutr.vehicleTrackingSystem.Exception.ErrorType;
import com.codetutr.vehicleTrackingSystem.Utility.HostnameHelper;


public class MyCountryResponseFactory {
	
	public static <Type> MyCountryResponse<Type> getResponse(Type data)
	{
		MyCountryResponse<Type> response = new MyCountryResponse<>();
		
		response.setData(data);
		
		String transactionId = "44444";
		response.setTransactionId(transactionId);
		
		String hostname = getHostname();
		response.setHostName(hostname);
		
		return response;
	}
	
	
	public static <Type> MyCountryResponse<Type> getResponse(Type data, ArrayList<ErrorType> error)
	{
		MyCountryResponse<Type> response = new MyCountryResponse<>();
		
		response.setData(data);
		
		String transactionId = "44444";
		response.setTransactionId(transactionId);
		
		String hostname = getHostname();
		response.setHostName(hostname);
		
		response.setErrors(error);
		
		return response;
	}
	
	
	private static String getHostname()
	{
		HostnameHelper hostnameHelper = HostnameHelper.getInstance();
		String hostname = hostnameHelper.getLocalHostname();
		
		if((hostname = StringUtils.trimToNull(hostname)) == null)
		{
			hostname = "N/A";
		}
		
		return hostname;
	}
	

}
