package com.tns.jwttoken.entities;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User implements UserDetails{
	@Id
    private String userId;
    private String email;
    private String password;
    private String confirmPassword;
    private long phone;
 
public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public User() {
	super();
}




public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}

public User(String userId, String email, String password, String confirmPassword, long phone) {
	super();
	this.userId = userId;
	this.email = email;
	this.password = password;
	this.confirmPassword = confirmPassword;
	this.phone = phone;
}

@Override
public String toString() {
	return "User [userId=" + userId + ", email=" + email + ", password=" + password + ", confirmPassword="
			+ confirmPassword + ", phone=" + phone + "]";
}

public String getConfirmPassword() {
	return confirmPassword;
}

public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
}

public long getPhone() {
	return phone;
}

public void setPhone(long phone) {
	this.phone = phone;
}

public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}

@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	Set<Authority> set=new HashSet<>();  //login
	return null;
}

@Override
public String getUsername() {
	return this.email;
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
