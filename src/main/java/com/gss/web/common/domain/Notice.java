package com.gss.web.common.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notice {
	private String noticeTitle;
	private String noticeUrl;
	private String noticePostTime;

	public String getNoticeUrl() {
		return "https://maplestory.nexon.com" + noticeUrl;
	}
}
