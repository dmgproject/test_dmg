package com.dmg.jsp.inquiry.Comment.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class InquiryComment implements Serializable{

	private static final long serialVersionUID = 10L;
	
	private int cno;
	private int ino;
	private String ccontent;
	private String cwriter;
	private Date cdate;
	private int refcno;
	private int clevel;
	private String cwriterId;
	
	public InquiryComment() { }

	public InquiryComment(int ino, String ccontent, String cwriter, int refcno, int clevel) {
		super();
		this.ino = ino;
		this.ccontent = ccontent;
		this.cwriter = cwriter;
		this.refcno = refcno;
		this.clevel = clevel;
	}

	public InquiryComment(int cno, int ino, String ccontent, String cwriter, Date cdate, int refcno, int clevel) {
		this.cno = cno;
		this.ino = ino;
		this.ccontent = ccontent;
		this.cwriter = cwriter;
		this.cdate = cdate;
		this.refcno = refcno;
		this.clevel = clevel;
	}

	@Override
	public String toString() {
		return "BoardComment [cno=" + cno + ", ino=" + ino + ", ccontent=" + ccontent + ", cwriter=" + cwriter
				+ ", cdate=" + cdate + ", refcno=" + refcno + ", clevel=" + clevel + "]";
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getIno() {
		return ino;
	}

	public void setIno(int ino) {
		this.ino = ino;
	}

	public String getCcontent() {
		return ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}

	public String getCwriter() {
		return cwriter;
	}

	public void setCwriter(String cwriter) {
		this.cwriter = cwriter;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public int getRefcno() {
		return refcno;
	}

	public void setRefcno(int refcno) {
		this.refcno = refcno;
	}

	public int getClevel() {
		return clevel;
	}

	public void setClevel(int clevel) {
		this.clevel = clevel;
	}
	public String getCwriterId() {
		return cwriterId;
	}

	public void setCwriterId(String cwriterId) {
		this.cwriterId = cwriterId;
	}
}
