package com.info.company.services;

import java.util.List;

import com.info.company.entities.Company;

public interface CompanyService {
	   
		
	   Company saveCompany(Company company);
	   
	   List<Company> fetchCompanyList();
	   

	Company UpadateCompany(Company company, Long id);
	
	void deleteCompanyById(long id);


}
