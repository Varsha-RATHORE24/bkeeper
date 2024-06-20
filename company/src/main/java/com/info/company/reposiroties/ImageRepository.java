package com.info.company.reposiroties;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.info.company.entities.ImageData;
@Repository
public interface ImageRepository extends JpaRepository<ImageData, Long>{
	
   Optional<ImageData> findById(Long id); 

}
