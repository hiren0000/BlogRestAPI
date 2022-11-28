package com.rebel.blogJwt.payloads;



public class UserDto 
{

	private Integer uId;
	private String uName;
	private String uEmail;
	private String uPass;
	private String uAbout;
	
	public UserDto()
	{
		
	}
	
	
	public UserDto(Integer uId, String uName, String uEmail, String uPass, String uAbout) 
	{
		super();
		this.uId = uId;
		this.uName = uName;
		this.uEmail = uEmail;
		this.uPass = uPass;
		this.uAbout = uAbout;
	}


	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getuPass() {
		return uPass;
	}
	public void setuPass(String uPass) {
		this.uPass = uPass;
	}
	public String getuAbout() {
		return uAbout;
	}
	public void setuAbout(String uAbout) {
		this.uAbout = uAbout;
	}
	

}
