package com.ssafy.api.service;

import java.util.List;

import com.ssafy.db.entity.User;

public interface FriendService {
//	User findUserUidByNickname(String nickname);
	List<User> findUserUidByNickname(String nickname1, String nickname2);
	void AddFriend(int friendRequesterUid, int friendReceiverUid);
}
