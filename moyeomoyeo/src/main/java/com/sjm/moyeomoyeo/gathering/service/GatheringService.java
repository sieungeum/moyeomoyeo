// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GatheringService.java

package com.sjm.moyeomoyeo.gathering.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjm.moyeomoyeo.gathering.dao.IGatheringDAO;
import com.sjm.moyeomoyeo.gathering.dto.GatheringDTO;

@Service
public class GatheringService {

	@Autowired
	IGatheringDAO dao;
	
	public int makeGathering(GatheringDTO gather) {
		int result = dao.makeGathering(gather);
		return result;
	}

	public GatheringDTO getGatheringName(String gatherCode) {
		GatheringDTO result = dao.getGatheringName(gatherCode);
		return result;
	}

}
