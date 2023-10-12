package com.myhome.myapp.service;

import java.util.ArrayList;

import com.myhome.myapp.domain.BoardVo;
import com.myhome.myapp.domain.SearchCriteria;

public interface BoardService {
	public int boardInsert(BoardVo bv);
	public ArrayList<BoardVo> boardList(SearchCriteria scri);
	public BoardVo boardContents(int bidx);
	public int boardTotalCount(SearchCriteria scri);
}
