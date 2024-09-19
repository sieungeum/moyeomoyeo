package com.sjm.moyeomoyeo.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.sjm.moyeomoyeo.member.dto.MemberDTO;

@Mapper
public interface IMemberDAO{

	// 신규회원 DB에 저장(INSERT)
    public abstract int signUpMember(MemberDTO member);

    // 해당 회원의 정보 가져오기(SELECT)
    public abstract MemberDTO signInMember(MemberDTO member);
}
