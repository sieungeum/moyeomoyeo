// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AttachService.java

package com.sjm.moyeomoyeo.attach.service;

import com.sjm.moyeomoyeo.attach.dao.IAttachDAO;
import com.sjm.moyeomoyeo.attach.dto.AttachDTO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttachService {

	@Autowired
	IAttachDAO dao;

	public int insertAttach(AttachDTO attach) {
		int result = dao.insertAttach(attach);
		return result;
	}

	public List<AttachDTO> getAttachList(int atchParentNo, String gatherCode) {
		List<AttachDTO> result = dao.getAttachList(atchParentNo, gatherCode);
		return result;
	}
}
