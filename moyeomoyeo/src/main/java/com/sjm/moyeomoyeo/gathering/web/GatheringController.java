// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GatheringController.java

package com.sjm.moyeomoyeo.gathering.web;

import com.sjm.moyeomoyeo.gathering.dto.GatheringDTO;
import com.sjm.moyeomoyeo.gathering.service.GatheringService;
import com.sjm.moyeomoyeo.gatheringMem.dto.GatheringMemDTO;
import com.sjm.moyeomoyeo.gatheringMem.service.GatheringMemService;
import com.sjm.moyeomoyeo.member.dto.MemberDTO;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GatheringController {

	@Autowired
	GatheringService gatheringService;
	
	@Autowired
	GatheringMemService gatheringMemService;

	// ���� Ȩȭ������ �̵�
	@PostMapping("/enterGathering")
	public String enterGathering(String gatherCode, HttpSession session) {
		System.out.println("enterGathering");
		
		MemberDTO login = (MemberDTO) session.getAttribute("login"); // �� �α��� ���� ���ǿ��� ��������
		
		// �� ����ڰ� ���Ե� �������� ����Ʈ�� ��������
		List<GatheringMemDTO> gMemList = gatheringMemService.selectGatheringMem(login.getMemId());
		session.setAttribute("gatheringMemList", gMemList); // ����Ʈ ���ǿ� ����
		
		// ���� ������ ���� ������ ��������
		GatheringMemDTO gMem = gatheringMemService.getGatheringMem(login.getMemId(), gatherCode);
		session.setAttribute("nowGMem", gMem); // ���� ���� ���ǿ� ����
		
		// ���� ȭ������ �̵�
		return "gathering/gatheringHome";
	}

	// ���� ���� â���� �̵�
	@RequestMapping("/makeGatheringView")
	public String makeGatheringView() {
		System.out.println("makeGatheringView");
		
		return "gathering/makeGatheringView";
	}
	
	// ���� ���� ��ư Ŭ�� ��
	@PostMapping("/makeGatheringDo")
	public String makeGatheringDo(String gatherName, String gatherNick, HttpSession session) {
		System.out.println("makeGatheringDo");
		
		//// ���� ����
		GatheringDTO gather = new GatheringDTO(); // ������ ���� ������ ����� dto
		
		// ������ ����ũ �ڵ� ����
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		
		gather.setGatherCode(sdf.format(date)); // ���� �ڵ�
		gather.setGatherName(gatherName); // ���Ӹ�
		gatheringService.makeGathering(gather); // ���� ����(DB[gathering]�� ����)
		
		//// ���� �������� ������ ������ ���ӿ� ����
		MemberDTO login = (MemberDTO) session.getAttribute("login"); // �� �α��� ������ ���ǿ��� ��������
		
		GatheringMemDTO gMem = new GatheringMemDTO(); // ���� �������� ������ ����� dto
		
		gMem.setGatherCode(gather.getGatherCode()); // �����ڵ�
		gMem.setMemId(login.getMemId()); // �� �α��� ������ id
		gMem.setGatherName(gatherName); // ���Ӹ�
		gMem.setGatherNick(gatherNick); // �� ���� �������� �г���
		gMem.setDelYn("N"); // ���� ����
		gMem.setHeaderYn("Y"); // ȸ�� ����
		gatheringMemService.addGatheringMem(gMem); // ���� DB[gatheringMem]�� ����
		
		// �� ����ڰ� ���Ե� �������� ����Ʈ�� ��������
		List<GatheringMemDTO> gMemList = gatheringMemService.selectGatheringMem(login.getMemId());
		session.setAttribute("gatheringMemList", gMemList); // ����Ʈ ���ǿ� ����
		session.setAttribute("nowGMem", gMem); // ���� ���� ���ǿ� ����
		
		// ���� ȭ������ �̵�
		return "gathering/gatheringHome";
	}

	// ���� ���� �������� �̵�
	@RequestMapping("/inputCodeView")
	public String inputCodeView(GatheringMemDTO gMem, HttpSession session) {
		System.out.println("inputCodeView");
		return "gathering/inputCodeView";
	}

	// ���� ���� ��ư Ŭ�� ��
	@PostMapping("/inputCodeDO")
	public String inputCodeDO(GatheringMemDTO gMem, HttpSession session, Model model) {
		System.out.println("inputCodeDO");
		
		MemberDTO login = (MemberDTO) session.getAttribute("login"); // �� �α��� ���� ���ǿ��� ��������
		
		//// �Է��� �ڵ�� ��ġ�ϴ� ���ӿ� �� �α��� ������ ����(���ӿ� ȸ���߰�)
		GatheringDTO nowGather = gatheringService.getGatheringName(gMem.getGatherCode()); // ������ ���� ����
		gMem.setMemId(login.getMemId()); // �� �α��� id
		gMem.setGatherName(nowGather.getGatherName()); // ������ ���Ӹ�
		gMem.setDelYn("N"); // ���� ����
		gMem.setHeaderYn("N"); // ȸ�� ����
		gatheringMemService.addGatheringMem(gMem); // ���� DB[gatheringMem]�� ����
		
		// �� ����ڰ� ���Ե� �������� ����Ʈ�� ��������
		List<GatheringMemDTO> gMemList = gatheringMemService.selectGatheringMem(login.getMemId());
		session.setAttribute("gatheringMemList", gMemList); // ����Ʈ ���ǿ� ����
		session.setAttribute("nowGMem", gMem); // ���� ���� ���ǿ� ����
		
		// ���� ȭ������ �̵�
		return "gathering/gatheringHome";
	}
}
