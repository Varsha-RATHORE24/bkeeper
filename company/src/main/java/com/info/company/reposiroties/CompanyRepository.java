package com.info.company.reposiroties;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.info.company.entities.Company;

@Repository
public interface CompanyRepository  extends JpaRepository<Company, Integer>{

	Optional<Company> findById(Long id);
   // Optional<Company> findByName(String Name);

	void deleteById(long id);

	
  
}

