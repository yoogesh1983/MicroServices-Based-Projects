package com.codetutr.vehicleTrackingSystem.Utility;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codetutr.vehicleTrackingSystem.Model.Position;

@FeignClient(name="CSX-PositionTracking")
public interface RemotePositionMicroServiceCall 
{
	//Rest call
	@RequestMapping(method=RequestMethod.GET, value="/vehicles/{vehicleNametobeFetch}")
	public Position getTheLatestPositionOfTheVehicle(@PathVariable("vehicleNametobeFetch") String vehicleNametobeFetch);
		
}
