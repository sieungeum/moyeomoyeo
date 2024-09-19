// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IGatheringMemDAO.java

package com.sjm.moyeomoyeo.gatheringMem.dao;

import com.sjm.moyeomoyeo.gathering.dto.GatheringDTO;
import com.sjm.moyeomoyeo.gatheringMem.dto.GatheringMemDTO;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IGatheringMemDAO {

	// 모임 가입 시 모임에 가입된 회원 정보 DB에 저장(INSERT)
	public abstract int addGatheringMem(GatheringMemDTO gMem);

	// 파라미터의 ID가 가입된 모임들 리스트로 가져오기(SELECT)
	public abstract List selectGatheringMem(String memId);

	// 
	public abstract GatheringMemDTO getGatheringMem(@Param("memId")String memId, @Param("gatherCode")String gatherCode);
}
