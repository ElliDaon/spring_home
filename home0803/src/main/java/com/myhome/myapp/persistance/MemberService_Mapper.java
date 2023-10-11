package com.myhome.myapp.persistance;

import java.util.ArrayList;

import com.myhome.myapp.domain.MemberVo;

public interface MemberService_Mapper {
	public int memberInsert(MemberVo mv);
	public MemberVo memberLogin(String MemberId);
	public int memberIdCheck(String memberId);
	public ArrayList<MemberVo> memberList();
}
