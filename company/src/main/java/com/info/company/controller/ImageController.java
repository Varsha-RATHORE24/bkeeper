package com.info.company.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.info.company.services.ImageServices;

@RestController
@RequestMapping("/image")
public class ImageController {
	
	@Autowired
	private ImageServices service;
	
	@PostMapping
	public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file, @RequestParam("signature")MultipartFile file1) throws IOException {
		String uploadImage = service.uploadImage(file,file1);

				return ResponseEntity.status(HttpStatus.OK)
				.body(uploadImage)
				;
	}


}
