package com.jpa.test.service;

import java.time.Instant;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.test.entity.RefreshToken;
import com.jpa.test.entity.UserModel;
import com.jpa.test.repo.RefreshTokenRopo;
import com.jpa.test.repo.UserRepo;

@Service
public class RefreshTokenService {
  
	public long refreshValidity = 5*60*60*10000;
//	public long refreshValidity = 1*60*1000;
	@Autowired
	public UserRepo userrepo ;
	
	@Autowired
	private RefreshTokenRopo refreshTokenRopo;
	
	public RefreshToken createRefreshToken(String userName) {
		
		UserModel userModel = userrepo.findByUsername(userName);
		RefreshToken refreshToken = userModel.getRefreshToken();
		
		if(refreshToken == null) {
		 refreshToken = RefreshToken.builder()
		       .refreshToken(UUID.randomUUID().toString())
		       .expiry(Instant.now().plusMillis(refreshValidity))
		       .user(userrepo.findByUsername(userName))
		       .build()
		       ;
		       
		}else {
			refreshToken.setExpiry(Instant.now().plusMillis(refreshValidity));
		}
		userModel.setRefreshToken(refreshToken);
		refreshTokenRopo.save(refreshToken);
		return refreshToken;
	}
	
	public RefreshToken verifyRefreshToken(String refreshToken) {
		RefreshToken refreshTokenOBJ =  refreshTokenRopo.findByRefreshToken(refreshToken)
				.orElseThrow(() ->
		               new RuntimeException("Given Token is does not exixt in data"));
		System.out.println("From RefreshToken Service :-------:"+refreshToken);
		if(refreshTokenOBJ.getExpiry().compareTo(Instant.now())<0) {
			refreshTokenRopo.delete(refreshTokenOBJ);
			throw new RuntimeException("Refresh Token Is Expired");
		}
		return refreshTokenOBJ;
	}
}
