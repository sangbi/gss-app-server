package com.gss.web.common.service;

import java.util.List;

import com.gss.web.api.dto.NoticeDto;

public interface NoticeService {
	public List<NoticeDto> getNoticeList(String page);
	
	public String getNoticeContents(String url);
}
