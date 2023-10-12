package com.myhome.myapp.persistance;

import java.util.ArrayList;

import com.myhome.myapp.domain.BoardVo;
import com.myhome.myapp.domain.SearchCriteria;

public interface BoardService_Mapper {
	public int boardInsert(BoardVo bv);
	public int boardOriginBidxUpdate(int bidx);
	public ArrayList<BoardVo> boardList(SearchCriteria scri);
	public BoardVo boardContents(int bidx);
	public int boardViewCnt(int bidx);
	public int boardTotalCount(SearchCriteria scri);
}
