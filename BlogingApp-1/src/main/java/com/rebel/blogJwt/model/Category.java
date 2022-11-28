package com.rebel.blogJwt.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="blog_category")
public class Category 
{	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cId;
	private String cTitle;
	private String cDescrp;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Post> post = new ArrayList<>();
	
	public Category()
	{
		
	}

	public Category(String cTitle, String cDescrp) {
		super();
		this.cTitle = cTitle;
		this.cDescrp = cDescrp;
	}

	public Integer getcId() {
		return cId;
	}

	public void setcId(Integer cId) {
		this.cId = cId;
	}

	public String getcTitle() {
		return cTitle;
	}

	public void setcTitle(String cTitle) {
		this.cTitle = cTitle;
	}

	public String getcDescrp() {
		return cDescrp;
	}

	public void setcDescrp(String cDescrp) {
		this.cDescrp = cDescrp;
	}

	public List<Post> getPost() {
		return post;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}
	
	

	
}
