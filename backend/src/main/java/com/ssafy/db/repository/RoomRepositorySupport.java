package com.ssafy.db.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.api.request.RoomRequest;
import com.ssafy.db.entity.Board;
import com.ssafy.db.entity.GameConferenceRoom;
import com.ssafy.db.qentity.QGameConferenceRoom;

@Repository
public class RoomRepositorySupport {
	@Autowired
	private JPAQueryFactory jpaQueryFactory;
	QGameConferenceRoom qRoom = QGameConferenceRoom.gameConferenceRoom;

	public GameConferenceRoom findRoomByUid(int uid) {
		GameConferenceRoom room = jpaQueryFactory.select(qRoom).from(qRoom).where(qRoom.uid.eq(uid)).fetchOne();
		return room;

	}

	public List<GameConferenceRoom> findRoomByTitle(String word) {

		QGameConferenceRoom qRoom = QGameConferenceRoom.gameConferenceRoom;
		List<GameConferenceRoom> rooms = jpaQueryFactory.select(qRoom).from(qRoom)
				.where(qRoom.title.like("%" + word + "%")).fetch();
		return rooms;
	}
	
	public List<GameConferenceRoom> findNormalRoomlist() {
		System.err.println("여기는????????");
		List<GameConferenceRoom> rooms = jpaQueryFactory.select(qRoom).from(qRoom)
				.where(qRoom.normal.eq(true)).fetch();
		System.err.println("쿼리가 이상한가????????");
		return rooms;
	}
	
	
	public List<GameConferenceRoom> findCustomRoomlist() {
		List<GameConferenceRoom> rooms = jpaQueryFactory.select(qRoom).from(qRoom)
				.where(qRoom.normal.eq(false)).fetch();
		return rooms;
	}
	
	public List<GameConferenceRoom> findNormalRoomByTitle(String word) {

		QGameConferenceRoom qRoom = QGameConferenceRoom.gameConferenceRoom;
		List<GameConferenceRoom> rooms = jpaQueryFactory.select(qRoom).from(qRoom)
				.where(qRoom.title.like("%" + word + "%")).where(qRoom.normal.eq(true)).fetch();
		return rooms;
	}
	
	public List<GameConferenceRoom> findCustomRoomByTitle(String word) {

		QGameConferenceRoom qRoom = QGameConferenceRoom.gameConferenceRoom;
		List<GameConferenceRoom> rooms = jpaQueryFactory.select(qRoom).from(qRoom)
				.where(qRoom.title.like("%" + word + "%")).where(qRoom.normal.eq(false)).fetch();
		return rooms;
	}
	
	
//	//게임이 시작 되었는지 확인하는 메소드
//	@Transactional
//	public void gameStart(int gameConferenceRoomUid) {
//		jpaQueryFactory.update(qGameConferenceRoom).set(qGameConferenceRoom.gameStart, true)
//				.where(qGameConferenceRoom.uid.eq(3)).execute();
//		GameConferenceRoom g = jpaQueryFactory.selectFrom(qGameConferenceRoom)
//				.where(qGameConferenceRoom.uid.eq(gameConferenceRoomUid)).fetchFirst();
//		System.out.println("UID " + g.getUid() + "번방 게임 시작");
//		System.out.println("방제목: " + g.getTitle());
//	}

}
