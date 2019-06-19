package com.dmg.jsp.recipe.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Attachment implements Serializable {
	private int fno;
	private int renum;
	private String originname;
	private String changename;
	private String filepath;
	private Date uploaddate;

	public Attachment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Attachment(int fno, int renum, String originname, String changename, String filepath, Date uploaddate) {
		super();
		this.fno = fno;
		this.renum = renum;
		this.originname = originname;
		this.changename = changename;
		this.filepath = filepath;
		this.uploaddate = uploaddate;
	}

	@Override
	public String toString() {
		return "Attachment [fno=" + fno + ", renum=" + renum + ", originname=" + originname + ", changename="
				+ changename + ", filepath=" + filepath + ", uploaddate=" + uploaddate + "]";
	}

	public int getFno() {
		return fno;
	}

	public void setFno(int fno) {
		this.fno = fno;
	}

	public int getRenum() {
		return renum;
	}

	public void setRenum(int renum) {
		this.renum = renum;
	}

	public String getOriginname() {
		return originname;
	}

	public void setOriginname(String originname) {
		this.originname = originname;
	}

	public String getChangename() {
		return changename;
	}

	public void setChangename(String changename) {
		this.changename = changename;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public Date getUploaddate() {
		return uploaddate;
	}

	public void setUploaddate(Date uploaddate) {
		this.uploaddate = uploaddate;
	}

}
