package com.ssafy.db.repository;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;

import javax.transaction.Transactional;

import org.checkerframework.checker.units.qual.radians;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.db.entity.GameCategoryTopic;
import com.ssafy.db.entity.GameConferenceRoom;
import com.ssafy.db.entity.Player;
import com.ssafy.db.entity.SelectedTopic;
import com.ssafy.db.entity.User;
import com.ssafy.db.qentity.QGameCategoryTopic;
import com.ssafy.db.qentity.QGameConferenceRoom;
import com.ssafy.db.qentity.QPlayer;
import com.ssafy.db.qentity.QSelectedTopic;
import com.ssafy.db.qentity.QUser;

/**
 * 유저 모델 관련 디비 쿼리 생성을 위한 구현 정의.
 */
@Repository
public class PlayerRepositorySupport {
	@Autowired
	private SelectedTopicRepository selectedTopicRepository;
	
	@Autowired
	private JPAQueryFactory jpaQueryFactory;
	QPlayer qPlayer = QPlayer.player;
	QUser qUser = QUser.user;
	QGameConferenceRoom qGameConferenceRoom = QGameConferenceRoom.gameConferenceRoom;
	QGameCategoryTopic qGameCategoryTopic = QGameCategoryTopic.gameCategoryTopic;
	QSelectedTopic qSelectedTopic = QSelectedTopic.selectedTopic;

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
				.where(qGameConferenceRoom.uid.eq(gameConferenceRoomUid)).execute();
		GameConferenceRoom g = jpaQueryFactory.selectFrom(qGameConferenceRoom)
				.where(qGameConferenceRoom.uid.eq(gameConferenceRoomUid)).fetchFirst();
		System.out.println("UID " + g.getUid() + "번방 게임 시작");
		System.out.println("방제목: " + g.getTitle());
	}

	@Transactional
	public void changePenalty(int gameConferenceRoomUid, String userID, int penalty) {// penalty 0:스피커, 1:카메라, 2:음성변조
		long userUid = jpaQueryFactory.select(qUser.uid).from(qUser).where((qUser.id).eq(userID)).fetchOne();
		Player player = jpaQueryFactory.selectFrom(qPlayer).where(qPlayer.usersUid.eq(userUid)).fetchOne();
		switch (penalty) {// 제한 내용에 따른 스위치 문
		case 0:
			// 이전 제한 여부
			boolean beforeMuted = jpaQueryFactory.select(qPlayer.isMuted).from(qPlayer)
					.where(qPlayer.usersUid.eq(userUid)).fetchOne();
			// 제한 여부 변경
			jpaQueryFactory.update(qPlayer).set(qPlayer.isMuted, beforeMuted ? false : true)
					.where(qPlayer.usersUid.eq(userUid)).execute();
			// 로그 츨력
			if (beforeMuted)
				System.out.println("아이디 " + userID + "음소거 해제 됨");
			else
				System.out.println("아이디 " + userID + "음소거 됨");
			break;
		case 1:
			// 이전 제한 여부
			boolean beforeCamOff = jpaQueryFactory.select(qPlayer.isCamOff).from(qPlayer)
					.where(qPlayer.usersUid.eq(userUid)).fetchOne();
			// 제한 여부 변경
			jpaQueryFactory.update(qPlayer).set(qPlayer.isCamOff, beforeCamOff ? false : true)
					.where(qPlayer.usersUid.eq(userUid)).execute();
			// 로그 츨력
			if (beforeCamOff)
				System.out.println("아이디 " + userID + "카메라 제한 해제 됨");
			else
				System.out.println("아이디 " + userID + "카메라 제한 됨");
			break;
		default:
			// 이전 제한 여부
			boolean beforeChangeVoice = jpaQueryFactory.select(qPlayer.isChangeVoice).from(qPlayer)
					.where(qPlayer.usersUid.eq(userUid)).fetchOne();
			// 제한 여부 변경
			jpaQueryFactory.update(qPlayer).set(qPlayer.isChangeVoice, beforeChangeVoice ? false : true)
					.where(qPlayer.usersUid.eq(userUid)).execute();
			// 로그 츨력
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
		jpaQueryFactory.update(qPlayer).set(qPlayer.roleUid, (long) 1).set(qPlayer.goldfinch, (long) 0)
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

	@Transactional
	public GameCategoryTopic getRoundStart(int gameConferenceRoomUid) {
		Random random = new Random();
		ArrayList<Player> playerList = new ArrayList();
		ArrayList<GameCategoryTopic> topicList = new ArrayList();
		ArrayList<Integer> selectedList = new ArrayList<>();
		int categoryUid = jpaQueryFactory.select(qGameConferenceRoom.gameCategoriesUid).from(qGameConferenceRoom)
				.where(qGameConferenceRoom.uid.eq(gameConferenceRoomUid)).fetchOne();
		// 해당 게임에 참가중인 플레이어 리스트
		playerList = (ArrayList<Player>) jpaQueryFactory.select(qPlayer).from(qPlayer)
				.where(qPlayer.gameConferenceRoomUid.eq((long) gameConferenceRoomUid)).fetchResults().getResults();
		// 모든 플레이어 제한 풀기
		jpaQueryFactory.update(qPlayer).set(qPlayer.isCamOff, false).set(qPlayer.isMuted, false)
				.set(qPlayer.isChangeVoice, false).where(qPlayer.gameConferenceRoomUid.eq((long) gameConferenceRoomUid))
				.execute();
		// 현재 카테고리의 토픽 리스트
		topicList = (ArrayList<GameCategoryTopic>) jpaQueryFactory.selectFrom(qGameCategoryTopic)
				.where(qGameCategoryTopic.categoryUid.eq(categoryUid)).fetchResults().getResults();
		// 현재 게임 방이 했었던 주제들
		if (jpaQueryFactory.select(qSelectedTopic.gameCategoryTopicsUid).from(qSelectedTopic)
				.where(qSelectedTopic.gameConferenceRoomUid.eq(gameConferenceRoomUid)).fetchCount() != 0)
			selectedList = (ArrayList<Integer>) jpaQueryFactory.select(qSelectedTopic.gameCategoryTopicsUid)
					.from(qSelectedTopic).where(qSelectedTopic.gameConferenceRoomUid.eq(gameConferenceRoomUid))
					.fetchResults().getResults();
		GameCategoryTopic randomTopic = topicList.get(0);
		// 남은 주제가 없을 떄
		if(topicList.size()==selectedList.size()) {
			System.out.println("남은 주제 없음!!");
//			주제 없을 시 db의 selected topic 리셋
			jpaQueryFactory.delete(qSelectedTopic).where(qSelectedTopic.gameConferenceRoomUid.eq(gameConferenceRoomUid)).execute();
			System.out.println("루프");
		}
		for(int i=0; i<topicList.size(); i++) {
			int randomIndex = random.nextInt(topicList.size());
			// 랜덤 토픽
			randomTopic = topicList.get(randomIndex);
			// 선택된 토픽과 겹치지 않을 때
			if (!selectedList.contains(randomTopic.getUid())) {
				// selectedTopic table에 추가
				SelectedTopic selectedTopic = new SelectedTopic();
				selectedTopic.setGameCategoryTopicsUid(randomTopic.getUid());
				selectedTopic.setGameConferenceRoomUid(gameConferenceRoomUid);
				selectedTopicRepository.save(selectedTopic);
				// 현재 게임 컨퍼런스룸의 주제 uid 변경
				jpaQueryFactory.update(qGameConferenceRoom)
						.set(qGameConferenceRoom.gameCategoryTopicsUid, randomTopic.getUid())
						.where(qGameConferenceRoom.uid.eq(gameConferenceRoomUid)).execute();
				System.out.println(gameConferenceRoomUid+"번방의 주제가 "+randomTopic.getTopic()+" \""+randomTopic.getAnswerA()+"\" VS \""+randomTopic.getAnswerB()+"\"(으)로 변경되었습니다.");
				break;
			}
		}
		return randomTopic;
	}
	

}
