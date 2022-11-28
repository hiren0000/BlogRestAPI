package com.rebel.blogJwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rebel.blogJwt.payloads.ApiResponse;
import com.rebel.blogJwt.payloads.CommentDto;
import com.rebel.blogJwt.services.CommentService;

@RestController
@RequestMapping("/api/")
public class CommentController 
{
	
	@Autowired
	private CommentService commentService;
	
	
	//Adding Comment
	
	@PostMapping("/post/{pId}/comments")
	public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto comDto, @PathVariable Integer pId)
	{
		CommentDto comment = this.commentService.addComment(comDto, pId);
		
		return new ResponseEntity<CommentDto>(comment, HttpStatus.CREATED);
		
	}
	
	//Deleting Comment
	
	@DeleteMapping("/comments/{coId}")
	public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer coId)
	{
		 this.commentService.deleteComment(coId);
		 
		 return new ResponseEntity<>(new ApiResponse("Comment successfully deleted with cId:"+" "+coId, true), HttpStatus.OK);
	}

}
