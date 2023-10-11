package com.myhome.myapp.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhome.myapp.domain.BoardVo;
import com.myhome.myapp.persistance.BoardService_Mapper;
import com.myhome.myapp.persistance.MemberService_Mapper;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	SqlSession sqlSession;
	private BoardService_Mapper bsm;
	
	@Autowired
	BoardServiceImpl(SqlSession sqlSession){
		this.bsm = sqlSession.getMapper(BoardService_Mapper.class);
	}
	
	@Override
	public int boardInsert(BoardVo bv) {
		int result = bsm.boardInsert(bv);
		int bidx = bv.getBidx();
		bsm.boardOriginBidxUpdate(bidx);
		return result;
	}

}
