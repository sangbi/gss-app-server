package com.gss.web.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserRatioInfo {
	private int gssUserNum;
	private int divisionPercent;
	private int partyNum;
}
