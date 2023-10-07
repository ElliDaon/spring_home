package com.myhome.myapp.domain;

//�ϴ� ������ �׺���̼ǿ� �ʿ��� �������� ���� ������ Ŭ����
public class PageMaker {
	private int displayPageNum = 10; //�������� ������ ��� ����
	private int startPage; //����� ���� ��ȣ
	private int endPage; //����� �� ��ȣ
	private int totalCount; //�� �Խù� �� ��� ����
	
	private boolean prev; //������ư ���� ����
	private boolean next; //������ư ���� ����
	
	private SearchCriteria scri;
	
	
	public SearchCriteria getScri() {
		return scri;
	}

	public void setScri(SearchCriteria scri) {
		this.scri = scri;
	}

	public int getDisplayPageNum() {
		return displayPageNum;
	}

	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		CalcData(); //������ ��� ���� ��Ÿ���ֱ� ���� ����
	}

	private void CalcData() {
		//1. �⺻������ 1���� 10���� ��Ÿ���� ����
		endPage = (int)Math.ceil(scri.getPage()/(double)displayPageNum)*displayPageNum;
		
		//2. end �������� ���������� ���� �������� ��������~!
		startPage = (endPage-displayPageNum)+1;
		
		//3. ���� ������ ���� �̰ڴ�!!!
		int tempEndPage = (int)Math.ceil(totalCount/(double)scri.getPerPageNum());
		
		//4. ���� endPage�� ���� endPage�� ���Ѵ�.
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		//5. ���� ���� ��ư ����
		prev = (startPage == 1 ? false:true);
		next = (endPage*scri.getPerPageNum() >= totalCount ? false:true);
		
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	
}