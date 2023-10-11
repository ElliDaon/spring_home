package com.myhome.myapp.persistance;

import com.myhome.myapp.domain.BoardVo;

public interface BoardService_Mapper {
	public int boardInsert(BoardVo bv);
	public int boardOriginBidxUpdate(int bidx);
}
