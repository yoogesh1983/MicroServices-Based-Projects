package com.codetutr.vehicleTrackingSystem.RestHelper;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.codetutr.vehicleTrackingSystem.Exception.MyCountryException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public abstract class AbstractServiceClient 
{

    private static final String CLASS_NAME = AbstractServiceClient.class.getName();
    private static final Logger LOGGER = Logger.getLogger(CLASS_NAME);
    
    
    
	public static String marshal(Object object) throws Exception
	{
		String methodName = "marshal(Object)";
        LOGGER.entering(CLASS_NAME, methodName);
        
		ObjectMapper OBJECT_MAPPER = new ObjectMapper();
		String response = null;
		
		try
		{
			ObjectWriter objectWriter = OBJECT_MAPPER.writer();
			response = objectWriter.writeValueAsString(object);
		}
		catch(Exception e)
		{
			String errMsg = "Error with Object marshal to JSON:" + e.getMessage() + " - Java Object = " + object;
            LOGGER.logp(Level.SEVERE, CLASS_NAME, methodName, errMsg, e);
            throw new MyCountryException(errMsg);
		}
	    finally
	    {
	    	 LOGGER.exiting(CLASS_NAME, methodName);
	    }
		
		return response;
	}

  
   public <Type> MyCountryResponse<Type> unmarshal(String input, Class<Type> objectClass)
    {
        String methodName = "unmarshal(String, Class<Type>)";
        LOGGER.entering(CLASS_NAME, methodName);

       ObjectMapper mapper = new ObjectMapper();
       MyCountryResponse<Type> mcResponse = null;

       try

        {
            JavaType javaType = mapper.getTypeFactory().constructParametrizedType(MyCountryResponse.class,MyCountryResponse.class, objectClass);
            mcResponse = mapper.readValue(input, javaType);

        }

       catch(Exception e)

         {
            String errMsg = "Error with JSON unmarshal:" + e.getMessage() + " - Raw JSON response = " + input;
            LOGGER.logp(Level.SEVERE, CLASS_NAME, methodName, errMsg, e);
            throw new MyCountryException(errMsg);
         }
       finally
       {
    	   LOGGER.exiting(CLASS_NAME, methodName);
       }
       
       return mcResponse;
       
    }
   
   public <Type> MyCountryResponse<ArrayList<Type>> unmarshalList(String input, Class<Type> objectClass)
   {
	   
	   String methodName = "unmarshalList(String, Class<Type>)";
	   LOGGER.entering(CLASS_NAME, methodName);
	   
	   
	   ObjectMapper mapper = new ObjectMapper();
	   MyCountryResponse<ArrayList<Type>> mcResponse = null;
	   
	   try
	   {
		   // unmarshall the MyCountryResponse only
		   JavaType javaType = mapper.getTypeFactory().constructParametrizedType(MyCountryResponse.class, MyCountryResponse.class, Object.class);
		   MyCountryResponse<Object> response = mapper.readValue(input, javaType);
		   
		   // get the data attribute as JSON
		   String dataJson = mapper.writeValueAsString(response.getData());
		   
		   // unmarshall the data as a list
		   JavaType listType = mapper.getTypeFactory().constructParametrizedType(ArrayList.class, ArrayList.class, objectClass);
		   ArrayList<Type> listResponse = mapper.readValue(dataJson, listType);
		   
		   // map the full response
		   mcResponse = new MyCountryResponse<ArrayList<Type>>();
		   mcResponse.setTransactionId(response.getTransactionId());
		   mcResponse.setHostName(response.getHostName());
		   mcResponse.setErrors(response.getErrors());
		   mcResponse.setData(listResponse);
		     
	   }
	   
	   catch(Exception e)
	   {
		   String errMsg = "Error with JSON unmarshal:" + e.getMessage() + " -Raw JSON response = " + input;
		   LOGGER.logp(Level.SEVERE, CLASS_NAME, methodName, errMsg, e);
		   throw new MyCountryException(errMsg);
	   }
	   
	   finally
	   {
		   LOGGER.exiting(CLASS_NAME, methodName);
	   }
	   
	   return mcResponse;
   }

}
