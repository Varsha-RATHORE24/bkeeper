package com.info.company.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

@Component
public class JWTUtil {
	@Value("${jwt.signing.key}")
	public String SIGNING_KEY;

	@Value("${jwt.authorities.key}")
	public String AUTHORITIES_KEY;

	
	  public DecodedJWT decodeToken(String token) {
	        try {
	            return JWT.decode(token);
	        } catch (JWTDecodeException e){
	            // Invalid token format
	            e.printStackTrace();
	            return null;
	        }
	    }
	  
	  public String getClaimFromToken(String token) {
	        DecodedJWT decodedJWT = decodeToken(token);
	        if (decodedJWT != null) {
	        	decodedJWT.getClaims();
	            return decodedJWT.getClaim(AUTHORITIES_KEY).asString();
	        }
	        return null;
	    }

}
