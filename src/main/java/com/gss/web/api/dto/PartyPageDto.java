package com.gss.web.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PartyPageDto {
	private int page;
	private int counterPage;

	public PartyPageDto() {
		this.page = 1;
		this.counterPage = 5;
	}

	public int getPageStart() {
		return (this.page - 1) * this.counterPage;
	}
}
