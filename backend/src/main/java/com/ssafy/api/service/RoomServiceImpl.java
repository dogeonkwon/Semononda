package com.ssafy.api.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.api.request.RoomRequest;
import com.ssafy.db.entity.GameConferenceRoom;
import com.ssafy.db.repository.RoomRepository;
import com.ssafy.db.repository.RoomRepositorySupport;

/**
 * 
 * @packageName : com.ssafy.api.service
 * @fileName : RoomServiceImpl.java
 * @author : 김유정
 * @date : 2022.08.01
 * @description :
 */
@Service("roomService")
public class RoomServiceImpl implements RoomService {
	@Autowired
	RoomRepository roomRepository;

	@Autowired
	RoomRepositorySupport roomRepositorySupport;

	@Override
	public GameConferenceRoom createRoom(RoomRequest roomRegisterInfo) {
		GameConferenceRoom room = new GameConferenceRoom();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());

		room.setNormal(roomRegisterInfo.isNormal());
		room.setGameCategoriesUid(roomRegisterInfo.getGameCategoriesUid());
		room.setGameCategoryTopicsUid(roomRegisterInfo.getGameCategoryTopicsUid());
		room.setRoomAdminUserUid(roomRegisterInfo.getRoomAdminUserUid());
		room.setConferenceRoomUrl(roomRegisterInfo.getConferenceRoomUrl());
		room.setStartTime(timestamp);
		room.setCustomPassword(roomRegisterInfo.getCustomPassword());
		room.setTitle(roomRegisterInfo.getTitle());
		room.setCustomTopic(roomRegisterInfo.getCustomTopic());
		room.setCustomAnswerA(roomRegisterInfo.getCustomAnswerA());
		room.setCustomAnswerB(roomRegisterInfo.getCustomAnswerB());
		room.setGameStart(roomRegisterInfo.isGameStart());
		return roomRepository.save(room);

	}

	@Override
	public List<GameConferenceRoom> findRoomByRoomTitle(String title) {
		System.err.println("ServiceImpl : " + title);
		return roomRepositorySupport.findRoomByTitle(title);
	}

//	@Override
//	public List<GameConferenceRoom> findNormalRoomlist() {
//		return roomRepository.findAll();
//	}

	@Override
	public List<GameConferenceRoom> findNormalRoomlist() {
		System.err.println("여기까지 오는가");
		return roomRepositorySupport.findNormalRoomlist();
	}
	
	@Override
	public List<GameConferenceRoom> findCustomRoomlist() {
		return roomRepositorySupport.findCustomRoomlist();
	}

	@Override
	public GameConferenceRoom updateRoom(GameConferenceRoom room, RoomRequest roomRegisterInfo) {
		room.setGameCategoriesUid(roomRegisterInfo.getGameCategoriesUid());
		room.setCustomPassword(roomRegisterInfo.getCustomPassword());
		room.setCustomTopic(roomRegisterInfo.getCustomTopic());
		room.setCustomAnswerA(roomRegisterInfo.getCustomAnswerA());
		room.setCustomAnswerB(roomRegisterInfo.getCustomAnswerB());
		room.setGameStart(roomRegisterInfo.isGameStart());
		return roomRepository.save(room);
	}

	@Override
	public GameConferenceRoom findRoomByUid(int uid) {
		GameConferenceRoom room = new GameConferenceRoom();
		room = roomRepositorySupport.findRoomByUid(uid);
		return room;
	}

	@Override
	public void deleteRoomByUid(GameConferenceRoom room) {
		roomRepository.delete(room);

	}

	@Override
	public List<GameConferenceRoom> findNormalRoomByRoomTitle(String title) {
		System.err.println("Normal ServiceImpl title: " + title);
		return roomRepositorySupport.findNormalRoomByTitle(title);
	}

	@Override
	public List<GameConferenceRoom> findCustomRoomByRoomTitle(String title) {
		System.err.println("custom ServiceImpl title: " + title);
		return roomRepositorySupport.findCustomRoomByTitle(title);
	}

}
