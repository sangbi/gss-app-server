package com.gss.web.common.service;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {	
	public String fileUpload(MultipartFile mul, String fileName, String filePath) {
		String imagePath=filePath;
		System.out.println(filePath);
		String fileExtension=fileName.substring(fileName.lastIndexOf("."));
		if(fileExtension.equalsIgnoreCase(".png") || fileExtension.equalsIgnoreCase(".jpeg")|| fileExtension.equalsIgnoreCase(".jpg")) {
			try {
				mul.transferTo(new File(filePath,fileName));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		return imagePath;
	}
}
