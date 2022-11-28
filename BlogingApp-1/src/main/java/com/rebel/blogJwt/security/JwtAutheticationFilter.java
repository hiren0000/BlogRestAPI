package com.rebel.blogJwt.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


@Component
public class JwtAutheticationFilter extends OncePerRequestFilter 
{
	@Autowired
	private UserDetailsService service;
	
	@Autowired
	private JwtTokenHelper token;
	
	
		
	
		@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException 
	{
	
	//1St Step
	//getting token
		
		String requestHeader = request.getHeader("Authorization");
		
	//bearer
		System.out.println(requestHeader);
		
		String userName = null;
		String token = null;
		
		if(requestHeader != null && requestHeader.startsWith("Bearer"))
		{
			token = requestHeader.substring(7);
			
			try {
			
				userName = this.token.extractUsername(token);
				
			}
			catch(Exception e)
			{
				System.out.println("some prb"+ e);
				
			}
			
			
			
		}else
		{
			System.out.println("Jwt token does not start with Bearer");
		}
		
	//2 nd Step ** After getting the token, Now it's validation time
		
		if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null)
		{
			UserDetails userDetails = this.service.loadUserByUsername(userName);
			
			if(this.token.validateToken(token, userDetails))
			{
				//Authentication
				
				UsernamePasswordAuthenticationToken uPassAuth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
				uPassAuth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));			
						
				SecurityContextHolder.getContext().setAuthentication(uPassAuth);				
				
			}
			else
			{
				System.out.println("Invalid JWt token");
			}
			
		}
		else
		{
			System.out.println("UserName is not valid or context does not null ");
		}
		
		filterChain.doFilter(request, response);
	}
	
	

}
