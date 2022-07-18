package com.gss.web.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gss.web.api.dto.NoticeDto;
import com.gss.web.common.component.JsoupComponent;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {
	private final JsoupComponent jsoupComponent;

	@Override
	public List<NoticeDto> getNoticeList(String page) {
		return jsoupComponent.getNoticePageList(page);
	}
	
	@Override
	public String getNoticeContents(String url) {
		return jsoupComponent.getNoticeHtml(url);
	}
}