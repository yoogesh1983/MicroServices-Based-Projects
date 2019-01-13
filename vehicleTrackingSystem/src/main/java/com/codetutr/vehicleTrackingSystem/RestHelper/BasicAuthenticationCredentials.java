package com.codetutr.vehicleTrackingSystem.RestHelper;

import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.binary.Base64;

public class BasicAuthenticationCredentials 
{

	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		if(username == null){this.username = "";}
		else{this.username = username;}
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		if(password ==null){this.password = password;}
		else{this.password = password;}
	}
	
	
	public String toAuthorizationHeaderValue()
	{
		String credentials = username + ":" + password;
		String encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes(StandardCharsets.US_ASCII)), StandardCharsets.US_ASCII);
		String authorizationHeaderValue = "Basic" + encodedCredentials;
		return authorizationHeaderValue;
	}
	

}
