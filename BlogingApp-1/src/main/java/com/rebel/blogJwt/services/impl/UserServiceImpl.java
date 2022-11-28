package com.rebel.blogJwt.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.rebel.blogJwt.model.User;

import com.rebel.blogJwt.payloads.UserDto;
import com.rebel.blogJwt.repositoy.UserRepo;
import com.rebel.blogJwt.services.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	//Creating user
	@Override
	public UserDto createUser(UserDto userDto) 
	{
		
		User user = this.mapper.map(userDto, User.class);
		
		User createdUser = this.userRepo.save(user);
		
		return this.mapper.map(createdUser, UserDto.class);
	}
	
	
	//get all users
	@Override
	public List<UserDto> getAllUser()
	{
		List<User> users = this.userRepo.findAll();
		List<UserDto> dto =	users.stream().map(user -> this.mapper.map(user, UserDto.class)).collect(Collectors.toList());
		
		return dto;
	}

	
	//get single User
	@Override
	public UserDto getSingleUser(Integer uId) 
	{	
		User user = this.userRepo.findById(uId).orElseThrow(() -> new ResourceAccessException("User not found with this id:"+ uId));
		
		return this.mapper.map(user, UserDto.class);
	}

	
	//Updating user
	@Override
	public UserDto updateUser(UserDto userDto, Integer uId) {
		
		User user = this.userRepo.findById(uId).orElseThrow(() -> new ResourceAccessException("User not found with this id:"+ uId));
		
		   user.setuName(userDto.getuName());
		   user.setuEmail(userDto.getuEmail());
		   user.setuPass(userDto.getuPass());
		   user.setuAbout(userDto.getuAbout());
		   
		   User updatedUser = this.userRepo.save(user);
		
		return this.mapper.map(updatedUser, UserDto.class);
	}

	
	//Deleting users
	@Override
	public void deleteUser(Integer uId) 
	{
		User user = this.userRepo.findById(uId).orElseThrow(() -> new ResourceAccessException("User is successfully deleted:"));
		
		this.userRepo.delete(user);
	}
	
	

}
