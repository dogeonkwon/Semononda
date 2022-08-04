package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("RankUserListRequest")
public class RankUserListRequest {

	@ApiModelProperty(name = "유저 ID", example = "ssafy")
	String id;

	@ApiModelProperty(name = "유저 닉네임", example = "싸피")
	String nickname;

	@ApiModelProperty(name = "유저 랭크포인트", example = "100")
	int rankpoint;

	@ApiModelProperty(name = "유저 이미지 주소", example = "9")
	int numberOfWins;

	@ApiModelProperty(name = "유저 한줄소개(100자 이내)", example = "4")
	int numberOfLoses;
}