// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MemberService.java

package com.sjm.moyeomoyeo.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjm.moyeomoyeo.member.dao.IMemberDAO;
import com.sjm.moyeomoyeo.member.dto.MemberDTO;

@Service
public class MemberService {

	@Autowired
	IMemberDAO dao;

	// �ű�ȸ�� DB�� ����(INSERT)
	public int signUpMember(MemberDTO member) {
		int result = dao.signUpMember(member);
		return result;
	}

    // �ش� ȸ���� ���� ��������(SELECT)
	public MemberDTO signInMember(MemberDTO member) {
		MemberDTO result = dao.signInMember(member);
		return result;
	}
}
