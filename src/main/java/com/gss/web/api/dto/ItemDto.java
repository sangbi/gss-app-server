package com.gss.web.api.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
	private String itemName;	
	private String classification;	
	private MultipartFile itemImagepath;	
	
	private String type;	
	private String keyword;	
}
