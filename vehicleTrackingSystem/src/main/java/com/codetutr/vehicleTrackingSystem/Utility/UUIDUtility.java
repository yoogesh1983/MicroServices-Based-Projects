package com.codetutr.vehicleTrackingSystem.Utility;

import java.util.Random;
import java.util.UUID;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;

public class UUIDUtility 
{
	private static final String CLASS_NAME = UUIDUtility.class.getName();
	private static final Logger LOGGER = Logger.getLogger(CLASS_NAME);
	
	
	public static String generateUUID()
	{
		
		String methodName = "generateUUID()";
		LOGGER.entering(CLASS_NAME, methodName);
		
		UUID randomUUID = UUID.randomUUID();
		
		StringBuffer stringBuffer  = new StringBuffer();
		
		String mostSignificantBits = Long.toHexString(randomUUID.getMostSignificantBits());
	    stringBuffer.append(StringUtils.leftPad(mostSignificantBits, 16, '0'));
	    
	    
	    String leastSignificantBits = Long.toHexString(randomUUID.getLeastSignificantBits());
	    stringBuffer.append(StringUtils.leftPad(leastSignificantBits, 16, '0'));
	    
	    String uuid = stringBuffer.toString();
	    
	    LOGGER.exiting(CLASS_NAME, methodName);
	    
	    return uuid;
	}
	
	
	public static String generateFullUUID()
	{
		// returns full 36 char length uuid (used for db row ids)
		return UUID.randomUUID().toString();
	}
	
	
	
	public static String generateRandomInt()
	{
		// Generate a code Number for OTP
		 Random randomGenerator = new Random();
		 Integer number = randomGenerator.nextInt(1000000);
		 return number.toString();
	}


}
