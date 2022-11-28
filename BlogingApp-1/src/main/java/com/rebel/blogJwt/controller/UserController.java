package com.rebel.blogJwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rebel.blogJwt.payloads.ApiResponse;
import com.rebel.blogJwt.payloads.UserDto;
import com.rebel.blogJwt.services.UserService;

@RestController
@RequestMapping("/api/user/")
public class UserController 
{
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
	{
		UserDto addedUser =this.userService.createUser(userDto);
		
		return new ResponseEntity<UserDto>(addedUser, HttpStatus.CREATED);
	}
	
	//get All user
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAllUser()
	{
		List<UserDto> users = this.userService.getAllUser();
		
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	//get a single user
	@GetMapping("/{uId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer uId)
	{
		UserDto user = this.userService.getSingleUser(uId);
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	//update user
	@PutMapping("/{uId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto, @PathVariable Integer uId)
	{
		UserDto updatedUser = this.userService.updateUser(userDto, uId);
		
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}
	
	//deleting user
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{uId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer uId)
	{
		this.userService.deleteUser(uId);
		
		return new ResponseEntity<>( new ApiResponse("User deleted successfully with Id"+uId, true), HttpStatus.OK);
	}
}
