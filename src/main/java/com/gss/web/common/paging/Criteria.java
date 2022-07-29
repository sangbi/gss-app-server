package com.gss.web.common.paging;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Criteria {
	//현재페이지 번호
	private int cuttentPageNo;
	
	//페이지당 출력할 데이터 개수
	private int recordsPerPage;
	
	//화면 하단에 출력할 페이지
	private int pageSize;
	
	//검색 키워드
	private String searchKeyword;
	
	//검색유형
	private String searchType;
	
	public Criteria() {
		this.cuttentPageNo = 1;
		this.recordsPerPage = 10;
		this.pageSize = 10;
	}
	
	public int getStartPage() {
		return (cuttentPageNo -1) * recordsPerPage;
	}
}
