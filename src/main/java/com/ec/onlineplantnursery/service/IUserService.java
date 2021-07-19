package com.ec.onlineplantnursery.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ec.onlineplantnursery.entity.User;
import com.ec.onlineplantnursery.exceptions.InvalidCredentialException;


public interface IUserService {

	public String signIn(User user) throws InvalidCredentialException;
	public User signOut(User user);
	User loadUserByEmail(String email) throws UsernameNotFoundException;

	

}