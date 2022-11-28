package com.rebel.blogJwt.payloads;

import java.util.ArrayList;
import java.util.List;

import com.rebel.blogJwt.model.Comment;

public class PostDto 
{

	
	private Integer pId;
	private String pTitle;
	private String pContent;
	private String pImage;
	private UserDto user;
	private CategoryDto category;
	
	private List<Comment> comments = new ArrayList<>();
	
	
	
	public PostDto()
	{
		
	}

	public PostDto (String pTitle, String pContent, String pImage) {
		super();
		
		this.pTitle = pTitle;
		this.pContent = pContent;
		this.pImage = pImage;
	}

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getpTitle() {
		return pTitle;
	}

	public void setpTitle(String pTitle) {
		this.pTitle = pTitle;
	}

	public String getpContent() {
		return pContent;
	}

	public void setpContent(String pContent) {
		this.pContent = pContent;
	}

	public String getpImage() {
		return pImage;
	}

	public void setpImage(String pImage) {
		this.pImage = pImage;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
	
	

}
