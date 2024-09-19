package com.sjm.moyeomoyeo.member.web;

import com.sjm.moyeomoyeo.gatheringMem.service.GatheringMemService;
import com.sjm.moyeomoyeo.member.dto.MemberDTO;
import com.sjm.moyeomoyeo.member.service.MemberService;
import java.io.PrintStream;
import java.util.List;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	
	@Autowired
	MemberService memberService;
	
	@Autowired
	GatheringMemService gatheringMemService;

	// 회원가입 페이지로 이동
	@RequestMapping("/signUpView")
	public String signUpView() {
		System.out.println("signUpView");
		return "member/signUpView";
	}

	// 회원가입 버튼 클릭 시
	@PostMapping("/signUpDo")
	public String signUpDo(MemberDTO member) {
		System.out.println("signUpDo");
		
		// 신규 가입자 정보 DB 저장
		memberService.signUpMember(member);
		
		return "redirect:/signInView";
	}

	// 로그인 페이지로 이동
	@RequestMapping("/signInView")
	public String signInView() {
		System.out.println("signInView");
		return "member/signInView";
	}

	// 로그인 버튼 클릭 시
	@PostMapping("/signInDo")
	public String signInDo(MemberDTO member, HttpSession session) {
		System.out.println("signInDo");
		
		MemberDTO login = memberService.signInMember(member); // DB에서 해당 회원의 정보를 가져옴
		
		if (login != null) { // 가입된 회원일 경우
			session.setAttribute("login", login); // 세션에 현 로그인 정보 저장
			
			List gMemList = gatheringMemService.selectGatheringMem(login.getMemId()); // 가입된 모임 리스트
			System.out.println(gMemList);
			
			if (gMemList.size() == 0) { // 가입된 모임이 없을 경우(신규 회원)
				// 바로 홈화면으로 이동
				return "redirect:/";
			} else { // 가입된 모임이 하나라도 있을 경우
				session.setAttribute("gatheringMemList", gMemList); // 세션에 가입된 모임 리스트 저장
				
				// 입장할 모임 선택창으로 이동
				return "gathering/gatheringSelect";
			}
		} else { // 가입되지 않은 회원일 경우
			
			session.invalidate(); // 세션 정보 초기화
			
			// 재로그인
			return "redirect:/signInView";
		}
	}

	// 네비게이션에 로그아웃 클릭 시
	@RequestMapping("/logOutDo")
	public String logOutDo(HttpSession session) {
		System.out.println("logOutDo");
		
		session.invalidate(); // 세션 정보 초기화
		
		// 홈화면으로 이동
		return "redirect:/";
	}
}
