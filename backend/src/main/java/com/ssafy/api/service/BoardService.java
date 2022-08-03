package com.ssafy.api.service;

<<<<<<< HEAD
import java.util.List;

import com.ssafy.api.request.BoardRequest;
import com.ssafy.db.entity.Board;

/**
 *	게시판 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */
public interface BoardService {
	Board createBoard(BoardRequest boardRegisterInfo);
	Board findBoardByUid(int uid);
	Board updateBoard(Board board, BoardRequest boardRegisterInfo);
	void deleteBoardByUid(Board board);
	Board postBoardByUsersNickname(int uid);
	List<Board> getAllBoard();
=======
import com.ssafy.api.request.BoardRequest;
import com.ssafy.db.entity.Board;

/**
 *	게시판 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */
public interface BoardService {
	Board createBoard(BoardRequest boardRegisterInfo);
	Board readBoardByUid(BoardRequest boardRegisterInfo);
	Board updateBoard(BoardRequest boardRegisterInfo);
	Board deleteBoardByNickname(int uid);
	Board postBoardByUsersNickname(int uid);
>>>>>>> branch 'feature/front/waiting-room' of https://lab.ssafy.com/s07-webmobile1-sub2/S07P12E103.git
}
