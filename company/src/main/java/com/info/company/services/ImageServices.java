package com.info.company.services;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.info.company.entities.ImageData;
import com.info.company.reposiroties.ImageRepository;
import com.info.company.util.ImageUtils;
@Service
public class ImageServices {
		@Autowired
	private ImageRepository repository;
	
	public String uploadImage(MultipartFile file,MultipartFile file1) throws IOException {
		 if (file.isEmpty()) {
             return "logo file is empty.";

		 }
		 
		
		if (file1.isEmpty()) {
             return "signature file is empty.";

		 }
		 
		 ImageData imageData = repository.save(ImageData.builder()
	               
	                .logo(ImageUtils.compressImage(file.getBytes())).build());
			
	
		ImageData imageData1 = repository.save(ImageData.builder()
				.signature(ImageUtils.compressImage(file1.getBytes())).build());  
		
		
		 
		
		 if (imageData != null && imageData1 != null) {
	            return "Files uploaded successfully: " + file.getOriginalFilename() + " and " + file1.getOriginalFilename();
	        }
		  return "File upload failed.";    }
	
	
	  
	
		


}
