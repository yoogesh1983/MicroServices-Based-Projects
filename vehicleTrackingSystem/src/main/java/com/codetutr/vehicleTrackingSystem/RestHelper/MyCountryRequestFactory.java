package com.codetutr.vehicleTrackingSystem.RestHelper;


public class MyCountryRequestFactory
{
	public static <Type> MyCountryRequest<Type>  getRequest(Type data)
	{
		MyCountryRequest <Type> request = new MyCountryRequest<>();
		
		request.setData(data);
		
		return request;
	}


}
