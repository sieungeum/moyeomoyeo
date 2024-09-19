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

	// ������ �� ���� ÷��
	@Autowired
	GalleryService galleryService;
	
	@Autowired
	AttachService attachService;
	
	@Autowired
	FileUploadUtils fileUploadUtils;
	
	
	// ȸ�� ����
	@Autowired
	MemberService memberService;
	
	@Autowired
	GatheringService gatheringService;

	// ������ Ȩȭ�� �������� �̵�
	@RequestMapping("/galleryHome")
	public String galleryHome(HttpSession session) {
		System.out.println("galleryHome");
		
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		GatheringMemDTO gather = (GatheringMemDTO) session.getAttribute("nowGMem");
		
		// �ش� ������ ������ ���� ��������
		List<GalleryDTO> galleryList = galleryService.getGallery(gather.getGatherCode());
		
		List<List<AttachDTO>> attachListAll = new ArrayList<>();
		for (int i = 0; i < galleryList.size(); i++) {
			// �ش� �Խñ��� ÷������ ��������
			List<AttachDTO> attachList = attachService.getAttachList(galleryList.get(i).getGelNo(), gather.getGatherCode());
			
			System.out.println(attachList);
			
			attachListAll.add(attachList);
		}
		
		System.out.println(attachListAll);
		
		return "gallery/galleryHome";
	}

	// ������ �ۼ� �������� �̵�
	@RequestMapping("/addGalleryView")
	public String addGalleryView() {
		System.out.println("addGalleryView");
		
		return "gallery/addGalleryView";
	}

	@PostMapping("/addGalleryDO")
	public String addGalleryDO(GalleryDTO gallery, HttpSession session, MultipartFile[] boFile) {
		System.out.println("addGalleryDo");
		
		GatheringMemDTO gMem = (GatheringMemDTO) session.getAttribute("nowGMem");
		
		// ���ǿ� ��� ȸ���� ���̵� ���� �� board ��ü�� �ʵ� ������ �߰�
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		
		String memId = login.getMemId();
		gallery.setMemId(memId);
		
		// �̹��� �ۼ��Ǵ� �Խñ��� �۹�ȣ�� �̸� ������
		int atchParentNo = galleryService.getGalleryNo();
		
		// ÷�ε� ������ ������ �� ������ ���ÿ� �����ϰ�, DB�� ����� ������ ������ ������.
		if(boFile != null) {
			System.out.println("���� ���� : " + boFile.length);
			List<AttachDTO> attachList;
			try {
				attachList = fileUploadUtils.getAttachListByMultiparts(boFile);
				if(!attachList.isEmpty()) {
					for (AttachDTO attach : attachList) {
						attach.setAtchParentNo(atchParentNo); // �θ� �Խñ��� �۹�ȣ�� �ʵ庯���� ����
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
