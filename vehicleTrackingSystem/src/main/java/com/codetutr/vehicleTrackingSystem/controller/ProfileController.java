package com.codetutr.vehicleTrackingSystem.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.codetutr.vehicleTrackingSystem.Entity.Profile;
import com.codetutr.vehicleTrackingSystem.service.CoreServiceClient;

@RestController
public class ProfileController 
{
	@Autowired
	private CoreServiceClient coreServiceClient;
	
	
	//GetAllProfiles
	@RequestMapping(value="/profile", method=RequestMethod.GET)	
	public List<Profile> getAllProfiles()
	{
		List<Profile> allProfiles = coreServiceClient.getAllProfiles();
		return allProfiles;
	}
	
	
	
	//GetProfilebyProfileId
	@RequestMapping(value="/profile/{id}", method=RequestMethod.GET)	
	public Profile getProfileByProfileId(@PathVariable Map<Object, Object>  myparams)
	{
		long id = 0L;
		try
		{
			id = Long.parseLong((String)myparams.get("id"));
		}
		catch(Exception e)
		{
			System.out.println("could not parse input variable to long." + "Exception is ===========> " + e);
			//throw new MyCountryException("could not parse input variable to long.", ExceptionCode.GENERAL, e);
		}
		
		Profile profile = coreServiceClient.getProfileByProfileId(id);
		return profile;
	}
	
	
	
	//UpdateProfile
	@RequestMapping(value="/profile/UpdateProfile", method=RequestMethod.POST)	
	public Profile updateProfile(HttpServletRequest request, @ModelAttribute("profile") Profile profile)
	{
		Profile updatedProfile = coreServiceClient.updateProfile(profile);
		return updatedProfile;
	}
	
	
	//DeleteProfile
	@RequestMapping(value="/profile/DeleteProfile/{id}", method=RequestMethod.GET)
	public Boolean deleteProfile(@PathVariable Map<Object, Object>  myparams)
	{
		long id = 0L;
		try
		{
			id = Long.parseLong((String)myparams.get("id"));
		}
		catch(Exception e)
		{
			System.out.println("could not parse input variable to long." + "Exception is ===========> " + e);
			//throw new MyCountryException("could not parse input variable to long.", ExceptionCode.GENERAL, e);
		}
		
		return coreServiceClient.deleteProfile(id);
	}
	

}
