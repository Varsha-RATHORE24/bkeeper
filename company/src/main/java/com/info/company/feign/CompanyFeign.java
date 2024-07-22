package com.info.company.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.info.company.response.BaseResponse;
import com.info.company.response.ValidationResponse;


@FeignClient(name= "AUTH-API", url ="localhost:8080/auth")
public interface CompanyFeign { 
	

    @PostMapping("/validate")
  //  @Headers(“Content-Type : application/json”)
    public ValidationResponse validate(@RequestHeader("Authorization") String bearerToken);
    
	
}
