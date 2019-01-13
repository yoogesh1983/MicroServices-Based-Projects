package com.codetutr.vehicleTrackingSystem.Rest;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.codetutr.vehicleTrackingSystem.Entity.Vehicle;
import com.codetutr.vehicleTrackingSystem.Exception.MyCountryException;
import com.codetutr.vehicleTrackingSystem.RestHelper.MyCountryResponse;
import com.codetutr.vehicleTrackingSystem.RestHelper.MyCountryResponseFactory;
import com.codetutr.vehicleTrackingSystem.service.VehicleService;

@RestController
@RequestMapping(value="/Services")
public class VehicleRS 
{
	private static final String CLASS_NAME = VehicleRS.class.getName();
	private static final Logger LOGGER =  Logger.getLogger(CLASS_NAME);
	
	@Autowired
	VehicleService vehicleService;
	
	@RequestMapping(value ="/getAllVehicles", method = RequestMethod.GET,
	consumes = {MediaType.APPLICATION_JSON_VALUE},
	produces = {MediaType.APPLICATION_JSON_VALUE}
	)
	public  MyCountryResponse<ArrayList<Vehicle>> getAllVehicles()
	{
		String methodName = "getAllProfiles()";
		LOGGER.entering(CLASS_NAME, methodName);
		
		MyCountryResponse<ArrayList<Vehicle>> response = null;
		String transactionId = "44444";
		
		try{
				LOGGER.logp(Level.INFO,CLASS_NAME, methodName, "SVCREQUEST(" + transactionId  + ")");
			
				ArrayList<Vehicle> vehicles = (ArrayList<Vehicle>) vehicleService.getAllVehicles();
				response = MyCountryResponseFactory.getResponse(vehicles);
			
				LOGGER.logp(Level.INFO, CLASS_NAME, methodName, "SVCRESPONSE(" + transactionId + "): " + response);	
	        }
		
		catch (MyCountryException mce){
			
				String errMsg = "Error calling service" + mce.getMessage();
				LOGGER.logp(Level.SEVERE, CLASS_NAME, methodName, "transactionId: " + transactionId + "--" + errMsg);
				logAdditionalInfo(transactionId);
				throw mce;
		     }
		
	    catch(Exception e){
				String errMsg = "Error calling service" + e.getMessage();
				LOGGER.logp(Level.SEVERE, CLASS_NAME, methodName, "transactionId: " + transactionId + "--" + errMsg, e);
				logAdditionalInfo(transactionId);
				throw new MyCountryException(errMsg);
			}
			
		finally{
				 LOGGER.exiting(CLASS_NAME, methodName);
			}
			
		return response;
	}
	
	
	
	protected void logAdditionalInfo(String transactionId)
	{
		String methodName = "getOtp(String)";
		LOGGER.entering(CLASS_NAME, methodName);
		
		
		// log some additional info about the profile
		String clientIp = "Unknown";
		String browserAgent = "Unknown";
		
		try
		{
		    clientIp = "168.198.10.30";
			browserAgent = "Monzila firefox";
		}
		catch(Throwable tt)
		{ 
			// eat it!! 
		}
		
		String errMessage = "Info Dump for Exception:  [transactionId= " + transactionId + "][cientip = " + clientIp + "],[browserAgent = " + browserAgent + "]";
		                    
		LOGGER.logp(Level.INFO, CLASS_NAME, methodName, errMessage);
		
		LOGGER.exiting(CLASS_NAME, methodName);	
	}

}
