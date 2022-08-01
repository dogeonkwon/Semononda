package com.ssafy.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.api.request.UserRequest;
import com.ssafy.api.request.UserLoginPostReq;
import com.ssafy.api.request.UserRegisterPostReq;
import com.ssafy.api.response.PlayerRes;
import com.ssafy.api.response.UserLoginPostRes;
import com.ssafy.api.response.UserResponse;
import com.ssafy.api.service.GameService;
import com.ssafy.api.service.UserService;
import com.ssafy.common.auth.SsafyUserDetails;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.common.util.JwtTokenUtil;
import com.ssafy.db.entity.Player;
import com.ssafy.db.entity.User;
import com.ssafy.db.repository.UserRepositorySupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;


@Api(value = "게임 API", tags = {"Game"})
@RestController
@RequestMapping("/api/game")
public class GameController {
	
	@Autowired
	GameService gameService;
	
	@GetMapping("/common/player-info")
	@ApiOperation(value = "플레이어 정보 조회", notes = "플레이어의 <strong>아이디</strong>를 통해 플레이어의 정보를 리턴한다.") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "인증 실패"),
        @ApiResponse(code = 404, message = "사용자 없음"),
        @ApiResponse(code = 500, message = "서버 오류")
    })
	public ResponseEntity<PlayerRes> getPlayerInfo(
			@RequestBody @ApiParam(value="아이디 정보", required = true) UserRequest idInfo) {
		//임의로 리턴된 User 인스턴스. 현재 코드는 회원 가입 성공 여부만 판단하기 때문에 굳이 Insert 된 유저 정보를 응답하지 않음.

		Player player = gameService.getPlayerByUserId(idInfo.getId());
		return ResponseEntity.status(200).body(PlayerRes.of(player));
	}
	
	@PostMapping("/common/ready")
	@ApiOperation(value = "플레이어 준비 상태 변경", notes = "플레이어의 <strong>아이디</strong>를 통해 플레이어의 준비상태를 변경한다.") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "인증 실패"),
        @ApiResponse(code = 404, message = "사용자 없음"),
        @ApiResponse(code = 500, message = "서버 오류")
    })
	public ResponseEntity<? extends BaseResponseBody> playerReady(
			@RequestBody @ApiParam(value="아이디 정보", required = true) UserRequest idInfo) {
		//임의로 리턴된 User 인스턴스. 현재 코드는 회원 가입 성공 여부만 판단하기 때문에 굳이 Insert 된 유저 정보를 응답하지 않음.

		gameService.changePlayerReady(idInfo.getId());
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
	@PostMapping("/common/game-start")
	@ApiOperation(value = "게임 시작", notes = "게임 컨퍼런스 룸이 <strong>게임 중</strong>상태로 전환된다.") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "인증 실패"),
        @ApiResponse(code = 404, message = "사용자 없음"),
        @ApiResponse(code = 500, message = "서버 오류")
    })
	public ResponseEntity<? extends BaseResponseBody> gameStart(
			@RequestParam("gameConferenceRoomUid") @ApiParam(value="게임 컨퍼런스룸 Uid 정보", required = true) int gameConferenceRoomUid) {
		//임의로 리턴된 User 인스턴스. 현재 코드는 회원 가입 성공 여부만 판단하기 때문에 굳이 Insert 된 유저 정보를 응답하지 않음.

		gameService.gameStart(gameConferenceRoomUid);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
	@PostMapping("/common/penalty")
	@ApiOperation(value = "플레이어 제한", notes = "해당 아이디의 플레이어의 <strong>제한 여부(0:스피커, 1:카메라, 2:음성변조)</strong>를 변경한다.") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "인증 실패"),
        @ApiResponse(code = 404, message = "사용자 없음"),
        @ApiResponse(code = 500, message = "서버 오류")
    })
	public ResponseEntity<? extends BaseResponseBody> changePenalty(
			@RequestParam("gameConferenceRoomUid") @ApiParam(value="게임 컨퍼런스룸 Uid 정보", required = true) int gameConferenceRoomUid,
			@RequestParam("userID") @ApiParam(value="플레이어의 user ID", required = true) String userID, 
			@RequestParam("penalty") @ApiParam(value="제한 종류(0:스피커, 1:카메라, 2:음성변조)", required = true) int penalty) {
		//임의로 리턴된 User 인스턴스. 현재 코드는 회원 가입 성공 여부만 판단하기 때문에 굳이 Insert 된 유저 정보를 응답하지 않음.

		gameService.changePenalty(gameConferenceRoomUid, userID, penalty);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
	@PostMapping("/normal/random-king")
	@ApiOperation(value = "랜덤 왕 선정", notes = "해당 게임에서 <strong>랜덤왕을 한 번도 해본 적 없는</strong>플레이어 중 왕을 선정한다.") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "인증 실패"),
        @ApiResponse(code = 404, message = "사용자 없음"),
        @ApiResponse(code = 500, message = "서버 오류")
    })
	public ResponseEntity<? extends BaseResponseBody> randomKing(
			@RequestParam("gameConferenceRoomUid") @ApiParam(value="게임 컨퍼런스룸 Uid 정보", required = true) int gameConferenceRoomUid) {
		//임의로 리턴된 User 인스턴스. 현재 코드는 회원 가입 성공 여부만 판단하기 때문에 굳이 Insert 된 유저 정보를 응답하지 않음.

		gameService.makeRandomKing(gameConferenceRoomUid);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
	
	@PostMapping("/normal/random-team")
	@ApiOperation(value = "랜덤 팀 배정", notes = "왕을 제외한  플레이어들에게 <strong>랜덤으로 팀을</strong>배정한다.") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "인증 실패"),
        @ApiResponse(code = 404, message = "사용자 없음"),
        @ApiResponse(code = 500, message = "서버 오류")
    })
	public ResponseEntity<? extends BaseResponseBody> randomTeam(
			@RequestParam("gameConferenceRoomUid") @ApiParam(value="게임 컨퍼런스룸 Uid 정보", required = true) int gameConferenceRoomUid) {
		//임의로 리턴된 User 인스턴스. 현재 코드는 회원 가입 성공 여부만 판단하기 때문에 굳이 Insert 된 유저 정보를 응답하지 않음.

		gameService.makeRandomTeam(gameConferenceRoomUid);
		return ResponseEntity.status(200).body(BaseResponseBody.of(200, "Success"));
	}
}
