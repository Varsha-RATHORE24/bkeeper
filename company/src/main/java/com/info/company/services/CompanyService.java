package com.info.company.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import com.info.company.entities.Company;
import com.info.company.entities.CompanyLoginDto;
import com.info.company.feign.CompanyFeign;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface CompanyService {
	  @Autowired
	//CompanyFeign companyFeign;
	
	   Company saveCompany(Company company);
   
	   List<Company> fetchCompanyList();
	Company UpadateCompany(Company company, Long id);
	
	void deleteCompanyById(long id);


}
