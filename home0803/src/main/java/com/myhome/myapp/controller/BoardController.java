package com.myhome.myapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myhome.myapp.domain.BoardVo;
import com.myhome.myapp.service.BoardService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	
	@Autowired
	BoardService bs;
	
	@RequestMapping(value = "/boardWrite.do")
	public String boardWrite() {
		
		
		return "/board/boardWrite";
	}
	
	@RequestMapping(value = "/boardWriteAction.do")
	public String boardWriteAction(BoardVo bv, HttpSession session) {
		
		
		bv.setMidx(((Integer)session.getAttribute("midx")).intValue());
		bs.boardInsert(bv);
		
		return "redirect:/board/boardList.do";
	}
	
	@RequestMapping(value = "/boardList.do")
	public String boardList() {
		
		
		return "/board/boardList";
	}
}
