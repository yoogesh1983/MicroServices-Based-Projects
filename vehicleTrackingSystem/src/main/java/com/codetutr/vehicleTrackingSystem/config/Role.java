package com.codetutr.vehicleTrackingSystem.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.codetutr.vehicleTrackingSystem.Entity.Profile;
import com.codetutr.vehicleTrackingSystem.service.CoreServiceClient;


@Configuration
public class Role implements UserDetailsService 
{
	@Autowired
	private CoreServiceClient coreServiceClient;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		if(username == null)
		{
			return null;
		}
		
		Profile profile = coreServiceClient.getProfileByUserName(username);
		
		if(profile == null)
		{
			return null;  // Spring security will handle it
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(profile.getRole()));
		UserDetails userDetails = new org.springframework.security.core.userdetails.User(profile.getUsername(), profile.getPassword(), true, true, true, true, authorities);
		
		return userDetails;
	}

}
