package com.myhome.myapp.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myhome.myapp.domain.BoardVo;
import com.myhome.myapp.domain.PageMaker;
import com.myhome.myapp.domain.SearchCriteria;
import com.myhome.myapp.service.BoardService;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	
	@Autowired
	private BoardService bs;
	
	@Autowired
	private PageMaker pm;
	
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
	public String boardList(SearchCriteria scri, Model model) {
		int totalCount = bs.boardTotalCount(scri);
		pm.setScri(scri);
		pm.setTotalCount(totalCount);
		
		ArrayList<BoardVo> list = bs.boardList(scri);
		model.addAttribute("list", list);
		model.addAttribute("pm", pm);
		return "/board/boardList";
	}
	
	@RequestMapping(value = "/boardContents.do")
	public String boardContents(@RequestParam("bidx") int bidx, Model model) {
		BoardVo bv = bs.boardContents(bidx);
		model.addAttribute("bv", bv);
		return "/board/boardContents";
	}
	
}
