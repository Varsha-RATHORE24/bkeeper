package com.tericcabrel.authapi.controllers;
import java.lang.StackWalker.Option;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tericcabrel.authapi.dtos.LoginUserDto;
import com.tericcabrel.authapi.dtos.RegisterUserDto;
import com.tericcabrel.authapi.entities.TokenDetail;
import com.tericcabrel.authapi.entities.User;
import com.tericcabrel.authapi.repositories.TokenRepository;
import com.tericcabrel.authapi.responses.BaseResponse;
import com.tericcabrel.authapi.responses.LoginResponse;
import com.tericcabrel.authapi.responses.ValidationResponse;
import com.tericcabrel.authapi.services.AuthenticationService;
import com.tericcabrel.authapi.services.JwtService;
import com.tericcabrel.authapi.services.TokenService;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RequestMapping("/auth")
@RestController
public class AuthenticationController {
	  private final JwtService jwtService;
	    private final AuthenticationService authenticationService;
	    private final TokenService tokenService;
	    private final TokenRepository tokenRepository; 
	    TokenDetail tok = new TokenDetail();


	    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService,
	            TokenService tokenService, TokenRepository tokenRepository) { // Add this to the constructor
	        super();
	        this.jwtService = jwtService;
	        this.authenticationService = authenticationService;
	        this.tokenService = tokenService;
	        this.tokenRepository = tokenRepository;
	     
	        // Initialize the tokenRepository field
	    }

    @PostMapping("/signup")
    public ResponseEntity<BaseResponse> register(@RequestBody RegisterUserDto registerUserDto) {
    	LoginResponse  loginResponse = new LoginResponse();
        
        try {  
            User registeredUser = authenticationService.signup(registerUserDto);

       	 	loginResponse.setMessage("Login succussfully");
            loginResponse.setStatus("success");
            loginResponse.setCode(200);
            loginResponse.setData(registeredUser);
          
           // loginResponse.setExpiresIn(jwtService.getExpirationTime());
         }catch (Exception e) {
       	    loginResponse.setMessage("Login failed");
               loginResponse.setStatus("error");
       	  loginResponse.setCode(500);
        
            // loginResponse.setExpiresIn(jwtService.getExpirationTime());
         }
        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<BaseResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

    //    LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime());
     LoginResponse  loginResponse = new LoginResponse();
    ;
     try {  
    	 loginResponse.setMessage("Login succussfully");
         loginResponse.setStatus("success");
         loginResponse.setCode(200);
         Map<String, Object> data = new HashMap<>();
         data.put("token", jwtToken);
         data.put("expiresIn", jwtService. getExpirationDateFromToken(jwtToken));

         loginResponse.setData(data);//        tokenResponse.setToken(jwtToken);
//        tokenResponse.setExpiresIn(jwtService.getExpirationTime());
        TokenDetail tok = tokenService.savetoken(authenticatedUser.getEmail(),jwtToken,authenticatedUser.getCreatedAt(),jwtService.getExpirationDateFromToken(jwtToken),authenticatedUser);
      }catch (Exception e) {
    	  loginResponse.setMessage("Login failed");
          loginResponse.setStatus("error");
    	  loginResponse.setCode(500);
    	  loginResponse.setData(null);
    	  
    	  //  loginResponse.setToken(jwtToken);
          //loginResponse.setExpiresIn(jwtService.getExpirationTime());
      }
        return ResponseEntity.ok(loginResponse);
        
    }
   
    @PostMapping("/validate")
    public ResponseEntity<BaseResponse> validate(HttpServletRequest request) throws Exception {
    	System.out.println("in auth api");
    	System.out.println(request.getHeader("Authorization"));
    	
    	String tokenreq = request.getHeader("Authorization");
		ValidationResponse response = new ValidationResponse();

    
    	
        if (tokenreq.startsWith("Bearer ")) {
            tokenreq = tokenreq.substring(7);
        }
        else {System.out.println(" string does not have Bearer");}
    	String username = jwtService.getUsernameFromToken(tokenreq);
    	
    	System.out.println(username);
        System.out.println(tokenreq);
       System.out.println(jwtService.getAllClaimsFromToken(tokenreq));
      // System.out.println(jwtService.extractRoles(tokenreq));
		Optional<TokenDetail> user = tokenRepository.findByEmail(username);
      
		
		
		String tokendb =user.get().getToken();
      System.out.println(tokendb);
		if (tokenreq.equals(tokendb)) {
	        // Token is valid, return true  User registeredUser = authenticationService.signup(registerUserDto);
			response.setMessage("validate succussfully");
			response.setStatus("success");
			response.setCode(200);
			response.setValid(true);
	    } else {
	        // Token does not match, return false
	    	response.setMessage("not validated");
	    	response.setStatus("failure");
	    	response.setCode(500);
	    	response.setValid(false);
	    }
        return ResponseEntity.ok(response);

}
//    private List<String> extractRoles(String token) {
//        Claims claims = jwtService.extractAllClaims(token);
//        System.out.println(claims);
//        return claims.get("role", List.class);
//    }    
}