package com.info.company.exception;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.info.company.response.BaseResponse;

public class GlobalExceptionHandler
{
	@ExceptionHandler(value = CompanyException.class) 
     public BaseResponse handleException(CompanyException ex) {
        BaseResponse response = new BaseResponse();
        response.setStatus("ERROR");
        response.setCode(500);
        response.setMessage("company not exsist");
        return response;
    
    }
    
	@ExceptionHandler({RuntimeException.class})
    public BaseResponse handleRuntimeException(RuntimeException exception) {
        BaseResponse response = new BaseResponse();
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());
        response.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        response.setMessage(exception.getMessage());
        response.setData(null);
        return response;
    }
}
