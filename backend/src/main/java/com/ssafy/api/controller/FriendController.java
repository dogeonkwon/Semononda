package com.ssafy.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.request.FriendRequest;
import com.ssafy.api.request.RoomRequest;
import com.ssafy.api.response.UserListResponse;
import com.ssafy.api.response.UserResponse;
import com.ssafy.api.service.FriendService;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.db.entity.Friend;
import com.ssafy.db.entity.GameConferenceRoom;
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

//	@GetMapping("")
//	@ApiOperation(value = "nickname으로 uid검색 ", notes = "nickname으로 uid검색")
//	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
//			@ApiResponse(code = 404, message = "사용자 없음"), @ApiResponse(code = 500, message = "서버 오류") })
//	public ResponseEntity<UserResponse> findUserUidByNickname(
//			@ApiParam(value = "user nickname", required = true) @RequestParam("nickname") String nickname) {
//
//		User user = friendService.findUserUidByNickname(nickname);
//		if (user == null) {
//			return ResponseEntity.status(400).body(UserResponse.of(400, "Bad responce", user));
//		} else {
//			return ResponseEntity.status(200).body(UserResponse.of(200, "Success", user));
//		}
//	}

	@GetMapping("")
	@ApiOperation(value = "nickname으로 uid검색 ", notes = "nickname으로 uid검색")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "사용자 없음"), @ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<UserListResponse> findUserUidByNickname(
			@ApiParam(value = "user nickname", required = true) @RequestParam("nickname1") String nickname1,
			@RequestParam("nickname2") String nickname2) {

		List<User> users = friendService.findUserUidByNickname(nickname1, nickname2);
		if (users == null) {
			return ResponseEntity.status(400).body(UserListResponse.of(400, "Bad responce", users));
		} else {
			return ResponseEntity.status(200).body(UserListResponse.of(200, "Success", users));
		}
	}
	
	@PostMapping("/create")
	@ApiOperation(value = "친구 신청", notes = "친구 신청")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "신청 없음"), @ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<? extends BaseResponseBody> AddFriend(
			@RequestBody @ApiParam(value = "친구 신청 정보", required = true) FriendRequest friendInfo) {

		System.out.println(friendInfo.toString());
		Friend friend = friendService.AddFriend(friendInfo);

		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
	@GetMapping("/follower")
	@ApiOperation(value = "내 팔로워 정보", notes = "내 팔로워 정보")
	@ApiResponses({ @ApiResponse(code = 200, message = "성공"), @ApiResponse(code = 401, message = "인증 실패"),
			@ApiResponse(code = 404, message = "팔로워 방 없음"), @ApiResponse(code = 500, message = "서버 오류") })
	public ResponseEntity<List<Friend>> findReceiverFriendList(
			@ApiParam(value = "user uid", required = true) @RequestParam("uid") int uid) {

		List<Friend> friends = friendService.findReceiverFriendList(uid);
		if (friends == null) {
			return new ResponseEntity<List<Friend>>(friends, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<List<Friend>>(friends, HttpStatus.OK);
		}
	}
	

}
