package com.codetutr.vehicleTrackingSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.codetutr.vehicleTrackingSystem.Entity.Vehicle;
import com.codetutr.vehicleTrackingSystem.Exception.MyCountryException;
import com.codetutr.vehicleTrackingSystem.Model.Position;
import com.codetutr.vehicleTrackingSystem.Utility.RemotePositionMicroServiceCall;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MicroService 
{
	// you can use this when there is no load balancer
	@Autowired
	private DiscoveryClient discoveryClient;     

	
	 // This is the preferred one... expecially when loadbalncer is there
	@Autowired
	private LoadBalancerClient loadBalancerClient; 
	
	@Autowired
	private RemotePositionMicroServiceCall remotePositinMicroServiceCall;
	
	
	@Autowired
	private CoreServiceClient coreServiceClient;
	
	
	/* If the situation is become dire, then this method will automatically be skipped and will go to handleExernalServiceDown() method
	   default settings:
	                     - If there were more than 20 invocations of the method in a 10 second time window and more then 50% failed, then 
	                       the circuit will break (open) i.e. skip this method and go to handleExernalServiceDown()
	               
	*/
	
	@HystrixCommand(fallbackMethod="handleExernalServiceDown")
	public Position getLatestPositionForVehicleFromRemoveMicroService(String vehicleNametobeFetch, String name)
	{
		System.out.println("Entering to getLatestPositionForVehicleFromRemoveMicroService() method");
		
		
		/*
		 * 
		 * If using Ribbon
		 * 
		 *
		   ServiceInstance eurakeInstance = loadBalancerClient.choose("CSX-PositionTracking");
		*/
		
		
		
		/*
		 * If using DisveryClient
		 * 
		 * 
		List<ServiceInstance> instances = discoveryClient.getInstances("CSX-PositionTracking");
		ServiceInstance eurakeInstance = null;
		if(instances !=null)
			 eurakeInstance = instances.get(0);
		*/
		
		
		
		//String uri = eurakeInstance.getUri().toString();
		//RestTemplate rest = new RestTemplate();
		//Position position = rest.getForObject(uri + "/vehicles/" + vehicleNametobeFetch, Position.class);
		
		
		
		
		//Using Feign
		Position position = remotePositinMicroServiceCall.getTheLatestPositionOfTheVehicle(vehicleNametobeFetch);
		
		if(position == null)
		{
			throw new MyCountryException("Null is returned while calling microservice rest call.....");
		}
		else
		{
			//Update into Database now
			List<Vehicle> vehicles = coreServiceClient.getVehicleByName(name);
			Vehicle vehicleFromDb = vehicles.get(0);
			vehicleFromDb.setLat(position.getLat());
			vehicleFromDb.setLongitude(position.getLongitude());
			vehicleFromDb.setTimestamp(position.getTimestamp());
			coreServiceClient.updateVehicle(vehicleFromDb);
		}
		
		return position;
	}
	
	
	
	public Position handleExernalServiceDown(String vehicleNametobeFetch, String name)
	{
		System.out.println("Entering into handleExernalServiceDown() which is FallBack method");
		List<Vehicle> vehicles = coreServiceClient.getVehicleByName(name);
		Vehicle vehicleFromDb = vehicles.get(0);
		
		//Set the Old value
		Position position = new Position();
		position.setLat(vehicleFromDb.getLat());
		position.setLongitude(vehicleFromDb.getLongitude());
		position.setTimestamp(vehicleFromDb.getTimestamp());
		
		return position;
	}

}
