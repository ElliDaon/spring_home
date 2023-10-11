package com.myhome.myapp.service;

import java.util.ArrayList;

import com.myhome.myapp.domain.BoardVo;

public interface BoardService {
	public int boardInsert(BoardVo bv);
	public ArrayList<BoardVo> boardList();
	public BoardVo boardContents(int bidx);
}
