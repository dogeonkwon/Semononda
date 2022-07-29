package com.ssafy.api.controller;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.request.BoardRequest;
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
@Api(value = "커뮤니티 API", tags = { "Community" })
@RestController
@RequestMapping("/api/community")
public class CommunityController {

	@Autowired
	BoardService boardService;

	@PostMapping("/create")
	@ApiOperation(value = "글등록", notes = "<strong>아이디와 패스워드</strong>를 통해 회원가입 한다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "게시물 없음"), @ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<? extends BaseResponseBody> createBoard(
			@RequestBody @ApiParam(value = "글 정보", required = true) BoardRequest registerInfo) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			Board board = boardService.createBoard(registerInfo);
			tx.commit();
			return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
		} catch (Exception e) {
			tx.rollback();
			return ResponseEntity.status(400).body(BaseResponseBody.of(400, "Bad responce"));
		} finally {
			System.out.println("hhhhhhhhhhhhhh");
			em.close();
		}

	}

	@PostMapping("/test")
	@ApiOperation(value = "글등록", notes = "<strong>아이디와 패스워드</strong>를 통해 회원가입 한다.")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "게시물 없음"), @ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<? extends BaseResponseBody> createBoardTest(
			@RequestBody @ApiParam(value = "글 정보", required = true) BoardRequest registerInfo) {

		System.out.println(registerInfo.getUserUid());
		System.out.println(registerInfo.getCategoryLarge());
		System.out.println(registerInfo.getCategoryMiddle());
		System.out.println(registerInfo.getTitle());
		System.out.println(registerInfo.getRegTime());

		Board board = boardService.createBoard(registerInfo);

		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));

	}
}
