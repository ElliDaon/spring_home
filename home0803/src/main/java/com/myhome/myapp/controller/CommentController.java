package com.myhome.myapp.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myhome.myapp.domain.CommentVo;
import com.myhome.myapp.service.CommentService;

@Controller
@RequestMapping(value = "/comment")
public class CommentController {
	
	@Autowired
	private CommentService cs;
	
	@ResponseBody
	@RequestMapping(value = "/commentList.do", produces = "application/text; charset=utf8")
	public String commentList() {
		
		String str = "";
		ArrayList<CommentVo> list = cs.commentList();
		int size = list.size();
		int cidx = 0;
		String cwriter = "";
		String ccontents = "";
		String cwriteday = "";
		int midx = 0;
		String comma = "";
		for(int i=0; i<size; i++) {
			cidx = list.get(i).getCidx();
			cwriter = list.get(i).getCwriter();
			ccontents = list.get(i).getCcontents();
			cwriteday = list.get(i).getCwriteday();
			midx = list.get(i).getMidx();
			if(i==size-1) {
				comma = "";
			}else {
				comma = ",";
			}
			str += "{\"cidx\":\""+cidx+"\",\"cwriter\":\""+cwriter+"\",\"ccontents\":\""+ccontents+"\",\"cwriteday\":\""+cwriteday+"\",\"midx\":\""+midx+"\"}"+comma;
		}
		
		str = "["+str+"]";
		return str;
	}
}
