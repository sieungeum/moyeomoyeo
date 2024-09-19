package com.sjm.moyeomoyeo.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.sjm.moyeomoyeo.member.dto.MemberDTO;

@Mapper
public interface IMemberDAO{

	// �ű�ȸ�� DB�� ����(INSERT)
    public abstract int signUpMember(MemberDTO member);

    // �ش� ȸ���� ���� ��������(SELECT)
    public abstract MemberDTO signInMember(MemberDTO member);
}
