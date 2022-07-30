package com.gss.web.api.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PagingVO {
	private int nowPage; //현재페이지
	private int	startPage;//시작페이지
	private int endPage;//끝페이지
	private int total;// row 총 갯수
	private int cntPerPage;// 페이지당 글 갯수
	private int lastPage;//마지막페이지
	private int start;//SQL쿼리에 쓸 start, end
	private int end;
	
	public PagingVO(int total, int nowPage, int cntPerPage) {
		this.nowPage=nowPage;
		this.cntPerPage=cntPerPage;
		this.total=total;
		calcLastPage(getTotal(), getCntPerPage());
		calcStartEndPage(getNowPage(), cntPerPage);
		calcStartEnd(getNowPage(), getCntPerPage());
	}
	
	public void calcLastPage(int total, int cntPerPage) {
		setLastPage((int) Math.ceil((double)total / (double)cntPerPage));
	}
	
	public void calcStartEndPage(int nowPage, int cntPage) {
		setEndPage(((int)Math.ceil((double)nowPage / (double)cntPage)) * cntPage);
		if (getLastPage() < getEndPage()) {
			setEndPage(getLastPage());
		}
		setStartPage(getEndPage() - cntPage + 1);
		if (getStartPage() < 1) {
			setStartPage(1);
		}
	}
	// DB 쿼리에서 사용할 start, end값 계산
	public void calcStartEnd(int nowPage, int cntPerPage) {
		setEnd(nowPage * cntPerPage);
		setStart(getEnd() - cntPerPage + 1);
	}
}
