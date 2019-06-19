package com.dmg.jsp.notice.model.vo;

import java.io.Serializable;
import java.sql.Date;
/*
 * DMG.COM 
 * 2019.06.01
 */
public class Notice implements Serializable {

	private static final long serialVersionUID = 10000L;

	

	private int nno;			// 글번호
	private String ntitle;		// 글제목
	private String ncontent;	// 글내용
	private String nwriter;		// 작성자 - admin
	private int ncount;			// 조회수
	private String nboardfile;	// 사진
	private Date ndate;			// 작성일
	
	@Override
	public String toString() {
		return "Notice [nno=" + nno + ", ntitle=" + ntitle + ", ncontent=" + ncontent + ", nwriter=" + nwriter
				+ ", ncount=" + ncount + ", nboardfile=" + nboardfile + ", ndate=" + ndate + "]";
	}

	public Notice() {}

	public Notice(String ntitle, String ncontent, String nwriter, String nboardfile) {
		super();
		this.ntitle = ntitle;
		this.ncontent = ncontent;
		this.nwriter = nwriter;
		this.nboardfile = nboardfile;
	}
	public Notice(int nno, String ntitle, String ncontent, String nwriter, int ncount, String nboardfile, Date ndate) {
		super();
		this.nno = nno;
		this.ntitle = ntitle;
		this.ncontent = ncontent;
		this.nwriter = nwriter;
		this.ncount = ncount;
		this.nboardfile = nboardfile;
		this.ndate = ndate;
	}

	
	
	public int getNno() {
		return nno;
	}

	public void setNno(int nno) {
		this.nno = nno;
	}

	public String getNtitle() {
		return ntitle;
	}

	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}

	public String getNcontent() {
		return ncontent;
	}

	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}

	public String getNwriter() {
		return nwriter;
	}

	public void setNwriter(String nwriter) {
		this.nwriter = nwriter;
	}

	public int getNcount() {
		return ncount;
	}

	public void setNcount(int ncount) {
		this.ncount = ncount;
	}

	public String getNboardfile() {
		return nboardfile;
	}

	public void setNboardfile(String nboardfile) {
		this.nboardfile = nboardfile;
	}

	public Date getNdate() {
		return ndate;
	}

	public void setNdate(Date ndate) {
		this.ndate = ndate;
	}




}
