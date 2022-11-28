package com.rebel.blogJwt.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.rebel.blogJwt.model.Category;
import com.rebel.blogJwt.model.Post;
import com.rebel.blogJwt.model.User;
import com.rebel.blogJwt.payloads.PostDto;
import com.rebel.blogJwt.repositoy.CategoryRepo;
import com.rebel.blogJwt.repositoy.PostRepo;
import com.rebel.blogJwt.repositoy.UserRepo;
import com.rebel.blogJwt.services.PostService;

@Service
public class PostServiceImpl implements PostService 
{
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;

	
	//Add post
	
	@Override
	public PostDto createPost(PostDto postDto, Integer uId, Integer cId) {
		
		User user = this.userRepo.findById(uId)
						.orElseThrow(() -> new ResourceAccessException("User not found with userId"+" "+uId));
		
		Category category = this.categoryRepo.findById(cId)
							.orElseThrow(() -> new ResourceAccessException("Category not found with cId"+" "+cId));
		
		
		Post post = this.mapper.map(postDto, Post.class);
		post.setUser(user);
		post.setCategory(category);
		
		Post createdPost = this.postRepo.save(post);
		
		return this.mapper.map(createdPost, PostDto.class);
	}

	
	// get All posts
	
	@Override
	public List<PostDto> getAllPost() {
		
		List<Post> posts = this.postRepo.findAll();
		
		List<PostDto> postDto = posts.stream().map(post -> this.mapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		
		return postDto;
	}

	
	//get Single post
	
	@Override
	public PostDto getSinglePost(Integer pId) {
		
		Post post = this.postRepo.findById(pId).orElseThrow(() -> new ResourceAccessException("Post not found"));
		
		return this.mapper.map(post, PostDto.class);
	}

	//update posts
	
	@Override
	public PostDto updatePost(PostDto postDto, Integer pId) {
		
		
		Post post = this.postRepo.findById(pId).orElseThrow(() -> new ResourceAccessException("Post not found"));
		post.setpTitle(postDto.getpTitle());
		post.setpContent(postDto.getpContent());
		post.setpImage(postDto.getpImage());
		
		
		Post updatedPost = this.postRepo.save(post);
		
		return this.mapper.map(updatedPost, PostDto.class);
	}

	
	//delete post
	
	@Override
	public void deletePost(Integer pId) {
		Post post = this.postRepo.findById(pId).orElseThrow(() -> new ResourceAccessException("Post not found"));
		
		this.postRepo.delete(post);
	}

	
	//getting posts by category
	
	@Override
	public List<PostDto> getPostsByCategory(Integer cId) {
		
		Category category = this.categoryRepo.findById(cId)
				.orElseThrow(() -> new ResourceAccessException("Category not found with cId"+" "+cId));
		
		List<Post> posts = this.postRepo.getPostByCategory(category);
		
		List<PostDto> dto = posts.stream().map(post -> this.mapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		return dto;
	}

	
	//getting posts by user
	
	@Override
	public List<PostDto> getPostsByUser(Integer uId) {
		
		User user = this.userRepo.findById(uId)
				.orElseThrow(() -> new ResourceAccessException("User not found with userId"+" "+uId));
		
		List<Post> posts = this.postRepo.getPostByUser(user);
		
		List<PostDto> dto = posts.stream().map(post -> this.mapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		return dto;
	}
	
	
	
	

}
