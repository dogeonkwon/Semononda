package com.ssafy.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
import com.ssafy.api.response.GameCategoryTopicsRes;
import com.ssafy.api.response.PlayerRes;
import com.ssafy.api.response.UserLoginPostRes;
import com.ssafy.api.response.UserResponse;
import com.ssafy.api.service.GameService;
import com.ssafy.api.service.StatisService;
import com.ssafy.api.service.UserService;
import com.ssafy.common.auth.SsafyUserDetails;
import com.ssafy.common.model.response.BaseResponseBody;
import com.ssafy.common.util.JwtTokenUtil;
import com.ssafy.db.entity.GameCategory;
import com.ssafy.db.entity.GameCategoryTopic;
import com.ssafy.db.entity.GameConferenceRoom;
import com.ssafy.db.entity.Player;
import com.ssafy.db.entity.User;
import com.ssafy.db.repository.UserRepositorySupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import springfox.documentation.annotations.ApiIgnore;


@Api(value = "통계 API", tags = {"Statis"})
@RestController
@RequestMapping("/api/statis")
public class StatisController {
	
	@Autowired
	StatisService statisService;
	
	@GetMapping("/topic")
	@ApiOperation(value = "플레이어 정보 조회", notes = "플레이어의 <strong>아이디</strong>를 통해 플레이어의 정보를 리턴한다.") 
    @ApiResponses({
        @ApiResponse(code = 200, message = "성공"),
        @ApiResponse(code = 401, message = "인증 실패"),
        @ApiResponse(code = 404, message = "사용자 없음"),
        @ApiResponse(code = 500, message = "서버 오류")
    })
	public ResponseEntity<List<GameCategory>> getPlayerInfo(
			@RequestBody @ApiParam(value="아이디 정보", required = true) UserRequest idInfo) {

		List<GameCategory> category = statisService.getCategory();
		if (category == null) {
			return new ResponseEntity<List<GameCategory>>(category, HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<List<GameCategory>>(category, HttpStatus.OK);
		}
	}
	
}
