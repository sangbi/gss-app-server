package com.gss.web.common.service;

import org.springframework.stereotype.Service;

import com.gss.web.api.dto.PartyPageDto;
import com.gss.web.api.dto.PartyPageDto2;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Service
public class PartyPageCreatorServiceDown {
	private PartyPageDto2 paging;
	private int articleCount;
	private int beginPage;
	private int endPage;
	private boolean prev;
	private boolean next;

	private final int disPlayPageNum = 5;

	private void calcDataOfPage() {
		endPage = (int) Math.ceil(paging.getPage() / (double) disPlayPageNum) * disPlayPageNum;
		beginPage = (endPage - disPlayPageNum) + 1;
		prev = (beginPage == 1) ? false : true;
		next = (articleCount <= (endPage * paging.getCounterPage())) ? false : true;
		if (!isNext()) {
			endPage = (int) Math.ceil(articleCount / (double) paging.getCounterPage());
		}
	}

	public void setArticleCount(int articleCount) {
		this.articleCount = articleCount;
		calcDataOfPage();
	}
}
