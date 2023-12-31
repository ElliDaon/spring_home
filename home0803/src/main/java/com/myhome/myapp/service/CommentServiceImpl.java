package com.myhome.myapp.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhome.myapp.domain.CommentVo;
import com.myhome.myapp.persistance.CommentService_Mapper;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	SqlSession sqlSession;
	private CommentService_Mapper csm;
	
	@Autowired
	CommentServiceImpl(SqlSession sqlSession){
		this.csm = sqlSession.getMapper(CommentService_Mapper.class);
	}
	
	@Override
	public ArrayList<CommentVo> commentList(int bidx) {
		ArrayList<CommentVo> commentList = csm.commentList(bidx);
		return commentList;
	}

	@Override
	public int commentWrite(CommentVo cv) {
		int value = csm.commentWrite(cv);
		return value;
	}

	@Override
	public int commentDelete(int cidx) {
		int value = csm.commentDelete(cidx);
		return value;
	}

}
