package com.rebel.blogJwt.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



@Entity
@Table(name= "blog_user")
public class User implements UserDetails 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer uId;
	private String uName;
	private String uEmail;
	private String uPass;
	private String uAbout;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Post> post = new ArrayList<>();
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Role> roles = new HashSet<>();
	
	public User()
	{
		
	}
	
	public User( String uName, String uEmail, String uPass, String uAbout) {
		super();
		
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

	public List<Post> getPost() {
		return post;
	}

	public void setPosts(List<Post> post) {
		this.post = post;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void setPost(List<Post> post) {
		this.post = post;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		List<SimpleGrantedAuthority> roleGrant = this.roles.stream().map((role) -> new SimpleGrantedAuthority(role.getrName())).collect(Collectors.toList());
		
		return roleGrant;
	}

	@Override
	public String getPassword() {
		
		return this.uPass;
	}

	@Override
	public String getUsername() {
		
		return this.uEmail;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
			return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		
		return true;
	}

	@Override
	public boolean isEnabled() {
		
		return true;
	}

	
	
	

}
