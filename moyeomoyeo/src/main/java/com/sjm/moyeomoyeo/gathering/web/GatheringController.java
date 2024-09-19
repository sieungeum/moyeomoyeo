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

	// 모임 홈화면으로 이동
	@PostMapping("/enterGathering")
	public String enterGathering(String gatherCode, HttpSession session) {
		System.out.println("enterGathering");
		
		MemberDTO login = (MemberDTO) session.getAttribute("login"); // 현 로그인 정보 세션에서 가져오기
		
		// 현 사용자가 가입된 모임정보 리스트로 가져오기
		List<GatheringMemDTO> gMemList = gatheringMemService.selectGatheringMem(login.getMemId());
		session.setAttribute("gatheringMemList", gMemList); // 리스트 세션에 저장
		
		// 현재 선택한 모임 정보만 가져오기
		GatheringMemDTO gMem = gatheringMemService.getGatheringMem(login.getMemId(), gatherCode);
		session.setAttribute("nowGMem", gMem); // 모임 정보 세션에 저장
		
		// 모임 화면으로 이동
		return "gathering/gatheringHome";
	}

	// 모임 생성 창으로 이동
	@RequestMapping("/makeGatheringView")
	public String makeGatheringView() {
		System.out.println("makeGatheringView");
		
		return "gathering/makeGatheringView";
	}
	
	// 모임 생성 버튼 클릭 시
	@PostMapping("/makeGatheringDo")
	public String makeGatheringDo(String gatherName, String gatherNick, HttpSession session) {
		System.out.println("makeGatheringDo");
		
		//// 모임 생성
		GatheringDTO gather = new GatheringDTO(); // 생성할 모임 정보가 저장될 dto
		
		// 모임의 유니크 코드 생성
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		
		gather.setGatherCode(sdf.format(date)); // 모임 코드
		gather.setGatherName(gatherName); // 모임명
		gatheringService.makeGathering(gather); // 모임 생성(DB[gathering]에 저장)
		
		//// 모임 생성자의 정보를 생성된 모임에 저장
		MemberDTO login = (MemberDTO) session.getAttribute("login"); // 현 로그인 정보를 세션에서 가져오기
		
		GatheringMemDTO gMem = new GatheringMemDTO(); // 모임 생성자의 정보가 저장될 dto
		
		gMem.setGatherCode(gather.getGatherCode()); // 모임코드
		gMem.setMemId(login.getMemId()); // 현 로그인 정보의 id
		gMem.setGatherName(gatherName); // 모임명
		gMem.setGatherNick(gatherNick); // 현 모임 내에서의 닉네임
		gMem.setDelYn("N"); // 삭제 여부
		gMem.setHeaderYn("Y"); // 회장 여부
		gatheringMemService.addGatheringMem(gMem); // 정보 DB[gatheringMem]에 저장
		
		// 현 사용자가 가입된 모임정보 리스트로 가져오기
		List<GatheringMemDTO> gMemList = gatheringMemService.selectGatheringMem(login.getMemId());
		session.setAttribute("gatheringMemList", gMemList); // 리스트 세션에 저장
		session.setAttribute("nowGMem", gMem); // 모임 정보 세션에 저장
		
		// 모임 화면으로 이동
		return "gathering/gatheringHome";
	}

	// 모임 참가 페이지로 이동
	@RequestMapping("/inputCodeView")
	public String inputCodeView(GatheringMemDTO gMem, HttpSession session) {
		System.out.println("inputCodeView");
		return "gathering/inputCodeView";
	}

	// 모임 참가 버튼 클릭 시
	@PostMapping("/inputCodeDO")
	public String inputCodeDO(GatheringMemDTO gMem, HttpSession session, Model model) {
		System.out.println("inputCodeDO");
		
		MemberDTO login = (MemberDTO) session.getAttribute("login"); // 현 로그인 정보 세션에서 가져오기
		
		//// 입력한 코드와 일치하는 모임에 현 로그인 정보를 저장(모임에 회원추가)
		GatheringDTO nowGather = gatheringService.getGatheringName(gMem.getGatherCode()); // 참가한 모임 정보
		gMem.setMemId(login.getMemId()); // 현 로그인 id
		gMem.setGatherName(nowGather.getGatherName()); // 참가한 모임명
		gMem.setDelYn("N"); // 삭제 여부
		gMem.setHeaderYn("N"); // 회장 여부
		gatheringMemService.addGatheringMem(gMem); // 정보 DB[gatheringMem]에 저장
		
		// 현 사용자가 가입된 모임정보 리스트로 가져오기
		List<GatheringMemDTO> gMemList = gatheringMemService.selectGatheringMem(login.getMemId());
		session.setAttribute("gatheringMemList", gMemList); // 리스트 세션에 저장
		session.setAttribute("nowGMem", gMem); // 모임 정보 세션에 저장
		
		// 모임 화면으로 이동
		return "gathering/gatheringHome";
	}
}
