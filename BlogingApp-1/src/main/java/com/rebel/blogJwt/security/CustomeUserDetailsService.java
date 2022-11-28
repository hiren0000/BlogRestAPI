package com.rebel.blogJwt.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.rebel.blogJwt.model.User;
import com.rebel.blogJwt.repositoy.UserRepo;

@Service
public class CustomeUserDetailsService implements UserDetailsService
{
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = this.userRepo.findByuEmail(username).orElseThrow(()-> new ResourceAccessException("User not found with this username"));
		
		return user;
	}
	

}
