package com.rebel.blogJwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rebel.blogJwt.payloads.ApiResponse;
import com.rebel.blogJwt.payloads.PostDto;
import com.rebel.blogJwt.services.PostService;

@RestController
@RequestMapping("/api/")
public class PostController
{
	 @Autowired
     private PostService postService;
	
	//create Post
	@PostMapping("/user/{uId}/category/{cId}/post")
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Integer uId, @PathVariable Integer cId)
	{
		PostDto post = this.postService.createPost(postDto, uId, cId);
		
		return new ResponseEntity<PostDto>(post, HttpStatus.CREATED);
	}
	
	//get single post
	@GetMapping("/post/{pId}")
	public ResponseEntity<PostDto> getSinglePost(@PathVariable Integer pId)
	{
		PostDto post = this.postService.getSinglePost(pId);
		
		return new ResponseEntity<PostDto>(post, HttpStatus.OK);
	}
	
	
	//get all posts
	@GetMapping("/posts")
	public ResponseEntity<List<PostDto>> getAllPosts()
	{
		List<PostDto> list = this.postService.getAllPost();
		
		return new ResponseEntity<List<PostDto>>(list, HttpStatus.OK);
	
	}
	
	
	//update post
	@PutMapping("post/{pId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto, @PathVariable Integer pId)
	{
		PostDto post = this.postService.updatePost(postDto, pId);
		
		return new ResponseEntity<PostDto>(post, HttpStatus.OK);
	}
	
	
	//delete post
	@DeleteMapping("/post/{pId}")
	public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer pId)
	{
		 this.postService.deletePost(pId);
		 
		 return new ResponseEntity<>
		 			(new ApiResponse("Post has been successfully deleeted"+" "+pId, true), HttpStatus.OK);
	}
	
	//getting posts by user id
	@GetMapping("/user/{uId}/posts")
	public ResponseEntity<List<PostDto>> getAllPostsByUser(@PathVariable Integer uId)
	{
		List<PostDto> list = this.postService.getPostsByUser(uId);
		
		return new ResponseEntity<List<PostDto>>(list, HttpStatus.OK);
	
	}
	
	
	//getting posts by category id
		@GetMapping("/category/{cId}/posts")
		public ResponseEntity<List<PostDto>> getAllPostsByCategory(@PathVariable Integer cId)
		{
			List<PostDto> list = this.postService.getPostsByCategory(cId);
			
			return new ResponseEntity<List<PostDto>>(list, HttpStatus.OK);
		
		}
	
	

}
