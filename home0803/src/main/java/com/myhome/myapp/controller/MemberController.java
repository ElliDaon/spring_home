package com.myhome.myapp.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myhome.myapp.domain.MemberVo;
import com.myhome.myapp.service.MemberService;

@Controller
@RequestMapping(value = "/member")
public class MemberController {
	
	@Autowired
	MemberService ms;
	
	@Autowired
	private BCryptPasswordEncoder bcryptPasswordEncoder;
	
	@RequestMapping(value = "/memberJoin.do")
	public String memberJoin() {
		
		
		return "/member/memberJoin";
	}
	
	@RequestMapping(value = "/memberJoinAction.do")
	public String memberJoinAction(MemberVo mv) {
		
		String birth = mv.getMemberYear() + mv.getMemberMonth() + mv.getMemberDay();
		mv.setMemberBirth(birth);
		String memberPwd2 = bcryptPasswordEncoder.encode(mv.getMemberPwd());
		mv.setMemberPwd(memberPwd2);
		int value = ms.memberInsert(mv);
		
		return "redirect:/";
	}
	
	@ResponseBody
	@RequestMapping(value = "/memberIdCheck.do")
	public String memberIdCheck(String memberId) {
		int value = 0;
		value=ms.memberIdCheck(memberId);
		String str = "{\"value\":\""+value+"\"}";
		
		return str;
	}
	
	@RequestMapping(value = "/memberLogin.do")
	public String memberLogin() {
		
		return "/member/memberLogin";
	}
	
	@RequestMapping(value = "/memberLoginAction.do")
	public String memberLoginAction(
			@RequestParam("memberId") String memberId,
			@RequestParam("memberPwd") String memberPwd,
			HttpSession session) {
		MemberVo mv = ms.memberLogin(memberId);
		
		String path = "";
		if(mv!=null&&bcryptPasswordEncoder.matches(memberPwd, mv.getMemberPwd())) {
			session.setAttribute("midx", mv.getMidx());
			path = "index.jsp";
		}else {
			path = "member/memberLogin.do";
		}
		return "redirect:/"+path;
	}
	
	@RequestMapping(value="/memberLogout.do")
	public String memberLogout(HttpSession session) {
		session.removeAttribute("midx");
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping(value="/memberList.do")
	public String memberList(Model model) {
		ArrayList<MemberVo> list = ms.memberList();
		model.addAttribute("list", list);
		return "member/memberList";
	}
}
