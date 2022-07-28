package com.ssafy.api.service;

import com.ssafy.db.entity.Player;

/**
 *	유저 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */
public interface GameService {
	Player getPlayerByUserId(String userId);
}
