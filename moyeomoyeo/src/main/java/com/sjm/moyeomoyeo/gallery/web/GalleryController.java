// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GalleryController.java

package com.sjm.moyeomoyeo.gallery.web;

import com.sjm.moyeomoyeo.gallery.dto.GalleryDTO;
import com.sjm.moyeomoyeo.gallery.service.GalleryService;
import com.sjm.moyeomoyeo.gathering.service.GatheringService;
import com.sjm.moyeomoyeo.gatheringMem.dto.GatheringMemDTO;
import com.sjm.moyeomoyeo.member.dto.MemberDTO;
import com.sjm.moyeomoyeo.member.service.MemberService;
import java.io.PrintStream;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GalleryController {

	@Autowired
	GalleryService galleryService;
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	GatheringService gatheringService;

	public GalleryController() {
	}

	public String galleryHome() {
		System.out.println("galleryHome");
		return "gallery/galleryHome";
	}

	public String addGalleryView() {
		System.out.println("addGalleryView");
		return "gallery/addGalleryView";
	}

	public String addGalleryDO(GalleryDTO gallery, HttpSession session) {
		System.out.println("addGalleryDo");
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		GatheringMemDTO gMem = (GatheringMemDTO) session.getAttribute("gatheringMem");
		System.out.println(login);
		System.out.println(gMem);
		gallery.setMemId(login.getMemId());
		gallery.setGatherCode(gMem.getGatherCode());
		System.out.println(gallery);
		galleryService.writeGallery(gallery);
		return "redirect:/galleryHome";
	}
}
