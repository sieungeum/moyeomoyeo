// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GatheringMemDTO.java

package com.sjm.moyeomoyeo.gatheringMem.dto;

public class GatheringMemDTO {
	private String gatherCode;
	private String memId;
	private String gatherName;
	private String gatherNick;
	private String delYn;
	private String headerYn;
	public GatheringMemDTO(String gatherCode, String memId, String gatherName, String gatherNick, String delYn,
			String headerYn) {
		super();
		this.gatherCode = gatherCode;
		this.memId = memId;
		this.gatherName = gatherName;
		this.gatherNick = gatherNick;
		this.delYn = delYn;
		this.headerYn = headerYn;
	}
	public GatheringMemDTO() {
		super();
	}
	@Override
	public String toString() {
		return "GatheringMemDTO [gatherCode=" + gatherCode + ", memId=" + memId + ", gatherName=" + gatherName
				+ ", gatherNick=" + gatherNick + ", delYn=" + delYn + ", headerYn=" + headerYn + "]";
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
	public String getGatherName() {
		return gatherName;
	}
	public void setGatherName(String gatherName) {
		this.gatherName = gatherName;
	}
	public String getGatherNick() {
		return gatherNick;
	}
	public void setGatherNick(String gatherNick) {
		this.gatherNick = gatherNick;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getHeaderYn() {
		return headerYn;
	}
	public void setHeaderYn(String headerYn) {
		this.headerYn = headerYn;
	}
	
	
}
