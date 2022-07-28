package com.ssafy.db.repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.db.entity.GameConferenceRoom;
import com.ssafy.db.entity.Player;
import com.ssafy.db.entity.User;
import com.ssafy.db.qentity.QGameConferenceRoom;
import com.ssafy.db.qentity.QPlayer;
import com.ssafy.db.qentity.QUser;

/**
 * 유저 모델 관련 디비 쿼리 생성을 위한 구현 정의.
 */
@Repository
public class PlayerRepositorySupport {
    @Autowired
    private JPAQueryFactory jpaQueryFactory;
    QPlayer qPlayer = QPlayer.player;
    QUser qUser = QUser.user;
    QGameConferenceRoom qGameConferenceRoom = QGameConferenceRoom.gameConferenceRoom;
    
    public Optional<Player> findPlayerByUserId(String userId) {
    	long userUid = jpaQueryFactory.select(qUser.uid).from(qUser).where((qUser.id).eq(userId)).fetchOne();
        Player player = jpaQueryFactory.select(qPlayer).from(qPlayer)
                .where(qPlayer.usersUid.eq(userUid)).fetchOne();
        if(player == null) return Optional.empty();
        return Optional.ofNullable(player);
    }
    
    @Transactional
	public void changePlayerReadyByUserId(String userId) {
		long userUid = jpaQueryFactory.select(qUser.uid).from(qUser).where((qUser.id).eq(userId)).fetchOne();
		Player player = jpaQueryFactory.select(qPlayer).from(qPlayer)
                .where(qPlayer.usersUid.eq(userUid)).fetchOne();
        jpaQueryFactory.update(qPlayer).set(qPlayer.readyState, jpaQueryFactory.select(qPlayer.readyState).from(qPlayer).where(qPlayer.usersUid.eq(userUid)).fetchOne() ? false:true)
        .where(qPlayer.usersUid.eq(userUid)).execute();
	}

    @Transactional
	public void makeRandomKing(int gameConferenceRoomUid) {
		Random random = new Random();
		ArrayList<Player> playerList = new ArrayList();
		//해당 게임에 참가중인 게임 플레이어 리스트
		playerList = (ArrayList<Player>) jpaQueryFactory.select(qPlayer).from(qPlayer)
		.where(qPlayer.gameConferenceRoomUid.eq((long) gameConferenceRoomUid)).where(qPlayer.randomKing.isFalse()).fetchResults().getResults();
		//랜덤 왕의 인덱스
		int randomIndex = random.nextInt(playerList.size());
		//랜덤 왕
		Player randomKingPlayer = playerList.get(randomIndex);
		//왕이된 플레이어의 randomKing true
		jpaQueryFactory.update(qPlayer).set(qPlayer.randomKing, true)
		.where(qPlayer.usersUid.eq((long)randomKingPlayer.getUsersUid())).execute();
		//모든 플레이어 역할 신하(2)으로 초기화
		jpaQueryFactory.update(qPlayer).set(qPlayer.roleUid, (long)2)
		.where(qPlayer.gameConferenceRoomUid.eq((long)gameConferenceRoomUid)).execute();
		//랜덤 왕 역할을 왕(1)으로 설정
		jpaQueryFactory.update(qPlayer).set(qPlayer.roleUid, (long)1)
		.where(qPlayer.usersUid.eq((long)randomKingPlayer.getUsersUid())).execute();
		
		User randomKingUser = jpaQueryFactory.selectFrom(qUser).where(qUser.uid.eq(randomKingPlayer.getUsersUid())).fetchOne();
		
		System.out.println("UID"+gameConferenceRoomUid+"번방의 의 랜덤 왕이 "+randomKingUser.getNickname()+"으로 선정됨.");
	}
}
