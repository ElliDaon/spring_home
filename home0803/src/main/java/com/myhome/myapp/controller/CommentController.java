package com.myhome.myapp.controller;

import java.net.InetAddress;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myhome.myapp.domain.CommentVo;
import com.myhome.myapp.service.CommentService;

@RestController
@RequestMapping(value = "/comment")
public class CommentController {
	
	@Autowired
	private CommentService cs;
	
	
	
	@RequestMapping(value = "/{bidx}/commentList.do")
	public JSONObject commentList(@PathVariable("bidx") int bidx) {
		
		ArrayList<CommentVo> list = cs.commentList(bidx);
		JSONObject js = new JSONObject();
		js.put("list", list);
		
		return js;
	}
	
	@RequestMapping(value = "/commentWrite.do")
	public JSONObject commentWrite(CommentVo cv, HttpSession session) throws Exception {
		String ip = InetAddress.getLocalHost().getHostAddress();
		cv.setCip(ip);
		int value = cs.commentWrite(cv);
		JSONObject js = new JSONObject();
		js.put("value", value);
		
		return js;
	}
	
	@RequestMapping(value = "/commentDelete.do")
	public JSONObject commentDelete(int cidx) {
		
		int value = cs.commentDelete(cidx);
		JSONObject js = new JSONObject();
		js.put("value",value);
		
		return js;
	}
}
