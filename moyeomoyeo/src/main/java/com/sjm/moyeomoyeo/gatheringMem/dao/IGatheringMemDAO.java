// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IGatheringMemDAO.java

package com.sjm.moyeomoyeo.gatheringMem.dao;

import com.sjm.moyeomoyeo.gatheringMem.dto.GatheringMemDTO;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IGatheringMemDAO {

	public abstract int addGatheringMem(GatheringMemDTO gatheringmemdto);

	public abstract List selectGatheringMem(String s);

	public abstract GatheringMemDTO getGatheringMem(String s, String s1);
}
