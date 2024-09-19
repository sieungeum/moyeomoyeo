// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IGalleryDAO.java

package com.sjm.moyeomoyeo.gallery.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sjm.moyeomoyeo.gallery.dto.GalleryDTO;

@Mapper
public interface IGalleryDAO {

	// gallery 추가 (INSERT)
	public abstract int writeGallery(GalleryDTO gallery);
	
	// 갤러리 추가 시 attach의 parent no 에 추가할 no
	int getGalleryNo();
	
	// 갤러리 가져오기 (SELECT)
	List<GalleryDTO> getGallery(String gatherCode);
}
