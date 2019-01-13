package com.codetutr.vehicleTrackingSystem.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.codetutr.vehicleTrackingSystem.Entity.Profile;

public class CoreServiceClientTests 
{
	@Mock
	CoreServiceClient coreServiceClient;
	
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getProfileByIdTest() {
		 
		//Setting up expectations
		long id = 72L;
		Profile profile = new Profile();
		profile.setUsername("syoogesh@gmail.com");
		profile.setFirstName("yoogesh");
		
		Mockito.when(coreServiceClient.getProfileByProfileId(id)).thenReturn(profile);
		
		Profile returnedProfile = coreServiceClient.getProfileByProfileId(id);
		assertEquals(profile, returnedProfile);
		verify(coreServiceClient, times(1)).getProfileByProfileId(id);
		
	}

}
