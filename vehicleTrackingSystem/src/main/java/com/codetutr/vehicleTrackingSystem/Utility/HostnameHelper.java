package com.codetutr.vehicleTrackingSystem.Utility;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class HostnameHelper 
{
	
	
	private static final String CLASS_NAME = HostnameHelper.class.getName();
	private static final Logger LOGGER = Logger.getLogger(CLASS_NAME);
	
	private static HostnameHelper instance;
	
	private final String localHostname;
	
	private HostnameHelper()
	{
		String methodName = "HostnameHelper()";
		LOGGER.entering(CLASS_NAME, methodName);
		
		InetAddress localhost = null;
		
		try
		{
			//This relies on DNS lookup, and can fail.
			localhost = InetAddress.getLocalHost();
		}
		catch(UnknownHostException unknownHostException)
		{
			LOGGER.logp(Level.SEVERE, CLASS_NAME, methodName, "Failed to resolve the local hostname by DNS lookup.", unknownHostException);
		}
		
		if(localhost == null)
		{
			localHostname = null;
		}
		else
		{
			localHostname = localhost.getHostName();
		}
		
		LOGGER.exiting(CLASS_NAME, methodName);
	}
	
	
	public static HostnameHelper getInstance()
	{
		if(instance == null)
		{
			instance = new HostnameHelper();
		}
		
		return instance;
	}
	
	
	public String getLocalHostname()
	{
		return localHostname;
	}
	
	

}

