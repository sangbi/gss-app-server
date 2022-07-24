package com.gss.web.api.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartyGetItemDto {
	private String itemName;
	private Integer itemPrice;
	private String partyName;
}
