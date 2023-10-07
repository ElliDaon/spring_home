package com.myhome.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myhome.myapp.domain.MemberVo;
import com.myhome.myapp.service.MemberService;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
	
	@Autowired
	MemberService ms;
	
	@RequestMapping(value = "/memberJoin.do")
	public String memberJoin() {
		
		
		return "/member/memberJoin";
	}
	
	@RequestMapping(value = "/memberJoinAction.do")
	public String memberJoinAction(MemberVo mv) {
		
		String birth = mv.getMemberYear() + mv.getMemberMonth() + mv.getMemberDay();
		mv.setMemberBirth(birth);
		
		int value = ms.memberInsert(mv);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/memberLogin.do")
	public String memberLogin() {
		
		return "/member/memberLogin";
	}
}
