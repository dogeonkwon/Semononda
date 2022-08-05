package com.ssafy.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.response.UserResponse;
import com.ssafy.api.service.FriendService;
import com.ssafy.db.entity.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "친구 추가API", tags = { "Friend" })
@RestController
@RequestMapping("api/friend")
public class FriendController {
	@Autowired
	FriendService friendService;
	
	@GetMapping("")
	@ApiOperation(value = "uid로 room 검색 ", notes = "uid로 room검색")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "게임방 없음"), @ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<UserResponse> findUserUidByNickname(
			@ApiParam(value = "user nickname", required = true) @RequestParam("nickname") String nickname) {

		User user = friendService.findUserUidByNickname(nickname);
		if (user == null) {
			return ResponseEntity.status(400).body(UserResponse.of(400, "Bad responce", user));
		} else {
			return ResponseEntity.status(200).body(UserResponse.of(200, "Success", user));
		}
	}
	
}
