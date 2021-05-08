/**
 * 
 */
package com.littleBigBusters.backend.modelVO;

import java.util.Set;

import lombok.Getter;

@Getter
public class TokenAuthentication {
	
	public TokenAuthentication(String jwt, String dni, Set<?> roles) {
		super();
		this.jwt = jwt;
		this.dni = dni;
		this.roles = roles;
	}
	private final String jwt;
	private final String dni; 
	private final Set<?> roles;	
}
