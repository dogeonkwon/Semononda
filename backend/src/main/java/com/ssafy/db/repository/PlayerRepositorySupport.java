package com.ssafy.db.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.db.entity.Player;
import com.ssafy.db.entity.QPlayer;
import com.ssafy.db.entity.QUser;
import com.ssafy.db.entity.User;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 유저 모델 관련 디비 쿼리 생성을 위한 구현 정의.
 */
@Repository
public class PlayerRepositorySupport {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;
    QPlayer qPlayer = QPlayer.player;

    public Optional<Player> findPlayerByUserId(String userId) {
    	System.out.println(userId);
    	System.out.println(11);
        Player player = jpaQueryFactory.select(qPlayer).from(qPlayer)
                .where(qPlayer.usersUid.eq(Long.parseLong(userId))).fetchOne();
        System.out.println(2);
        if(player == null) return Optional.empty();
        return Optional.ofNullable(player);
    }
}
