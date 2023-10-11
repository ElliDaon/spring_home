package com.myhome.myapp.service;

import java.util.ArrayList;

import com.myhome.myapp.domain.MemberVo;

public interface MemberService {
	public int memberInsert(MemberVo mv);
	public MemberVo memberLogin(String memberId);
	public int memberIdCheck(String memberId);
	public ArrayList<MemberVo> memberList();
}
