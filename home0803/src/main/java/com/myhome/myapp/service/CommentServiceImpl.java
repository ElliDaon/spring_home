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
	private CommentService_Mapper bsm;
	
	@Autowired
	CommentServiceImpl(SqlSession sqlSession){
		this.bsm = sqlSession.getMapper(CommentService_Mapper.class);
	}
	
	@Override
	public ArrayList<CommentVo> commentList() {
		ArrayList<CommentVo> commentList = bsm.commentList();
		return commentList;
	}

}
