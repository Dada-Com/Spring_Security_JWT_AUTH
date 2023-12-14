package com.jpa.test.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpa.test.entity.RefreshToken;

@Repository
public interface RefreshTokenRopo extends JpaRepository<RefreshToken, String> {

	// custom method
	Optional<RefreshToken> findByRefreshToken(String refreshToken); 
}
