// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GalleryController.java

package com.sjm.moyeomoyeo.gallery.web;

import com.sjm.moyeomoyeo.attach.dto.AttachDTO;
import com.sjm.moyeomoyeo.attach.service.AttachService;
import com.sjm.moyeomoyeo.common.util.FileUploadUtils;
import com.sjm.moyeomoyeo.gallery.dto.GalleryDTO;
import com.sjm.moyeomoyeo.gallery.service.GalleryService;
import com.sjm.moyeomoyeo.gathering.service.GatheringService;
import com.sjm.moyeomoyeo.gatheringMem.dto.GatheringMemDTO;
import com.sjm.moyeomoyeo.member.dto.MemberDTO;
import com.sjm.moyeomoyeo.member.service.MemberService;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class GalleryController {

	// 갤러리 및 파일 첨부
	@Autowired
	GalleryService galleryService;
	
	@Autowired
	AttachService attachService;
	
	@Autowired
	FileUploadUtils fileUploadUtils;
	
	
	// 회원 관리
	@Autowired
	MemberService memberService;
	
	@Autowired
	GatheringService gatheringService;

	// 갤러리 홈화면 페이지로 이동
	@RequestMapping("/galleryHome")
	public String galleryHome(HttpSession session) {
		System.out.println("galleryHome");
		
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		GatheringMemDTO gather = (GatheringMemDTO) session.getAttribute("nowGMem");
		
		// 해당 모임의 갤러리 전부 가져오기
		List<GalleryDTO> galleryList = galleryService.getGallery(gather.getGatherCode());
		
		List<List<AttachDTO>> attachListAll = new ArrayList<>();
		for (int i = 0; i < galleryList.size(); i++) {
			// 해당 게시글의 첨부파일 가져오기
			List<AttachDTO> attachList = attachService.getAttachList(galleryList.get(i).getGelNo(), gather.getGatherCode());
			
			System.out.println(attachList);
			
			attachListAll.add(attachList);
		}
		
		System.out.println(attachListAll);
		
		return "gallery/galleryHome";
	}

	// 갤러리 작성 페이지로 이동
	@RequestMapping("/addGalleryView")
	public String addGalleryView() {
		System.out.println("addGalleryView");
		
		return "gallery/addGalleryView";
	}

	@PostMapping("/addGalleryDO")
	public String addGalleryDO(GalleryDTO gallery, HttpSession session, MultipartFile[] boFile) {
		System.out.println("addGalleryDo");
		
		GatheringMemDTO gMem = (GatheringMemDTO) session.getAttribute("nowGMem");
		
		// 세션에 담긴 회원이 아이디를 꺼낸 후 board 객체의 필드 변수에 추가
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		
		String memId = login.getMemId();
		gallery.setMemId(memId);
		
		// 이번에 작성되는 게시글의 글번호를 미리 가져옴
		int atchParentNo = galleryService.getGalleryNo();
		
		// 첨부된 파일이 존재할 시 파일을 로컬에 저장하고, DB에 저장된 파일의 정보를 전달함.
		if(boFile != null) {
			System.out.println("파일 개수 : " + boFile.length);
			List<AttachDTO> attachList;
			try {
				attachList = fileUploadUtils.getAttachListByMultiparts(boFile);
				if(!attachList.isEmpty()) {
					for (AttachDTO attach : attachList) {
						attach.setAtchParentNo(atchParentNo); // 부모 게시글의 글번호를 필드변수에 담음
						attach.setGatherCode(gMem.getGatherCode());
						attachService.insertAttach(attach);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
		
		System.out.println(login);
		System.out.println(gMem);
		gallery.setGatherCode(gMem.getGatherCode());
		gallery.setMemId(login.getMemId());
		System.out.println(gallery);
		galleryService.writeGallery(gallery);
		
		return "redirect:/galleryHome";
	}
}
