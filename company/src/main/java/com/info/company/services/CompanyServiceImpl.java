package com.info.company.services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.info.company.entities.Company;
import com.info.company.reposiroties.CompanyRepository;



@Service
public class CompanyServiceImpl implements CompanyService{
	
	@Autowired
	private CompanyRepository companyrepo;
	
	@Override
	public Company saveCompany(Company company) {
		return companyrepo.save(company);
		
	}
	
	@Override
	  public List<Company> fetchCompanyList(){
		return companyrepo.findAll();}

	

@Override
   public Company UpadateCompany(Company company, Long id)
 {
	
	Company compDB = companyrepo.findById(id).get();
	

if (Objects.nonNull(company.getName())
     && !"".equalsIgnoreCase(
    		 company.getName())) {
    compDB.setName(
    		company.getName());
  
}


if (Objects.nonNull(company.getCountry())
     && !"".equalsIgnoreCase(
    		 company.getCountry())) {
    compDB.setCountry(company.getCountry());
  
}


if (company.getContact() != 0) {
    compDB.setContact(company.getContact());
}


if (Objects.nonNull(company.getBussinessType())
	     && !"".equalsIgnoreCase(
	    		 company.getBussinessType())) {
	    compDB.setBussinessType(
	    		company.getBussinessType());
	  
	}

if (Objects.nonNull(company.getCurrencysymbol())
	     && !"".equalsIgnoreCase(
	    		 company.getCurrencysymbol())) {
	    compDB.setCurrencysymbol(
	    		company.getCurrencysymbol());
	  
	}

if (Objects.nonNull(company.getEmail())
	     && !"".equalsIgnoreCase(
	    		 company.getEmail())) {
	    compDB.setEmail(
	    		company.getEmail());
	  
	}
if (Objects.nonNull(company.getEmail())
	     && !"".equalsIgnoreCase(
	    		 company.getEmail())) {
	    compDB.setEmail(
	    		company.getEmail());
	  
	}
if (Objects.nonNull(company.getAddress())
	     && !"".equalsIgnoreCase(
	    		 company.getAddress())) {
	    compDB.setAddress(
	    		company.getAddress());
	  
	}
if (Objects.nonNull(company.getPassword())
	     && !"".equalsIgnoreCase(
	    		 company.getPassword())) {
	    compDB.setPassword(
	    		company.getPassword());
	  
	}


	return companyrepo.save(compDB);
}

//delete record
@Transactional
@Override
public void deleteCompanyById(long id) {
	companyrepo.deleteById(id);
}


}


