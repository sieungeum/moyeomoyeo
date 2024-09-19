// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IGatheringDAO.java

package com.sjm.moyeomoyeo.gathering.dao;

import org.apache.ibatis.annotations.Mapper;

import com.sjm.moyeomoyeo.gathering.dto.GatheringDTO;

@Mapper
public interface IGatheringDAO {

	public abstract int makeGathering(GatheringDTO gatheringdto);

	public abstract GatheringDTO getGatheringName(String s);
}
