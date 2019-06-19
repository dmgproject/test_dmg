package com.dmg.jsp.inquiry.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Inquiry implements Serializable{
	
	private static final long serialVersionUID = 100L;
	
	// 필드 변수 : DB - Column
	// **
	// 만약 DB의 테이블 정보와 다르게 
	// VO에 더 많은 값을 담거나 DB의 JOIN 정보를 활용한 데이터들을 사용하고자 한다면
	// VO의 정보를 테이블과 1:1로 연결시키지 않아도 된다.
	
	// VO ~ DB Table 양측의 정보가 일치하지 않아도 된다.
	private int ino;			// 게시글 번호
	private int itype;			// 게시판 종류
	private String ititle;		// 제목
	private String icontent;	// 게시글 내용
	private String iwriter;		// 게시글 작성자
	private String iwriterId;	// DB로 부터 가져올 게시글 작성자 아이디
	private int icount;			// 게시글 조회수
	private String inquiryfile;	// 게시글 첨부파일
	private Date idate;			// 작성일
	private String status;		// 삭제 여부('Y' 이면 삭제 X, 'N' 이면 삭제 O)
	
	// 생성자 : 클래스
	public Inquiry() {}

	public Inquiry(String ititle, String icontent, String iwriter, String inquiryfile) {
		super();
		this.ititle = ititle;
		this.icontent = icontent;
		this.iwriter = iwriter;
		this.inquiryfile = inquiryfile;
	}

	public Inquiry(int ino, int itype, String ititle, String icontent, String iwriter, int icount, String inquiryfile,
			Date idate, String status) {
		super();
		this.ino = ino;
		this.itype = itype;
		this.ititle = ititle;
		this.icontent = icontent;
		this.iwriter = iwriter;
		this.icount = icount;
		this.inquiryfile = inquiryfile;
		this.idate = idate;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Inquiry [ino=" + ino + ", itype=" + itype + ", ititle=" + ititle + ", icontent=" + icontent + ", iwriter="
				+ iwriter + ", icount=" + icount + ", inquiryfile=" + inquiryfile + ", idate=" + idate + ", status="
				+ status + "]";
	}

	public int getIno() {
		return ino;
	}

	public int getItype() {
		return itype;
	}

	public String getItitle() {
		return ititle;
	}

	public String getIcontent() {
		return icontent;
	}

	public String getIwriter() {
		return iwriter;
	}

	public String getIwriterId() {
		return iwriterId;
	}

	public int getIcount() {
		return icount;
	}

	public String getInquiryfile() {
		return inquiryfile;
	}

	public Date getIdate() {
		return idate;
	}

	public String getStatus() {
		return status;
	}

	public void setIno(int ino) {
		this.ino = ino;
	}

	public void setItype(int itype) {
		this.itype = itype;
	}

	public void setItitle(String ititle) {
		this.ititle = ititle;
	}

	public void setIcontent(String icontent) {
		this.icontent = icontent;
	}

	public void setIwriter(String iwriter) {
		this.iwriter = iwriter;
	}

	public void setIwriterId(String iwriterId) {
		this.iwriterId = iwriterId;
	}

	public void setIcount(int icount) {
		this.icount = icount;
	}

	public void setInquiryfile(String inquiryfile) {
		this.inquiryfile = inquiryfile;
	}

	public void setIdate(Date idate) {
		this.idate = idate;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
	
	

}
