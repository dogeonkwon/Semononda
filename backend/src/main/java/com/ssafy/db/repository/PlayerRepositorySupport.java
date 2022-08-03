package com.ssafy.db.repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import javax.persistence.criteria.CriteriaBuilder.Case;
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
		Player player = jpaQueryFactory.select(qPlayer).from(qPlayer).where(qPlayer.usersUid.eq(userUid)).fetchOne();
		if (player == null)
			return Optional.empty();
		return Optional.ofNullable(player);
	}

	@Transactional
	public void changePlayerReadyByUserId(String userId) {
		long userUid = jpaQueryFactory.select(qUser.uid).from(qUser).where((qUser.id).eq(userId)).fetchOne();
		Player player = jpaQueryFactory.select(qPlayer).from(qPlayer).where(qPlayer.usersUid.eq(userUid)).fetchOne();
		jpaQueryFactory.update(qPlayer)
				.set(qPlayer.readyState, jpaQueryFactory.select(qPlayer.readyState).from(qPlayer)
						.where(qPlayer.usersUid.eq(userUid)).fetchOne() ? false : true)
				.where(qPlayer.usersUid.eq(userUid)).execute();
	}

	@Transactional
	public void gameStart(int gameConferenceRoomUid) {
		jpaQueryFactory.update(qGameConferenceRoom).set(qGameConferenceRoom.gameStart, true)
				.where(qGameConferenceRoom.uid.eq(3)).execute();
		GameConferenceRoom g = jpaQueryFactory.selectFrom(qGameConferenceRoom)
				.where(qGameConferenceRoom.uid.eq(gameConferenceRoomUid)).fetchFirst();
		System.out.println("UID " + g.getUid() + "번방 게임 시작");
		System.out.println("방제목: " + g.getTitle());
	}

	@Transactional
	public void changePenalty(int gameConferenceRoomUid, String userID, int penalty) {// penalty 0:스피커, 1:카메라, 2:음성변조
		long userUid = jpaQueryFactory.select(qUser.uid).from(qUser).where((qUser.id).eq(userID)).fetchOne();
		Player player = jpaQueryFactory.selectFrom(qPlayer).where(qPlayer.usersUid.eq(userUid)).fetchOne();
		switch (penalty) {//제한 내용에 따른 스위치 문
		case 0:
			//이전 제한 여부
			boolean beforeMuted = jpaQueryFactory.select(qPlayer.isMuted).from(qPlayer)
					.where(qPlayer.usersUid.eq(userUid)).fetchOne();
			//제한 여부 변경
			jpaQueryFactory.update(qPlayer).set(qPlayer.isMuted, beforeMuted ? false : true)
					.where(qPlayer.usersUid.eq(userUid)).execute();
			//로그 츨력
			if (beforeMuted)
				System.out.println("아이디 " + userID + "음소거 해제 됨");
			else
				System.out.println("아이디 " + userID + "음소거 됨");
			break;
		case 1:
			//이전 제한 여부
			boolean beforeCamOff = jpaQueryFactory.select(qPlayer.isCamOff).from(qPlayer)
					.where(qPlayer.usersUid.eq(userUid)).fetchOne();
			//제한 여부 변경
			jpaQueryFactory.update(qPlayer).set(qPlayer.isCamOff, beforeCamOff ? false : true)
					.where(qPlayer.usersUid.eq(userUid)).execute();
			//로그 츨력
			if (beforeCamOff)
				System.out.println("아이디 " + userID + "카메라 제한 해제 됨");
			else
				System.out.println("아이디 " + userID + "카메라 제한 됨");
			break;
		default:
			//이전 제한 여부
			boolean beforeChangeVoice = jpaQueryFactory.select(qPlayer.isChangeVoice).from(qPlayer)
					.where(qPlayer.usersUid.eq(userUid)).fetchOne();
			//제한 여부 변경
			jpaQueryFactory.update(qPlayer).set(qPlayer.isChangeVoice, beforeChangeVoice ? false : true)
					.where(qPlayer.usersUid.eq(userUid)).execute();
			//로그 츨력
			if (beforeChangeVoice)
				System.out.println("아이디 " + userID + "음성 변조 해제 됨");
			else
				System.out.println("아이디 " + userID + "음성 변조 됨");
			break;
		}
		jpaQueryFactory.update(qPlayer)
				.set(qPlayer.readyState, jpaQueryFactory.select(qPlayer.readyState).from(qPlayer)
						.where(qPlayer.usersUid.eq(userUid)).fetchOne() ? false : true)
				.where(qPlayer.usersUid.eq(userUid)).execute();
	} 

	@Transactional
	public void makeRandomKing(int gameConferenceRoomUid) {
		Random random = new Random();
		ArrayList<Player> playerList = new ArrayList();
		// 해당 게임에 참가중이면서 왕을 안 해본 플레이어 리스트
		playerList = (ArrayList<Player>) jpaQueryFactory.select(qPlayer).from(qPlayer)
				.where(qPlayer.gameConferenceRoomUid.eq((long) gameConferenceRoomUid))
				.where(qPlayer.randomKing.isFalse()).fetchResults().getResults();
		// 랜덤 왕의 인덱스
		int randomIndex = random.nextInt(playerList.size());
		// 랜덤 왕
		Player randomKingPlayer = playerList.get(randomIndex);
		// 왕이된 플레이어의 randomKing true
		jpaQueryFactory.update(qPlayer).set(qPlayer.randomKing, true)
				.where(qPlayer.usersUid.eq((long) randomKingPlayer.getUsersUid())).execute();
		// 모든 플레이어 역할 신하(2)으로 초기화
		jpaQueryFactory.update(qPlayer).set(qPlayer.roleUid, (long) 2)
				.where(qPlayer.gameConferenceRoomUid.eq((long) gameConferenceRoomUid)).execute();
		// 랜덤 왕 역할을 왕(1)으로 설정
		jpaQueryFactory.update(qPlayer).set(qPlayer.roleUid, (long) 1)
				.where(qPlayer.usersUid.eq((long) randomKingPlayer.getUsersUid())).execute();
		// 랜덤 왕을 맡은 유저 정보
		User randomKingUser = jpaQueryFactory.selectFrom(qUser).where(qUser.uid.eq(randomKingPlayer.getUsersUid()))
				.fetchOne();
		// 서버 로그 출력
		System.out.println("UID" + gameConferenceRoomUid + "번방의 의 랜덤 왕이 " + randomKingUser.getNickname() + "으로 선정됨.");
	}

	@Transactional
	public void makeRandomTeam(int gameConferenceRoomUid) {
		Random random = new Random();
		ArrayList<Player> playerList = new ArrayList();
		// 해당 게임에 참가중이면서 신하인 플레이어 리스트
		playerList = (ArrayList<Player>) jpaQueryFactory.select(qPlayer).from(qPlayer)
				.where(qPlayer.gameConferenceRoomUid.eq((long) gameConferenceRoomUid))
				.where(qPlayer.roleUid.eq((long) 2)).fetchResults().getResults();
		// 신하의 수
		int playerNum = playerList.size();
		// 각 진영 별 인원수
		int teamACount = playerNum / 2;
		int teamBCount = playerNum / 2;
		// 신하가 홀수일 시 한 명을 랜덤으로 배정
		if (playerNum % 2 != 0) {
			int randomAB = random.nextInt(2);
			if (randomAB == 0) {
				teamACount += 1;
			} else {
				teamBCount += 1;
			}
		}
		// 모든 신하의 팀 A로 설정
		jpaQueryFactory.update(qPlayer).set(qPlayer.team, "A")
				.where(qPlayer.gameConferenceRoomUid.eq((long) gameConferenceRoomUid))
				.where(qPlayer.roleUid.eq((long) 2)).execute();
		// 선택 여부 표시를 위한 배열
		boolean selected[] = new boolean[playerNum];
		// B팀의 수만큼 랜덤으로 선택하여 배정
		for (int i = 0; i < teamBCount; i++) {
			while (true) {
				int randomIndex = random.nextInt(playerNum);
				if (!selected[randomIndex]) {
					jpaQueryFactory.update(qPlayer).set(qPlayer.team, "B")
							.where(qPlayer.gameConferenceRoomUid.eq((long) gameConferenceRoomUid))
							.where(qPlayer.roleUid.eq((long) 2))
							.where(qPlayer.uid.eq((long) playerList.get(randomIndex).getUid())).execute();
					selected[randomIndex] = true;
					break;
				}
			}
		}
		ArrayList<Integer> teamA = new ArrayList<>();
		ArrayList<Integer> teamB = new ArrayList<>();
		for (int i = 0; i < playerNum; i++) {
			if (!selected[i]) {
				teamA.add(i);
			} else {
				teamB.add(i);
			}
		}
		// 서버 로그 출력
		StringBuilder sb = new StringBuilder();
		sb.append("A팀: ");
		for (int i = 0; i < teamACount; i++) {
			User teamAUser = jpaQueryFactory.selectFrom(qUser)
					.where(qUser.uid.eq(playerList.get(teamA.get(i)).getUsersUid())).fetchOne();
			sb.append(teamAUser.getNickname());
			sb.append(", ");
		}
		sb.setLength(sb.length() - 2);
		sb.append("\n");
		sb.append("B팀: ");
		for (int i = 0; i < teamBCount; i++) {
			User teamBUser = jpaQueryFactory.selectFrom(qUser)
					.where(qUser.uid.eq(playerList.get(teamB.get(i)).getUsersUid())).fetchOne();
			sb.append(teamBUser.getNickname());
			sb.append(", ");
		}
		sb.setLength(sb.length() - 2);
		sb.append("\n");
		System.out.println(sb);
	}

}
