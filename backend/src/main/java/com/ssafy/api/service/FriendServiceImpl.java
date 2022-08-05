package com.ssafy.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.db.entity.User;
import com.ssafy.db.repository.FriendRepository;
import com.ssafy.db.repository.FriendRepositorySupport;

@Service("friendService")
public class FriendServiceImpl implements FriendService {
	@Autowired
	FriendRepository friendRepository;

	@Autowired
	FriendRepositorySupport friendRepositorySupport;

//	@Override
//	public User findUserUidByNickname(String nickname) {
//		return friendRepositorySupport.findUserUidByNickname(nickname);
//	}

	@Override
	public void AddFriend(int friendRequesterUid, int friendReceiverUid) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<User> findUserUidByNickname(String nickname1, String nickname2) {
		return friendRepositorySupport.findUserUidByNickname(nickname1, nickname2);
	}

}
