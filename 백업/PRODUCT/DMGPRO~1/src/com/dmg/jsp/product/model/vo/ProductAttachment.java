
package com.dmg.jsp.product.model.vo;

public class ProductAttachment {

	
	private int picid;
	private String originFileName;
	private String changeFileName;
	private String filePath;
	private int piclevel;
	private int pid;
	
	
	
	public ProductAttachment() {
		super();
	}
	public ProductAttachment(int picid, String originFileName, String changeFileName, String filePath, int piclevel,
			int pid) {
		super();
		this.picid = picid;
		this.originFileName = originFileName;
		this.changeFileName = changeFileName;
		this.filePath = filePath;
		this.piclevel = piclevel;
		this.pid = pid;
	}
	public int getPicid() {
		return picid;
	}
	public void setPicid(int picid) {
		this.picid = picid;
	}
	public String getOriginFileName() {
		return originFileName;
	}
	public void setOriginFileName(String originFileName) {
		this.originFileName = originFileName;
	}
	public String getChangeFileName() {
		return changeFileName;
	}
	public void setChangeFileName(String changeFileName) {
		this.changeFileName = changeFileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public int getPiclevel() {
		return piclevel;
	}
	public void setPiclevel(int piclevel) {
		this.piclevel = piclevel;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}

	
	
	
	
}
