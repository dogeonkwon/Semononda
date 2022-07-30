package com.ssafy.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.request.BoardRequest;
import com.ssafy.api.response.BoardResponse;
import com.ssafy.api.service.BoardService;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.Board;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 유저 관련 API 요청 처리를 위한 컨트롤러 정의.
 */
@Api(value = "guide API", tags = { "Guide" })
@RestController
@RequestMapping("/api/guide")
public class GuideController {

	@Autowired
	BoardService boardService;
	
	@PostMapping("/create")
	@ApiOperation(value = "board 글등록", notes = "<strong>글 정보</strong>를 통해 게시글을 추가한다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "게시물 없음"), @ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<? extends BaseResponseBody> createBoard(
			@RequestBody @ApiParam(value = "글 정보", required = true) BoardRequest boardInfo) {

		System.out.println(boardInfo.getUserUid());
		System.out.println(boardInfo.getCategoryLarge());
		System.out.println(boardInfo.getCategoryMiddle());
		System.out.println(boardInfo.getTitle());
		System.out.println(boardInfo.getRegTime());

		Board board = boardService.createBoard(boardInfo);

		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
	
	@GetMapping("")
	@ApiOperation(value = "board 검색 정보", notes = "<strong>board 를 uid로 검색한 정보</strong>")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "게시물 없음"), @ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<? extends BoardResponse> findBoardByUid(
			 @ApiParam(value = "board uid", required = true) @RequestParam("uid") int uid) {

		Board board = boardService.findBoardByUid(uid);
		if (board==null) {
			return ResponseEntity.status(400).body(BoardResponse.of(400, "Bad responce",board));
		}
		else {
			return ResponseEntity.status(200).body(BoardResponse.of(200, "Success",board));			
		}
	}
	

	@PutMapping("")
	@ApiOperation(value = "board 글 변경 내용", notes = "<strong>board 를 uid로 검색한 정보</strong>.")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "게시물 없음"), @ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<? extends BoardResponse> updateBoardByUid(
			@RequestBody @ApiParam(value = "글 정보", required = true) BoardRequest boardInfo) {
		Board board = boardService.findBoardByUid(boardInfo.getUid());
		System.out.println("it is in");
		
		System.out.println(boardInfo.getUserUid());
		System.out.println(boardInfo.getCategoryLarge());
		System.out.println(boardInfo.getCategoryMiddle());
		System.out.println(boardInfo.getTitle());
		System.out.println(boardInfo.getRegTime());

		if (board==null) {
			System.out.println("업데이트 할 게시물이 없습니다.");
			return ResponseEntity.status(400).body(BoardResponse.of(400, "Success",board));
		}
		else {
			boardService.updateBoard(board, boardInfo);
			return ResponseEntity.status(200).body(BoardResponse.of(200, "Success",board));
		}
	}
	

	@DeleteMapping("")
	@ApiOperation(value = "board 글 삭제", notes = "<strong>board 를 uid로 검색한 게시글 삭제</strong>.")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "게시물 없음"), @ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<? extends BaseResponseBody> deleteBoardByUid(
			@ApiParam(value = "board uid", required = true) @RequestParam("uid") int uid) {
		Board board = boardService.findBoardByUid(uid);
		if(board!=null) {
			boardService.deleteBoardByUid(board);
			return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
		}
		else {
			return ResponseEntity.status(200).body(BaseResponseBody.of(404, "failed, that board is not found"));
		}
	}
	

}
