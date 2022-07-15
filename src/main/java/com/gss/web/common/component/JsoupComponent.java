package com.gss.web.common.component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.gss.web.common.domain.Notice;

// 크롤링 모듈
@Component
public class JsoupComponent {
	// 페이지에 따른 공지사항 목록을 가져온다
	public List<Notice> getNoticePageList(String page) {
		final String noticeUrl = "https://maplestory.nexon.com/News/Notice?page=" + page;
		Connection conn = Jsoup.connect(noticeUrl);
		
		try {
			Document document = conn.get();
			return createNoticeList(document);
		} catch (IOException e) {}
		
		return null;
	}
	
	// 공지사항 목록을 초기화한다
	public List<Notice> createNoticeList(Document document) {
		Elements kosPiUl = document.select("div.news_board ul");
		List<Notice> list = new ArrayList<>();
		
		for (Element element : kosPiUl.select("li")) {
			list.add(createNotice(element));
		}
		
		return list;
	}
	
	// 공지사항 정보를 입력한다
	public Notice createNotice(Element td) {
		Notice notice = Notice.builder().build();
		notice.setNoticeUrl(td.select("p a").attr("href"));
		notice.setNoticeTitle(td.select("p a span").text());
		notice.setNoticePostTime(td.select("div.heart_date dl dd").text());
		
		return notice;
	}
	
	// 해당 공지사항의 내용을 그대로 가져온다
	public String getNoticeHtml(String url) {
		Connection conn = Jsoup.connect(url);

		try {
			Document document = conn.get();
			return document.select("div.qs_text").html();
		} catch (IOException e) {}
		
		return null;
	}
}
