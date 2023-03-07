package com.camp.havenfort_dev.requests;

public class LoginResponse {
	
	private final String jwt ;

	public String getJwt() {
		return jwt;
	}

	public LoginResponse(String jwt) {
		super();
		this.jwt = jwt;
	}

	

}
