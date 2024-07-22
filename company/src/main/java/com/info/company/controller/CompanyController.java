package com.info.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.info.company.entities.Company;
import com.info.company.entities.CompanyLoginDto;
import com.info.company.feign.CompanyFeign;
import com.info.company.reposiroties.CompanyRepository;
import com.info.company.services.CompanyService;
@RestController
@RequestMapping("/company")
public class CompanyController {
	@Autowired
	CompanyFeign companyFeign;
	
	
	public CompanyController(CompanyFeign companyFeign, CompanyService companyservice) {
		super();
		this.companyFeign = companyFeign;
		this.companyservice = companyservice;
	}

	@Autowired
	private CompanyService companyservice;
	
	//to save company detail
	@PostMapping("/")
	public Company saveCompany(@RequestBody Company company) {
		//companyFeign.validate(null);
		//CompanyLoginDto companyLoginDto = new CompanyLoginDto(); // Initialize with valid data
//        boolean isValid = companyFeign.validate(companyLoginDto);
//		System.out.println("in company validate");
		System.out.println("in company controller");
		return companyservice.saveCompany(company);
		}

	@GetMapping("/")
	public List<Company> fetchCompanyList()
	{
		System.out.println("in get mapping");
		return companyservice.fetchCompanyList();
		} 
	
	@PutMapping("/{id}")
	public   Company updateCompany(@RequestBody Company company, @PathVariable("id") long id)
	{
		
	return companyservice.UpadateCompany(company, id);
	
	}
	
	  @DeleteMapping("/{id}")
	    public String deleteDepartmentById(@PathVariable("id") Long id) {
	    
	        companyservice.deleteCompanyById(id);
	        return "Deleted Successfully";
	    }
		
}
