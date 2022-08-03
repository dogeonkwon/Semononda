package com.ssafy.api.service;

<<<<<<< HEAD
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.api.request.BoardRequest;
import com.ssafy.db.entity.Board;
import com.ssafy.db.repository.BoardRepository;
import com.ssafy.db.repository.BoardRepositorySupport;
/**
 *	유저 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */

/**

  * @FileName : BoardServiceImpl.java
  * @Project : ssafy-web-project
  * @Date : 2022. 7. 30 
  * @작성자 : 김동우
  * @변경이력 :
  * @프로그램 설명 :
  */
@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardRepository boardRepository;
	
	@Autowired
	BoardRepositorySupport boardRepositorySupport;

	/**
	  * @Method Name : createBoard
	  * @작성일 : 2022. 7. 30
	  * @작성자 : 김동우
	  * @변경이력 : 
	
	  * @Method 설명 :
	  * @param boardRegisterInfo
	  * @return
	  */
	@Override
	public Board createBoard(BoardRequest boardRegisterInfo) {
		Board board = new Board();
		board.setCategoryLarge(boardRegisterInfo.getCategoryLarge());
		board.setCategoryMiddle(boardRegisterInfo.getCategoryMiddle());
		board.setContent(boardRegisterInfo.getContent());
		board.setImg(boardRegisterInfo.getImg());
		board.setTitle(boardRegisterInfo.getTitle());
		board.setUserUid(boardRegisterInfo.getUserUid());
		board.setRegTime(boardRegisterInfo.getRegTime());
		board.setViewCount(0);

		return boardRepository.save(board);
	}

	/**
	  * @Method Name : findBoardByUid
	  * @작성일 : 2022. 7. 30
	  * @작성자 : 김동우
	  * @변경이력 : 
	
	  * @Method 설명 :
	  * @param uid
	  * @return
	  */
	@Override
	public Board findBoardByUid(int uid) {
		Board board = new Board();
		board = boardRepositorySupport.findBoardByUid(uid);
		return board;
	}
	
	
	/**
	  * @Method Name : updateBoard
	  * @작성일 : 2022. 7. 30
	  * @작성자 : 김동우
	  * @변경이력 : 
	
	  * @Method 설명 : save 함수를 통해 업데이트한다.
	  * find by Id를 통해 
	  * @param boardRegisterInfo
	  * @return
	  */
	@Override
	public Board updateBoard(Board board, BoardRequest boardRegisterInfo) {
		
		board.setUid(boardRegisterInfo.getUid());
		// 카테고리 변경할 수 있으면 cATEGORY 바꾸는 부분을 넣는다.
		//board.setCategoryLarge(boardRegisterInfo.getCategoryLarge());			
		//board.setCategoryMiddle(boardRegisterInfo.getCategoryMiddle());
		board.setTitle(boardRegisterInfo.getTitle());
		board.setContent(boardRegisterInfo.getContent());
		if (boardRegisterInfo.getImg()!=null) {
			board.setImg(boardRegisterInfo.getImg());			
		}
		//board.setUserUid(boardRegisterInfo.getUserUid());
		board.setRegTime(boardRegisterInfo.getRegTime());
		//board.setViewCount(boardRegisterInfo.getViewCount());
		return boardRepository.save(board);
	}

	@Override
	public void deleteBoardByUid(Board board) {
		boardRepository.delete(board);
	}

	@Override
	public Board postBoardByUsersNickname(int uid) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	  * @Method Name : getAllBoard
	  * @작성일 : 2022. 7. 30
	  * @작성자 : 김동우
	  * @변경이력 : 
	
	  * @Method 설명 :
	  * @return
	  */
	
	@Override
	public List<Board> getAllBoard() {
		// TODO Auto-generated method stub
		return boardRepository.findAll();
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.api.request.BoardRequest;
import com.ssafy.db.entity.Board;
import com.ssafy.db.entity.User;
import com.ssafy.db.repository.BoardRepository;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 *	유저 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */
@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardRepository boardRepository;
	


	@Override
	public Board createBoard(BoardRequest boardRegisterInfo) {
		Board board = new Board();
		board.setCategoryLarge(boardRegisterInfo.getCategoryLarge());
		board.setCategoryMiddle(boardRegisterInfo.getCategoryMiddle());
		board.setContent(boardRegisterInfo.getContent());
		board.setImg(boardRegisterInfo.getImg());
		board.setTitle(boardRegisterInfo.getTitle());
		board.setUserUid(boardRegisterInfo.getUserUid());
		board.setRegTime(boardRegisterInfo.getRegTime());
		board.setViewCount(0);

		return boardRepository.save(board);
	}

	@Override
	public Board readBoardByUid(BoardRequest boardRegisterInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board updateBoard(BoardRequest boardRegisterInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board deleteBoardByNickname(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board postBoardByUsersNickname(int uid) {
		// TODO Auto-generated method stub
		return null;
>>>>>>> branch 'feature/front/waiting-room' of https://lab.ssafy.com/s07-webmobile1-sub2/S07P12E103.git
	}
}
