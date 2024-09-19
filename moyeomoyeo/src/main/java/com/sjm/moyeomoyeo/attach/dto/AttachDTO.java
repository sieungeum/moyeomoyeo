// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AttachDTO.java

package com.sjm.moyeomoyeo.attach.dto;

public class AttachDTO {
	private int atchNo;
	private int atchParentNo;
	private String atchFileName;
	private String atchOrginName;
	private long atchFileSize;
	private String atchFancySize;
	private String atchContetntType;
	private String atchPath;

	public AttachDTO(int atchNo, int atchParentNo, String atchFileName, String atchOrginName, long atchFileSize,
			String atchFancySize, String atchContetntType, String atchPath) {
		super();
		this.atchNo = atchNo;
		this.atchParentNo = atchParentNo;
		this.atchFileName = atchFileName;
		this.atchOrginName = atchOrginName;
		this.atchFileSize = atchFileSize;
		this.atchFancySize = atchFancySize;
		this.atchContetntType = atchContetntType;
		this.atchPath = atchPath;
	}

	public AttachDTO() {
		super();
	}

	@Override
	public String toString() {
		return "AttachDTO [atchNo=" + atchNo + ", atchParentNo=" + atchParentNo + ", atchFileName=" + atchFileName
				+ ", atchOrginName=" + atchOrginName + ", atchFileSize=" + atchFileSize + ", atchFancySize="
				+ atchFancySize + ", atchContetntType=" + atchContetntType + ", atchPath=" + atchPath + "]";
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

	public String getAtchContetntType() {
		return atchContetntType;
	}

	public void setAtchContetntType(String atchContetntType) {
		this.atchContetntType = atchContetntType;
	}

	public String getAtchPath() {
		return atchPath;
	}

	public void setAtchPath(String atchPath) {
		this.atchPath = atchPath;
	}

}
