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
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class GatheringController {

	@Autowired
	GatheringService gatheringService;
	
	@Autowired
	GatheringMemService gatheringMemService;

	public String enterGathering(String gatherCode, HttpSession session) {
		System.out.println("enterGathering");
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		System.out.println(
				(new StringBuilder("\uD604\uC7AC \uBAA8\uC784 \uCF54\uB4DC : ")).append(gatherCode).toString());
		java.util.List gMemList = gatheringMemService.selectGatheringMem(login.getMemId());
		session.setAttribute("gatheringMemList", gMemList);
		GatheringMemDTO gMem = gatheringMemService.getGatheringMem(login.getMemId(), gatherCode);
		session.setAttribute("nowGMem", gMem);
		return "gathering/gatheringHome";
	}

	public String makeGatheringView() {
		System.out.println("makeGatheringView");
		return "gathering/makeGatheringView";
	}

	public String makeGatheringDo(String gatherName, String gatherNick, HttpSession session) {
		System.out.println("makeGatheringDo");
		GatheringDTO gather = new GatheringDTO();
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		gather.setGatherCode(sdf.format(date));
		gather.setGatherName(gatherName);
		gatheringService.makeGathering(gather);
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		GatheringMemDTO gMem = new GatheringMemDTO();
		gMem.setGatherCode(gather.getGatherCode());
		gMem.setMemId(login.getMemId());
		gMem.setGatherName(gatherName);
		gMem.setGatherNick(gatherNick);
		gMem.setDelYn("N");
		gMem.setHeaderYn("Y");
		gatheringMemService.addGatheringMem(gMem);
		java.util.List gMemList = gatheringMemService.selectGatheringMem(login.getMemId());
		session.setAttribute("gatheringMemList", gMemList);
		session.setAttribute("nowGMem", gMem);
		return "gathering/gatheringHome";
	}

	public String inputCodeView(GatheringMemDTO gMem, HttpSession session) {
		System.out.println("inputCodeView");
		return "gathering/inputCodeView";
	}

	public String inputCodeDO(GatheringMemDTO gMem, HttpSession session, Model model) {
		System.out.println("inputCodeDO");
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		GatheringDTO nowGather = gatheringService.getGatheringName(gMem.getGatherCode());
		gMem.setMemId(login.getMemId());
		gMem.setGatherName(nowGather.getGatherName());
		gMem.setDelYn("N");
		gMem.setHeaderYn("N");
		gatheringMemService.addGatheringMem(gMem);
		java.util.List gMemList = gatheringMemService.selectGatheringMem(login.getMemId());
		session.setAttribute("gatheringMemList", gMemList);
		session.setAttribute("nowGMem", gMem);
		return "gathering/gatheringHome";
	}
}
