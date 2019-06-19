package com.dmg.jsp.recipe.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Recipe implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 10000L;
	private int renum;
	private String remain;
	private String resub;
	private String rename;
	private String recipe;
	private Date uploaddate;
	private String recipefile;
	private int count;

	public Recipe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Recipe(String remain, String rename, String recipe, String recipefile, int recount) {
		super();
		this.remain = remain;
		this.rename = rename;
		this.recipe = recipe;
		this.recipefile = recipefile;
	}

	public Recipe(int renum, String remain, String rename, String recipe, Date uploaddate, String recipefile,
			int count) {
		super();
		this.renum = renum;
		this.remain = remain;
		this.rename = rename;
		this.recipe = recipe;
		this.uploaddate = uploaddate;
		this.recipefile = recipefile;
		this.count = count;
	}
	
	

	public Recipe(int renum, String remain, String resub, String rename, String recipe, Date uploaddate,
			String recipefile, int count) {
		super();
		this.renum = renum;
		this.remain = remain;
		this.resub = resub;
		this.rename = rename;
		this.recipe = recipe;
		this.uploaddate = uploaddate;
		this.recipefile = recipefile;
		this.count = count;
	}



	public int getRenum() {
		return renum;
	}

	public void setRenum(int renum) {
		this.renum = renum;
	}

	public String getRemain() {
		return remain;
	}

	public void setRemain(String remain) {
		this.remain = remain;
	}

	public String getRename() {
		return rename;
	}

	public void setRename(String rename) {
		this.rename = rename;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	public Date getUploaddate() {
		return uploaddate;
	}

	public void setUploaddate(Date uploaddate) {
		this.uploaddate = uploaddate;
	}

	public String getRecipefile() {
		return recipefile;
	}

	public void setRecipefile(String recipefile) {
		this.recipefile = recipefile;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	

	public String getResub() {
		return resub;
	}



	public void setResub(String resub) {
		this.resub = resub;
	}



	@Override
	public String toString() {
		return "Recipe [renum=" + renum + ", remain=" + remain + ", resub=" + resub + ", rename=" + rename + ", recipe="
				+ recipe + ", uploaddate=" + uploaddate + ", recipefile=" + recipefile + ", count=" + count + "]";
	}

}
