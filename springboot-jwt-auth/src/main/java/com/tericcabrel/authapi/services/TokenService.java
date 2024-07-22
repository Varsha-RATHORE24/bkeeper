package com.tericcabrel.authapi.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tericcabrel.authapi.entities.TokenDetail;
import com.tericcabrel.authapi.entities.User;
import com.tericcabrel.authapi.repositories.TokenRepository;

@Service
public class TokenService {
	private TokenRepository tokenRepository;
 
	

public TokenService(TokenRepository tokenRepository) {
		super();
		this.tokenRepository = tokenRepository;
	}
public TokenDetail savetoken(String email, String token, Date createdAt,Date expirationDateFromToken, User user) {

TokenDetail tkn = new TokenDetail();
//Optional<TokenDetail> optionalToken = tokenRepository.findByEmail("email");
Optional<TokenDetail> optionalToken = tokenRepository.findByEmail(email);

if(!optionalToken.isEmpty()) 
{
    	tkn.setId(optionalToken.get().getId());
    	
}
tkn.setEmail(email);
tkn.setToken(token);
tkn.setCreatedAt(createdAt);
tkn.setExpirationDateFromToken(expirationDateFromToken);
tkn.setUser(user);

  return tokenRepository.save(tkn);
}



}
