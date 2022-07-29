package com.ssafy.api.service;

import com.ssafy.api.request.BoardRequest;
import com.ssafy.db.entity.Board;

/**
 *	게시판 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */
public interface BoardService {
	Board createBoard(BoardRequest boardRegisterInfo);
	Board findBoardByUid(int uid);
	Board updateBoard(BoardRequest boardRegisterInfo);
	Board deleteBoardByNickname(int uid);
	Board postBoardByUsersNickname(int uid);
}
