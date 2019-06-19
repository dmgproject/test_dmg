package com.dmg.jsp.product.model.vo;

public class ProCategory {
	private String pcid;
	private String pcname;
	
	
	public ProCategory() {
		
	}


	public ProCategory(String pcid, String pcname) {
		super();
		this.pcid = pcid;
		this.pcname = pcname;
	}


	public final String getPcid() {
		return pcid;
	}


	public final void setPcid(String pcid) {
		this.pcid = pcid;
	}


	public final String getPcname() {
		return pcname;
	}


	public final void setPcname(String pcname) {
		this.pcname = pcname;
	}
	
	

}
