package com.gss.web.common.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {
	private String uploadDir ="C:\\image\\";
	
	public String fileUpload(MultipartFile mul, String fileName) {
		String imagePath=uploadDir;
		String fileExtension=fileName.substring(fileName.lastIndexOf("."));
		if(fileExtension.equals(".PNG") || fileExtension.equals(".JPEG")|| fileExtension.equals(".jpg")) {
			try {
				mul.transferTo(new File(imagePath+fileName));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("file서비스의 else");
			imagePath="";
		}
		return imagePath;
	}
}
