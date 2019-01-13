package com.codetutr.vehicleTrackingSystem.Utility;

import java.util.List;

import org.springframework.web.context.annotation.SessionScope;

@SessionScope
public class AuthenticationStateBean 
{
	private boolean authenticated;
	private String name;
	private String role;
	private Long profileId;
	
	public boolean isAuthenticated() {
		return authenticated;
	}
	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Long getProfileId() {
		return profileId;
	}
	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}
}