// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GalleryDTO.java

package com.sjm.moyeomoyeo.gallery.dto;

public class GalleryDTO {
	String gatherCode;
	String memId;
	int gelNo;
	String gelTitle;
	String gelContent;
	String date;
	String delYn;
	public GalleryDTO(String gatherCode, String memId, int gelNo, String gelTitle, String gelContent, String date,
			String delYn) {
		super();
		this.gatherCode = gatherCode;
		this.memId = memId;
		this.gelNo = gelNo;
		this.gelTitle = gelTitle;
		this.gelContent = gelContent;
		this.date = date;
		this.delYn = delYn;
	}
	public GalleryDTO() {
		super();
	}
	@Override
	public String toString() {
		return "GalleryDTO [gatherCode=" + gatherCode + ", memId=" + memId + ", gelNo=" + gelNo + ", gelTitle="
				+ gelTitle + ", gelContent=" + gelContent + ", date=" + date + ", delYn=" + delYn + "]";
	}
	public String getGatherCode() {
		return gatherCode;
	}
	public void setGatherCode(String gatherCode) {
		this.gatherCode = gatherCode;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public int getGelNo() {
		return gelNo;
	}
	public void setGelNo(int gelNo) {
		this.gelNo = gelNo;
	}
	public String getGelTitle() {
		return gelTitle;
	}
	public void setGelTitle(String gelTitle) {
		this.gelTitle = gelTitle;
	}
	public String getGelContent() {
		return gelContent;
	}
	public void setGelContent(String gelContent) {
		this.gelContent = gelContent;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	
	
}
