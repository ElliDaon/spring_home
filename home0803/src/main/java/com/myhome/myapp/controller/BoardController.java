package com.myhome.myapp.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.myhome.myapp.domain.BoardVo;
import com.myhome.myapp.domain.PageMaker;
import com.myhome.myapp.domain.SearchCriteria;
import com.myhome.myapp.service.BoardService;
import com.myhome.myapp.util.UploadFileUtiles;

@Controller
@RequestMapping(value = "/board")
public class BoardController {
	
	@Resource(name="uploadPath")
	String uploadPath;
	
	@Autowired
	private BoardService bs;
	
	@Autowired
	private PageMaker pm;
	
	@RequestMapping(value = "/boardWrite.do")
	public String boardWrite() {
		
		
		return "/board/boardWrite";
	}
	
	@RequestMapping(value = "/boardWriteAction.do")
	public String boardWriteAction(BoardVo bv, HttpSession session) throws Exception {
		
		MultipartFile file = bv.getFilename();
		String uploadedFileName = "";
		if(!file.getOriginalFilename().equals("")) {
			uploadedFileName = UploadFileUtiles.uploadFile(uploadPath, file.getOriginalFilename(), file.getBytes());
		}
		String ip = InetAddress.getLocalHost().getHostAddress();
		bv.setIp(ip);
		bv.setFilename2(uploadedFileName);
		System.out.println(bv.getFilename2());
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
	
	@RequestMapping(value = "/boardModify.do")
	public String boardModify(@RequestParam("bidx") int bidx, Model model) {
		BoardVo bv = bs.boardContents(bidx);
		model.addAttribute("bv", bv);
		return "/board/boardModify";
	}
	
	@RequestMapping(value = "/boardModifyAction.do")
	public String boardModifyAction(BoardVo bv) {
		int result = bs.boardModify(bv);
		if(result!=0) {
			return "redirect:/board/boardContents.do?bidx="+bv.getBidx();
		}else {
			return "redirect:/board/boardModify.do?bidx="+bv.getBidx();
		}
	}
	
	@RequestMapping(value = "/boardDelete.do")
	public String boardDelete(@RequestParam("bidx") int bidx, Model model) {
		BoardVo bv = bs.boardContents(bidx);
		model.addAttribute("bv", bv);
		return "board/boardDelete";
	}
	
	@RequestMapping(value = "/boardDeleteAction.do")
	public String boardDeleteAction(BoardVo bv) {
		int result = bs.boardDelete(bv);
		if(result!=0) {
			return "redirect:/board/boardList.do";
		}else {
			return "redirect:/board/boardDelete.do?bidx="+bv.getBidx();
		}
	}
	
	@RequestMapping(value = "/boardReply.do")
	public String boardReply(BoardVo bv, Model model) {
		
		model.addAttribute("bv", bv);
		return "board/boardReply";
	}
	
	@RequestMapping(value = "/boardReplyAction.do")
	public String boardReplyAction(BoardVo bv, HttpSession session) throws Exception {
		String ip = InetAddress.getLocalHost().getHostAddress();
		bv.setIp(ip);
		bs.boardReply(bv);
		int bidx = bv.getBidx();
		return "redirect:/board/boardContents.do?bidx="+bidx;
	}
}
