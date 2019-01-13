package com.codetutr.vehicleTrackingSystem.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.codetutr.vehicleTrackingSystem.Entity.Profile;
import com.codetutr.vehicleTrackingSystem.config.Role;
import com.codetutr.vehicleTrackingSystem.service.CoreServiceClient;

@Controller
public class MyAccountController 
{
	private static final String NAME_OF_CURRENT_USER = "nameofuser";
	private static final String ROLE_OF_CURRENT_USER = "roleofuser";
	private static final String PROFILE_ID_OF_USER = "profileIdofUser";
	
	@Autowired
	private CoreServiceClient coreServiceClient;
	
	 @Autowired
	 Role role;
	
	@RequestMapping(value = "/my-account-user", method = RequestMethod.GET)
	public String normalUserPage(ModelMap model, HttpServletRequest request) 
	{
		//String username = SecurityContextHolder.getContext().getAuthentication().getName();
		setdata(model, getPrincipal(), request);
		return "security/myAccountUser";
	}

	@RequestMapping(value = "/my-account-admin", method = RequestMethod.GET)
	public String adminPage(ModelMap model, HttpServletRequest request) 
	{
		//String username = SecurityContextHolder.getContext().getAuthentication().getName();
		setdata(model, getPrincipal(), request);
		return "security/myAccountAdmin";
	}
	
	
	
	@RequestMapping(value = "/my-account-dba", method = RequestMethod.GET)
	public String databaseAdminpage(ModelMap model, HttpServletRequest request) 
	{
		//String username = SecurityContextHolder.getContext().getAuthentication().getName();
		setdata(model, getPrincipal(), request);
		return "security/MyAccountDba";
	}
	
	
	private String getPrincipal()
	{
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) 
		{
			userName = ((UserDetails)principal).getUsername();
		} 
		
		else 
		{
			userName = principal.toString();
		}
		return userName;
	}

	
	private void setdata(ModelMap model, String username, HttpServletRequest request) 
	{
		Profile profile = null;
		  try
		  {
			  profile = coreServiceClient.getProfileByUserName(username);
			  model.addAttribute("username", username);
			  model.addAttribute("profile", profile);
			  model.addAttribute("vehicles", profile.getVehicles());
			  request.getSession().setAttribute(NAME_OF_CURRENT_USER, profile.getFirstName());
			  request.getSession().setAttribute(PROFILE_ID_OF_USER, profile.getId());
			  
			  UserDetails  userDetails = role.loadUserByUsername(username);
			  Collection<? extends GrantedAuthority> ud = userDetails.getAuthorities();
			  request.getSession().setAttribute(ROLE_OF_CURRENT_USER, ud.iterator().next().toString());
			  
		  }
		  catch(Exception e)
		  {
			  
		  }
	}
	
}
