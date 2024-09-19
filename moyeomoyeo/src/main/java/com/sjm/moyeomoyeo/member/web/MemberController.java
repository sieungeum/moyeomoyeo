package com.sjm.moyeomoyeo.member.web;

import com.sjm.moyeomoyeo.gatheringMem.service.GatheringMemService;
import com.sjm.moyeomoyeo.member.dto.MemberDTO;
import com.sjm.moyeomoyeo.member.service.MemberService;
import java.io.PrintStream;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	GatheringMemService gatheringMemService;

	
	public String signUpView() {
		System.out.println("signUpView");
		return "member/signUpView";
	}

	public String signUpDo(MemberDTO member) {
		System.out.println("signUpDo");
		memberService.signUpMember(member);
		return "redirect:/signInView";
	}

	public String signInView() {
		System.out.println("signInView");
		return "member/signInView";
	}

	public String signInDo(MemberDTO member, HttpSession session) {
		System.out.println("signInDo");
		MemberDTO login = memberService.signInMember(member);
		if (login != null) {
			session.setAttribute("login", login);
			List gMemList = gatheringMemService.selectGatheringMem(login.getMemId());
			System.out.println(gMemList);
			if (gMemList.size() == 0) {
				return "redirect:/";
			} else {
				session.setAttribute("gatheringMemList", gMemList);
				return "gathering/gatheringSelect";
			}
		} else {
			session.setAttribute("login", "");
			return "redirect:/signInView";
		}
	}

	public String logoutDo(HttpSession session) {
		System.out.println("logOutDo");
		session.invalidate();
		return "redirect:/";
	}
}
