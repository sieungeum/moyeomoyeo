// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GalleryService.java

package com.sjm.moyeomoyeo.gallery.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjm.moyeomoyeo.gallery.dao.IGalleryDAO;
import com.sjm.moyeomoyeo.gallery.dto.GalleryDTO;

@Service
public class GalleryService {

	@Autowired
	IGalleryDAO dao;

	public int writeGallery(GalleryDTO gallery) {
		int result = dao.writeGallery(gallery);
		return result;
	}
	
	public int getGalleryNo() {
		int result = dao.getGalleryNo();
		return result;
	}
	
	public List<GalleryDTO> getGallery(String gatherCode){
		List<GalleryDTO> result = dao.getGallery(gatherCode);
		return result;
	}
}
