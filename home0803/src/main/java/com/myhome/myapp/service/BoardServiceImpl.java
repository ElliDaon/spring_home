package com.myhome.myapp.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhome.myapp.domain.BoardVo;
import com.myhome.myapp.domain.SearchCriteria;
import com.myhome.myapp.persistance.BoardService_Mapper;

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

	@Override
	public ArrayList<BoardVo> boardList(SearchCriteria scri) {
		
		int value = (scri.getPage()-1)*10;
		scri.setPage(value);
		
		ArrayList<BoardVo> list = bsm.boardList(scri);
		return list;
	}

	@Override
	public BoardVo boardContents(int bidx) {
		bsm.boardViewCnt(bidx);
		BoardVo bv = bsm.boardContents(bidx);
		return bv;
	}

	@Override
	public int boardTotalCount(SearchCriteria scri) {
		int value=bsm.boardTotalCount(scri);
		return value;
	}

	@Override
	public int boardModify(BoardVo bv) {
		int value = bsm.boardModify(bv);
		return value;
	}

	@Override
	public int boardDelete(BoardVo bv) {
		int value = bsm.boardDelete(bv);
		return value;
	}

}
