package com.ssafy.api.service;

import java.util.List;

import com.ssafy.db.entity.GameCategory;


/**
 *	통계 관련 비즈니스 로직 처리를 위한 서비스 인터페이스 정의.
 */
public interface StatisService {

	List<GameCategory> getCategory();
}
