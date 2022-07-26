package com.gss.web.api.dto;

import javax.validation.constraints.AssertFalse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PriceRatioDto {
	private int divisionPercent;
	private String charaterName;
	private String partyName;
	
	public PriceRatioDto(int divisionPercent, String charaterName, String partyName) {
		this.divisionPercent = divisionPercent;
		this.charaterName = charaterName;
		this.partyName = partyName;
	}
	@AssertFalse(message = "비율 합이 100이 되게 해주세요")
	private boolean divisionBool;
}
