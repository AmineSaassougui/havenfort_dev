package com.camp.havenfort_dev.entity;

import javax.persistence.*;

@Entity
@Table(name = "verification_token")
public class VerificationToken {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id ;
	private String token ;
	@OneToOne(fetch = FetchType.LAZY)
	private User user ;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public VerificationToken() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VerificationToken(Long id, String token, User user) {
		super();
		this.id = id;
		this.token = token;
		this.user = user;
	}
	@Override
	public String toString() {
		return "VerificationToken [id=" + id + ", token=" + token + ", user=" + user + "]";
	}
	
}
