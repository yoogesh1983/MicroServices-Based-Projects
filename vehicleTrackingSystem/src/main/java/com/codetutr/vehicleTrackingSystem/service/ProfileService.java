package com.codetutr.vehicleTrackingSystem.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codetutr.vehicleTrackingSystem.Entity.Profile;
import com.codetutr.vehicleTrackingSystem.Entity.Vehicle;
import com.codetutr.vehicleTrackingSystem.repository.Hibernate.ProfileRepositoryOldWay;
import com.codetutr.vehicleTrackingSystem.repository.SpringData.ProfileRepository;

@Service
public class ProfileService 
{
	@Autowired
	private ProfileRepositoryOldWay dao;
	
	@Autowired
	ProfileRepository springDataJpa;
	
	//Insert
	public Profile saveProfile(Profile profile)
	{
		Profile savedProfile = null;
		try
		{
			savedProfile = dao.save(profile);
		}
		catch(Exception e)
		{
			
		}
		return savedProfile;
	}
	
	
	//Read
	public Profile getProfileByProfileId(long id)
	{
		Profile profile = null;
		
		try
		{
			profile = dao.getProfileByProfileId(id);
		}
		catch(Exception e)
		{
			profile = null;
		}
		
		return profile;
	}

	
	public Profile getProfileByUserName(String username)
	{
		Profile profile = null;
		
		try
		{
			profile = springDataJpa.findByusername(username);
		}
		catch(Exception e)
		{
			profile = null;
		}
		
		return profile;
	}

	public List<Profile> getAllProfiles() 
	{
		List<Profile>  profiles = new ArrayList<>();
		profiles = (List<Profile>) dao.findAllProfiles();
		return profiles;
	}
	
	
	//Update
	public Profile updateProfile(Profile profile)
	{
		Profile updatedProfile = null;
		try
		{
			updatedProfile = springDataJpa.save(profile);
		}
		catch(Exception e)
		{
			
		}
		return updatedProfile;
	}
	
	
	//Delete
	public boolean deleteProfile(Long id)
	{
		boolean deleted = false;
		
		try
		{
			springDataJpa.delete(id);
			deleted = true;
		}
		catch(Exception e)
		{
			deleted = false;
		}
		
		return deleted;
	}

}
