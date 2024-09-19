// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GatheringMemService.java

package com.sjm.moyeomoyeo.gatheringMem.service;

import com.sjm.moyeomoyeo.gathering.dto.GatheringDTO;
import com.sjm.moyeomoyeo.gatheringMem.dao.IGatheringMemDAO;
import com.sjm.moyeomoyeo.gatheringMem.dto.GatheringMemDTO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GatheringMemService {

	@Autowired
	IGatheringMemDAO dao;

	// 모임 가입 시 모임에 가입된 회원 정보 DB에 저장(INSERT)
	public int addGatheringMem(GatheringMemDTO gMem) {
		int result = dao.addGatheringMem(gMem);
		return result;
	}

	// 파라미터의 ID가 가입된 모임들 리스트로 가져오기(SELECT)
	public List<GatheringMemDTO> selectGatheringMem(String memId) {
		List<GatheringMemDTO> result = dao.selectGatheringMem(memId);
		return result;
	}

	public GatheringMemDTO getGatheringMem(String memId, String gatherCode) {
		GatheringMemDTO result = dao.getGatheringMem(memId, gatherCode);
		return result;
	}
}
