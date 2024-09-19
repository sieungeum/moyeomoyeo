// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IAttachDAO.java

package com.sjm.moyeomoyeo.attach.dao;

import com.sjm.moyeomoyeo.attach.dto.AttachDTO;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IAttachDAO {

	public abstract int insertAttach(AttachDTO attachdto);

	public abstract List getAttachList(int i);
}
