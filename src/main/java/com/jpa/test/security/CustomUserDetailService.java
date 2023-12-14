package com.jpa.test.security;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jpa.test.entity.UserModel;
import com.jpa.test.service.Userservice;

@Service
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private Userservice userservice;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserModel user = userservice.findByUserName(username);
		System.out.println("At CustomUserDetail "+user);
		  if (user == null) {
	            throw new UsernameNotFoundException("User not found with username: " + username);
	        }
	        return user;
	    }
	}

