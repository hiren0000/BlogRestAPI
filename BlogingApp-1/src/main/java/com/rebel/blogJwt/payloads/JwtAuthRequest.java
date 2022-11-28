package com.rebel.blogJwt.payloads;


public class JwtAuthRequest 
{
	private String uEmail;
	
	private String uPass;

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
	
	

}
