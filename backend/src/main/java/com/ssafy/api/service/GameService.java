package com.ssafy.api.service;

<<<<<<< HEAD
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
=======
import com.ssafy.db.entity.Player;

/**
 *	유저 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */
public interface GameService {
	Player getPlayerByUserId(String userId);
>>>>>>> branch 'feature/front/waiting-room' of https://lab.ssafy.com/s07-webmobile1-sub2/S07P12E103.git
}
