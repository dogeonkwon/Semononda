package com.ssafy.api.response;

import java.util.Date;

import com.ssafy.db.entity.GameConferenceRoom;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel("RoomListResponse")
public class RoomListResponse {
	
	
	@ApiModelProperty(name = "방 고유 Uid", example = "1")
	int uid;

	@ApiModelProperty(name = "일반 모드 게임 카테고리 Uid", example = "1")
	int gameCategoriesUid;

	@ApiModelProperty(name = "방 제목", example = "나랑 붙어 볼 사람~")
	String title;

	@ApiModelProperty(name = "게임이 진행중인 방인지 확인하는 변수", example = "true")
	boolean gameStart;

	public static RoomListResponse of(Integer statusCode, String message, GameConferenceRoom room) {
		if (room == null) {
			return null;
		} else {
			RoomListResponse res = new RoomListResponse();
			res.setUid(room.getGameCategoriesUid());
			res.setGameCategoriesUid(room.getGameCategoriesUid());
			res.setTitle(room.getTitle());
			res.setGameStart(room.isGameStart());

			return res;
		}

	}

}
