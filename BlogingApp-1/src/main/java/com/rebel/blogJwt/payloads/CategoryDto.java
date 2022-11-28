package com.rebel.blogJwt.payloads;

public class CategoryDto 
{
	private Integer cId;
	private String cTitle;
	private String cDescrp;
	
	public CategoryDto()
	{
		
	}

	public CategoryDto(String cTitle, String cDescrp) {
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


}
