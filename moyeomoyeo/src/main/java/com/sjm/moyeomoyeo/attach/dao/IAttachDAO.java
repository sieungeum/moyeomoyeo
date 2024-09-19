// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IAttachDAO.java

package com.sjm.moyeomoyeo.attach.dao;

import com.sjm.moyeomoyeo.attach.dto.AttachDTO;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface IAttachDAO {

	int insertAttach(AttachDTO attach);

	List<AttachDTO> getAttachList(@Param("atchParentNo")int atchParentNo, @Param("gatherCode")String gatherCode);
}
