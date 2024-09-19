// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AttachDTO.java

package com.sjm.moyeomoyeo.attach.dto;

public class AttachDTO {
	private int atchNo;
	private int atchParentNo;
	private String gatherCode;
	private String atchFileName;
	private String atchOrginName;
	private long atchFileSize;
	private String atchFancySize;
	private String atchContentType;
	private String atchPath;
	
	public AttachDTO() {
	}

	public AttachDTO(int atchNo, int atchParentNo, String gatherCode, String atchFileName, String atchOrginName,
			long atchFileSize, String atchFancySize, String atchContentType, String atchPath) {
		this.atchNo = atchNo;
		this.atchParentNo = atchParentNo;
		this.gatherCode = gatherCode;
		this.atchFileName = atchFileName;
		this.atchOrginName = atchOrginName;
		this.atchFileSize = atchFileSize;
		this.atchFancySize = atchFancySize;
		this.atchContentType = atchContentType;
		this.atchPath = atchPath;
	}

	@Override
	public String toString() {
		return "AttachDTO [atchNo=" + atchNo + ", atchParentNo=" + atchParentNo + ", gatherCode=" + gatherCode
				+ ", atchFileName=" + atchFileName + ", atchOrginName=" + atchOrginName + ", atchFileSize="
				+ atchFileSize + ", atchFancySize=" + atchFancySize + ", atchContentType=" + atchContentType
				+ ", atchPath=" + atchPath + "]";
	}

	public int getAtchNo() {
		return atchNo;
	}

	public void setAtchNo(int atchNo) {
		this.atchNo = atchNo;
	}

	public int getAtchParentNo() {
		return atchParentNo;
	}

	public void setAtchParentNo(int atchParentNo) {
		this.atchParentNo = atchParentNo;
	}

	public String getGatherCode() {
		return gatherCode;
	}

	public void setGatherCode(String gatherCode) {
		this.gatherCode = gatherCode;
	}

	public String getAtchFileName() {
		return atchFileName;
	}

	public void setAtchFileName(String atchFileName) {
		this.atchFileName = atchFileName;
	}

	public String getAtchOrginName() {
		return atchOrginName;
	}

	public void setAtchOrginName(String atchOrginName) {
		this.atchOrginName = atchOrginName;
	}

	public long getAtchFileSize() {
		return atchFileSize;
	}

	public void setAtchFileSize(long atchFileSize) {
		this.atchFileSize = atchFileSize;
	}

	public String getAtchFancySize() {
		return atchFancySize;
	}

	public void setAtchFancySize(String atchFancySize) {
		this.atchFancySize = atchFancySize;
	}

	public String getAtchContentType() {
		return atchContentType;
	}

	public void setAtchContentType(String atchContentType) {
		this.atchContentType = atchContentType;
	}

	public String getAtchPath() {
		return atchPath;
	}

	public void setAtchPath(String atchPath) {
		this.atchPath = atchPath;
	}
	
}
