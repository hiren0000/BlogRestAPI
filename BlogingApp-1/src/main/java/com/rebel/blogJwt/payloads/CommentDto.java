package com.rebel.blogJwt.payloads;


public class CommentDto
{

	private Integer coId;
	
	private String coContent;
	
	
	
	public CommentDto()
	{
		
	}

	public Integer getCoId() {
		return coId;
	}

	public void setCoId(Integer coId) {
		this.coId = coId;
	}

	public String getCoContent() {
		return coContent;
	}

	public void setCoContent(String coContent) {
		this.coContent = coContent;
	}

	
}
