package com.scb.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdminCredentails {
	 
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long u_id;
	private String name;
	private String username;
	private String password;
	private String role;
	private String mobno;
	private Date lastlogin;
	
	public long getU_id() {
		return u_id;
	}
	public void setU_id(long u_id) {
		this.u_id = u_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobileNo) {
		this.mobno = mobileNo;
	}
	public Date getLastlogin() {
		return lastlogin;
	}
	public void setLastlogin(Date lastLogin) {
		this.lastlogin = lastLogin;
	}
	


	
	

}
