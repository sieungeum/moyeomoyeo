package com.sjm.moyeomoyeo.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.sjm.moyeomoyeo.member.dto.MemberDTO;

@Mapper
public interface IMemberDAO{

    public abstract int signUpMember(MemberDTO memberdto);

    public abstract MemberDTO signInMember(MemberDTO memberdto);
}
