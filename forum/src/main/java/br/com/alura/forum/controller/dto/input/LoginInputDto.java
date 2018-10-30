package br.com.alura.forum.controller.dto.input;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import lombok.Getter;
import lombok.Setter;

public class LoginInputDto {
	@Getter
	@Setter
	private String email;
	@Setter
	private String password;
	
	public UsernamePasswordAuthenticationToken build(){
		return new UsernamePasswordAuthenticationToken(this.email, this.email);
	}
}
