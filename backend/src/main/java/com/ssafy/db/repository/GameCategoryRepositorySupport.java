package com.ssafy.db.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.db.entity.Board;
import com.ssafy.db.entity.GameCategory;
import com.ssafy.db.qentity.QBoard;
import com.ssafy.db.qentity.QFriend;
import com.ssafy.db.qentity.QGameCategory;

/**
 * 유저 모델 관련 디비 쿼리 생성을 위한 구현 정의.
 */
@Repository
public class GameCategoryRepositorySupport {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;
    QGameCategory qGameCategory = QGameCategory.gameCategory;

	public List<GameCategory> getTopic() {
		List<GameCategory> res;
		res = jpaQueryFactory.selectFrom(qGameCategory)
				.orderBy(qGameCategory.subjectCount.desc()).fetch();
		return res;
	}
    
}
