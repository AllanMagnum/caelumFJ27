package br.com.alura.forum.controller.dto.output;

import lombok.Getter;

@Getter
public class AuthenticationTokenOutputDto {
	private String tokenType;
	private String token;
	
	public AuthenticationTokenOutputDto(String tokenType, String token){
		super();
		this.token = token;
		this.tokenType = tokenType;
	}
}
