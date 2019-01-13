package com.codetutr.vehicleTrackingSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codetutr.vehicleTrackingSystem.Entity.Profile;
import com.codetutr.vehicleTrackingSystem.Entity.Vehicle;
import com.codetutr.vehicleTrackingSystem.Model.Position;
import com.codetutr.vehicleTrackingSystem.RestHelper.AbstractServiceClient;
import com.codetutr.vehicleTrackingSystem.RestHelper.BasicAuthenticationCredentials;
import com.codetutr.vehicleTrackingSystem.RestHelper.HttpAdapter;
import com.codetutr.vehicleTrackingSystem.RestHelper.MyCountryResponse;

@Service
@Transactional
public class CoreServiceClient extends AbstractServiceClient
{
	private static final String CLASS_NAME = CoreServiceClient.class.getName();
	private static final Logger LOGGER = Logger.getLogger(CLASS_NAME);
	
	
	@Autowired
	ProfileService profileService;
			
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	MicroService microService;
	
	private final String serviceBaseUrl;
	private final int serviceReadTimeout;
	private final BasicAuthenticationCredentials serviceCredentials;
	
	public CoreServiceClient()
	{
		serviceBaseUrl = "http://localhost:8080/VehicleTrackingSystem/dispatcher";
		serviceReadTimeout = 6000;
		
		serviceCredentials = new BasicAuthenticationCredentials();
		
		String serviceUsername = "yoogesh2002@yahoo.com";
		serviceCredentials.setUsername(serviceUsername);
		
		String servicePassword = "nepal@123";
		serviceCredentials.setPassword(servicePassword);
	}
	
	
	  /* ==================================== PROFILE =======================================================================*/
	
	
	public Profile saveProfile(Profile profile)
	{
		return profileService.saveProfile(profile);
	}
	
	
	public List<Profile> getAllProfiles()
	{
		return profileService.getAllProfiles();
	}
	
	
	public Profile getProfileByProfileId(long id)
	{
		return profileService.getProfileByProfileId(id);
	}
	
	public Profile getProfileByUserName(String username)
	{
		return profileService.getProfileByUserName(username);
	}
	
	public Profile updateProfile(Profile profile)
	{
		return profileService.updateProfile(profile);
	}
	
	
	public boolean deleteProfile(Long id)
	{
		return profileService.deleteProfile(id);
	}
	
	  /* ==================================== VEHICLE =======================================================================*/
	
	
	public Vehicle saveVehicle(Vehicle vehicle)
	{
		return vehicleService.saveVehicle(vehicle);
	}
	
	
	public List<Vehicle> getAllVehicles()
	{
		return vehicleService.getAllVehicles();
	}
	
	
	public List<Vehicle> getVehicleByName(String name)
	{
		return vehicleService.getVehicleByName(name);
	}
	
	public Vehicle getVehicleByVehicleId(long id) 
	{
		return vehicleService.getVehicleByVehicleId(id);
	}
	
	public Vehicle updateVehicle(Vehicle vehicle)
	{
		return vehicleService.updateVehicle(vehicle);
	}
	
	
	public boolean deleteVehicle(Long id)
	{
		return vehicleService.deleteVehicle(id);
	}
	
	/* ==================================== RESTFUL CALLS =======================================================================*/
	
	public List<Vehicle> getAllVehicles_Rest()
	{
		String methodName = "getAllProfile()";
		LOGGER.entering(CLASS_NAME, methodName);
		
		HttpAdapter httpAdapter = new HttpAdapter();
		String response = httpAdapter.get(serviceBaseUrl + "/Services/getAllVehicles", serviceReadTimeout, serviceCredentials, Level.INFO);
		
		//JSON to java mapping
		MyCountryResponse<ArrayList<Vehicle>> mcResponse = unmarshalList(response, Vehicle.class);
		ArrayList<Vehicle> vehicles = mcResponse.getData();
		
		LOGGER.exiting(CLASS_NAME, methodName);
		
		return vehicles;
	}

	
	
	
	/* ==================================== MICROSERVICES CALLS =======================================================================*/

	public Position getLatestPositionForVehicleFromRemoveMicroService(String vehicleNametobeFetch, String name) 
	{
		return microService.getLatestPositionForVehicleFromRemoveMicroService(vehicleNametobeFetch,name);
	}


	
}
