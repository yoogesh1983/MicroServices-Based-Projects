package com.codetutr.vehicleTrackingSystem.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccessDeniedController
{
	@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) 
	{
	    String username = SecurityContextHolder.getContext().getAuthentication().getName();
	    model.addAttribute("username", username);
		return "security/accessDenied";
	}

}
