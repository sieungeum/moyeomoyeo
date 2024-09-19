// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GatheringMemService.java

package com.sjm.moyeomoyeo.gatheringMem.service;

import com.sjm.moyeomoyeo.gatheringMem.dao.IGatheringMemDAO;
import com.sjm.moyeomoyeo.gatheringMem.dto.GatheringMemDTO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GatheringMemService {

	@Autowired
	IGatheringMemDAO dao;

	public int addGatheringMem(GatheringMemDTO gMem) {
		int result = dao.addGatheringMem(gMem);
		return result;
	}

	public List selectGatheringMem(String memId) {
		List result = dao.selectGatheringMem(memId);
		return result;
	}

	public GatheringMemDTO getGatheringMem(String memId, String gatherCode) {
		GatheringMemDTO result = dao.getGatheringMem(memId, gatherCode);
		return result;
	}
}
