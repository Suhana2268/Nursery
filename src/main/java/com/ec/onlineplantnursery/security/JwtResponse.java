package com.ec.onlineplantnursery.security;

public class JwtResponse {

	String token;
	int userId;
	String userType;

	public JwtResponse() {
		super();
		
	}

	public JwtResponse(String token, int userId, String userType) {
		super();
		this.token = token;
		this.userId = userId;
		this.userType = userType;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	
	
	
}
