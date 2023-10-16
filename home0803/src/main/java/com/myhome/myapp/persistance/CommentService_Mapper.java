package com.myhome.myapp.persistance;

import java.util.ArrayList;

import com.myhome.myapp.domain.CommentVo;

public interface CommentService_Mapper {
	public ArrayList<CommentVo> commentList(int bidx);
	public int commentWrite(CommentVo cv);
	public int commentDelete(int cidx);
}
