package com.myhome.myapp.service;

import java.util.ArrayList;

import com.myhome.myapp.domain.CommentVo;

public interface CommentService {
	public ArrayList<CommentVo> commentList(int bidx);
	public int commentWrite(CommentVo cv);
	public int commentDelete(int cidx);
}
