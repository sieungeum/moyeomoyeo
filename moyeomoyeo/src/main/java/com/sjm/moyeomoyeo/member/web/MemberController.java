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

	// ȸ������ �������� �̵�
	@RequestMapping("/signUpView")
	public String signUpView() {
		System.out.println("signUpView");
		return "member/signUpView";
	}

	// ȸ������ ��ư Ŭ�� ��
	@PostMapping("/signUpDo")
	public String signUpDo(MemberDTO member) {
		System.out.println("signUpDo");
		
		// �ű� ������ ���� DB ����
		memberService.signUpMember(member);
		
		return "redirect:/signInView";
	}

	// �α��� �������� �̵�
	@RequestMapping("/signInView")
	public String signInView() {
		System.out.println("signInView");
		return "member/signInView";
	}

	// �α��� ��ư Ŭ�� ��
	@PostMapping("/signInDo")
	public String signInDo(MemberDTO member, HttpSession session) {
		System.out.println("signInDo");
		
		MemberDTO login = memberService.signInMember(member); // DB���� �ش� ȸ���� ������ ������
		
		if (login != null) { // ���Ե� ȸ���� ���
			session.setAttribute("login", login); // ���ǿ� �� �α��� ���� ����
			
			List gMemList = gatheringMemService.selectGatheringMem(login.getMemId()); // ���Ե� ���� ����Ʈ
			System.out.println(gMemList);
			
			if (gMemList.size() == 0) { // ���Ե� ������ ���� ���(�ű� ȸ��)
				// �ٷ� Ȩȭ������ �̵�
				return "redirect:/";
			} else { // ���Ե� ������ �ϳ��� ���� ���
				session.setAttribute("gatheringMemList", gMemList); // ���ǿ� ���Ե� ���� ����Ʈ ����
				
				// ������ ���� ����â���� �̵�
				return "gathering/gatheringSelect";
			}
		} else { // ���Ե��� ���� ȸ���� ���
			
			session.invalidate(); // ���� ���� �ʱ�ȭ
			
			// ��α���
			return "redirect:/signInView";
		}
	}

	// �׺���̼ǿ� �α׾ƿ� Ŭ�� ��
	@RequestMapping("/logOutDo")
	public String logOutDo(HttpSession session) {
		System.out.println("logOutDo");
		
		session.invalidate(); // ���� ���� �ʱ�ȭ
		
		// Ȩȭ������ �̵�
		return "redirect:/";
	}
}
