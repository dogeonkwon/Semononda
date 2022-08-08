package com.ssafy.api.service;

import com.ssafy.db.entity.GameCategoryTopic;
import com.ssafy.db.entity.Player;

/**
 *	유저 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */
public interface GameService {
	Player getPlayerByUserId(String userId);
	void changePlayerReady(String userId);
	void makeRandomKing(int gameConferenceRoomUid);
	void makeRandomTeam(int gameConferenceRoomUid);
	void gameStart(int gameConferenceRoomUid);
	void changePenalty(int gameConferenceRoomUid, String userID, int penalty);
	GameCategoryTopic getRoundStart(int gameConferenceRoomUid);
	Player getRoundEnd(int gameConferenceRoomUid, String winTeam);
	void normalGameEnd(int gameConferenceRoomUid, int userUid);
	void customGameEnd(int gameConferenceRoomUid);
	void accusation(int gameConferenceRoomUid, int attackerUid, int reporterUid, int accusationUid);
	void join(String userId, int gameConferenceRoomUid);
	void quit(String userId, int gameConferenceRoomUid);
}
