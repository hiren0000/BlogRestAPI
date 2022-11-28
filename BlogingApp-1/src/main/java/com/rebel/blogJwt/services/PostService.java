package com.rebel.blogJwt.services;

import java.util.List;

import com.rebel.blogJwt.payloads.PostDto;

public interface PostService 
{
   PostDto createPost(PostDto postDto, Integer uId, Integer cId);
   
   List<PostDto> getAllPost();
   
   PostDto getSinglePost(Integer pId);
   
   PostDto updatePost(PostDto postDto, Integer pId);
   
   void deletePost(Integer pId);
   
   List<PostDto> getPostsByCategory(Integer cId);
   
   List<PostDto> getPostsByUser(Integer uId);
	
	
}
