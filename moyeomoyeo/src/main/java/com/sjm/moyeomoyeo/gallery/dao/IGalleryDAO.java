// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   IGalleryDAO.java

package com.sjm.moyeomoyeo.gallery.dao;

import org.apache.ibatis.annotations.Mapper;

import com.sjm.moyeomoyeo.gallery.dto.GalleryDTO;

@Mapper
public interface IGalleryDAO {

	public abstract int writeGallery(GalleryDTO gallerydto);
}
