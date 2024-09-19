// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GatheringDTO.java

package com.sjm.moyeomoyeo.gathering.dto;

public class GatheringDTO {
	private String gatherCode;
	private String gatherName;
	private String delYn;
	public GatheringDTO(String gatherCode, String gatherName, String delYn) {
		super();
		this.gatherCode = gatherCode;
		this.gatherName = gatherName;
		this.delYn = delYn;
	}
	public GatheringDTO() {
		super();
	}
	@Override
	public String toString() {
		return "GatheringDTO [gatherCode=" + gatherCode + ", gatherName=" + gatherName + ", delYn=" + delYn + "]";
	}
	public String getGatherCode() {
		return gatherCode;
	}
	public void setGatherCode(String gatherCode) {
		this.gatherCode = gatherCode;
	}
	public String getGatherName() {
		return gatherName;
	}
	public void setGatherName(String gatherName) {
		this.gatherName = gatherName;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	
	
}
