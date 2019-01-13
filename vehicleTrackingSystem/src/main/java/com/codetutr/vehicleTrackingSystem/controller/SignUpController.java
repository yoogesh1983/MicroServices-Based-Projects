package com.codetutr.vehicleTrackingSystem.controller;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.codetutr.vehicleTrackingSystem.Entity.Profile;
import com.codetutr.vehicleTrackingSystem.Entity.Vehicle;
import com.codetutr.vehicleTrackingSystem.service.CoreServiceClient;
 
@Controller
public class SignUpController 
{
	
	private static final String PROFILE_ID_OF_USER = "profileIdofUser";
	
	@Autowired
	private CoreServiceClient coreServiceClient;

	
	//Sign-up
	@RequestMapping(value="/Sign-Up.do",method=RequestMethod.GET)
	public ModelAndView renderNewProfileForm(HttpServletRequest request, HttpServletResponse response)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){    
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		Profile newProfile = new Profile();
		return new ModelAndView("security/signUp","profile",newProfile);
	} 
	
	
	@RequestMapping(value="/Sign-Up.do",method=RequestMethod.POST)
	public String newProfile(HttpServletRequest request, @ModelAttribute("profile") Profile profile)
	{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		profile.setPassword(passwordEncoder.encode(profile.getPassword()));
		profile.setRole("ROLE_USER");
		coreServiceClient.saveProfile(profile);
		
		return "redirect:/";
	}
	
	
	//Save vehicle Using ajax
	@RequestMapping(value="/save-vehicle-using-ajax",method=RequestMethod.GET)
	public String saveVehicleUsingAjax(HttpServletRequest request, HttpServletResponse response)
	{

		Vehicle vehicle = new Vehicle();
		request.setAttribute("vehicle", vehicle);
		return "security/saveVehicle";
	} 
	
	//Save vehicle Using ajax
	@RequestMapping(value="/save-vehicle-using-ajax",method=RequestMethod.POST)
	public String saveVehicleUsingAjaxPost(HttpServletRequest request, @ModelAttribute("vehicle") Vehicle vehicle)
	{
		vehicle.setName(vehicle.getName().toUpperCase());
		Long profileId = (Long) request.getSession().getAttribute(PROFILE_ID_OF_USER);
		if(profileId != null){
			Profile profile = coreServiceClient.getProfileByProfileId(profileId);
			if(profile != null)
			{
				vehicle.setProfile(profile);
			}
		}
		coreServiceClient.saveVehicle(vehicle);
		return "redirect:/my-account-user";
	}
 
}