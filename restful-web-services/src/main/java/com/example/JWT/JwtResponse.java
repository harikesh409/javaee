package com.example.JWT;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = 7728286900750604655L;

	private final String jwttoken;

	public JwtResponse(String jwttoken) {
		super();
		this.jwttoken = jwttoken;
	}

	public String getJwttoken() {
		return jwttoken;
	}
}
