package com.rebel.blogJwt.services;

import com.rebel.blogJwt.payloads.CommentDto;

public interface CommentService  
{
	//add comment
	CommentDto addComment(CommentDto cDto, Integer pId);
	
	
	//delete comment
	void deleteComment(Integer coId);

}
