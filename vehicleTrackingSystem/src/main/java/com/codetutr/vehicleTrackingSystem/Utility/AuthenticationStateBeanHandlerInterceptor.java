package com.codetutr.vehicleTrackingSystem.Utility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthenticationStateBeanHandlerInterceptor extends HandlerInterceptorAdapter
{
	private static final String NAME_OF_CURRENT_USER = "nameofuser";
	private static final String ROLE_OF_CURRENT_USER = "roleofuser";
	private static final String PROFILE_ID_OF_USER = "profileIdofUser";
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)throws Exception
	{
	    AuthenticationStateBean authenticationStateBean = new AuthenticationStateBean();
	    HttpSession session = request.getSession(false);
	    String name = null;
	    String role = null;
	    Long profileId = null;
	    
	    if (session != null) {
	    	name =  (String) request.getSession().getAttribute(NAME_OF_CURRENT_USER);
	    	role =  (String) request.getSession().getAttribute(ROLE_OF_CURRENT_USER);
	    	profileId =  (Long) request.getSession().getAttribute(PROFILE_ID_OF_USER);
	    }
	    
	    if(name !=null && !name.isEmpty())
	    {
	    	authenticationStateBean.setAuthenticated(true);
	    	authenticationStateBean.setName(name);
	    	authenticationStateBean.setRole(role); 
	    	authenticationStateBean.setProfileId(profileId);
	    }
	    else
	    {
	    	authenticationStateBean.setAuthenticated(false);	
	    	authenticationStateBean.setName(null);
	    	authenticationStateBean.setRole(null);
	    	authenticationStateBean.setProfileId(null);
	    }
	    request.setAttribute("authenticationStateBean", authenticationStateBean);
	}
}
