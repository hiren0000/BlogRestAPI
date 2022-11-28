package com.rebel.blogJwt.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import com.rebel.blogJwt.model.Comment;
import com.rebel.blogJwt.model.Post;
import com.rebel.blogJwt.payloads.CommentDto;
import com.rebel.blogJwt.repositoy.CommentRepo;
import com.rebel.blogJwt.repositoy.PostRepo;
import com.rebel.blogJwt.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService
{
	
	@Autowired
	private CommentRepo comRepo;
	
	@Autowired 
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	//Adding comment
	@Override
	public CommentDto addComment(CommentDto cDto, Integer pId) {
		
		Post post = this.postRepo.findById(pId).orElseThrow(()-> new ResourceAccessException("Post not found with pId"+" "+pId));
		
		Comment comment = this.mapper.map(cDto, Comment.class);
		comment.setPost(post);
		
		Comment addedComment = this.comRepo.save(comment);
		
		return this.mapper.map(addedComment, CommentDto.class);
	}

	
	//Deleting comment 
	@Override
	public void deleteComment(Integer coId) {
		
		Comment comment = this.comRepo.findById(coId)
							.orElseThrow(() -> new ResourceAccessException("Comment Not found with id:"+" "+coId));
		
		this.comRepo.delete(comment);
		
	}
 

}
