package com.dmg.jsp.recipe.model.vo;

import java.io.Serializable;

public class RecipeSub implements Serializable {
	private int renum;
	private String resub;
	private String recount;
	private int reno;

	public RecipeSub() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecipeSub(String resub, String recount) {
		super();
		this.resub = resub;
		this.recount = recount;
	}

	public RecipeSub(int renum, String resub, String recount, int reno) {
		super();
		this.renum = renum;
		this.resub = resub;
		this.recount = recount;
		this.reno = reno;
	}

	@Override
	public String toString() {
		return "RecipeSub [renum=" + renum + ", resub=" + resub + "]";
	}

	public int getRenum() {
		return renum;
	}

	public void setRenum(int renum) {
		this.renum = renum;
	}

	public String getResub() {
		return resub;
	}

	public void setResub(String resub) {
		this.resub = resub;
	}

	public String getRecount() {
		return recount;
	}

	public void setRecount(String recount) {
		this.recount = recount;
	}

	public int getReno() {
		return reno;
	}

	public void setReno(int reno) {
		this.reno = reno;
	}

}
