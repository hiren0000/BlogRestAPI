package com.rebel.blogJwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rebel.blogJwt.payloads.JwtAuthRequest;
import com.rebel.blogJwt.payloads.JwtAuthResponse;

import com.rebel.blogJwt.security.CustomeUserDetailsService;
import com.rebel.blogJwt.security.JwtTokenHelper;

@RestController
@RequestMapping("/api/auth/")
public class LoginController 
{
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private JwtTokenHelper helper;
	
	@Autowired
	private CustomeUserDetailsService userDetail;
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> getToken(@RequestBody JwtAuthRequest request)
	{
		this.authenticate(request.getuEmail(), request.getuPass());
		
		UserDetails user = this.userDetail.loadUserByUsername(request.getuEmail());
		
		String generatedToken = this.helper.generateToken(user);
		System.out.println(generatedToken);
		
		JwtAuthResponse response = new JwtAuthResponse();
		response.setToken(generatedToken);
		
		return new ResponseEntity<JwtAuthResponse>(response, HttpStatus.OK);		
		
	}
	
	private void authenticate(String uEmail, String uPass)
	{
		UsernamePasswordAuthenticationToken tk = new UsernamePasswordAuthenticationToken(uEmail, uPass);
		
		try {
		
		this.manager.authenticate(tk);
		}catch(Exception e)
		{
			System.out.println("prb in lg con"+" "+ e);
		}
		}
	}


