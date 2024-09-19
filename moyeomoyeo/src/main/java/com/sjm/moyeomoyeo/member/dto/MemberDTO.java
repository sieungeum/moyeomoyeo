package com.sjm.moyeomoyeo.member.dto;

public class MemberDTO {
	private String memId;
	private String memName;
	private String memPw;
	private String memEmail;

	public MemberDTO() {
	}

	public MemberDTO(String memId, String memName, String memPw, String memEmail) {
		this.memId = memId;
		this.memName = memName;
		this.memPw = memPw;
		this.memEmail = memEmail;
	}

	@Override
	public String toString() {
		return "MemberDTO [memId=" + memId + ", memName=" + memName + ", memPw=" + memPw + ", memEmail=" + memEmail
				+ "]";
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getMemName() {
		return memName;
	}

	public void setMemName(String memName) {
		this.memName = memName;
	}

	public String getMemPw() {
		return memPw;
	}

	public void setMemPw(String memPw) {
		this.memPw = memPw;
	}

	public String getMemEmail() {
		return memEmail;
	}

	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}

}
