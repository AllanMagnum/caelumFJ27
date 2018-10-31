package br.com.alura.forum.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.alura.forum.security.service.UsersService;

public class JwtAuthenticationFilter extends OncePerRequestFilter{

	private TokenManager tokenManager;

	private UsersService userService;
	
	public JwtAuthenticationFilter(TokenManager tokenManager, UsersService userService) {
		this.tokenManager = tokenManager;
		this.userService = userService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String jwt = getTokenFromRequest(request);
		
		if(tokenManager.isValid(jwt)){
			Long userId = tokenManager.getUserIdFromToken(jwt);
			
			UserDetails userDetails = userService.loadUserById(userId);
			
			UsernamePasswordAuthenticationToken authetication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
			
			SecurityContextHolder.getContext().setAuthentication(authetication);
		}
		
		filterChain.doFilter(request, response);
	}
	
	private String getTokenFromRequest(HttpServletRequest request){
		String bearerToken = request.getHeader("Authorization");
		
		if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")){
			return bearerToken.substring(7, bearerToken.length());
		}
		
		return null;
	}

}
