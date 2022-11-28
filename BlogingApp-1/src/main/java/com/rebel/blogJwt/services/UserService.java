package com.rebel.blogJwt.services;

import java.util.List;

import com.rebel.blogJwt.payloads.UserDto;


public interface UserService
{
	//creating user
	UserDto createUser(UserDto userDto);
	
	//get all user
	List<UserDto> getAllUser();
	
	//get single user by id
	UserDto getSingleUser(Integer uId);
	
	//update user
	UserDto updateUser(UserDto userDto, Integer uId);
	
	
	//delete user by id
	void deleteUser(Integer uId);
	
	

}
