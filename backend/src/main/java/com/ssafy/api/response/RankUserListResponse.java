package com.ssafy.api.response;

import com.ssafy.db.entity.User;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("RankUserListResponse")
public class RankUserListResponse {
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

	public static RankUserListResponse of(Integer statusCode, String message, User user) {
		if (user == null) {
			return null;
		} else {
			RankUserListResponse res = new RankUserListResponse();
			res.setId(user.getId());
			res.setNickname(user.getNickname());
			res.setRankpoint(user.getRankpoint());
			res.setNumberOfWins(user.getNumberOfWins());
			res.setNumberOfLoses(user.getNumberOfLoses());

			return res;
		}
	}
}
