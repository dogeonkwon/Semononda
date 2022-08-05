package com.ssafy.api.service;

import com.ssafy.db.entity.User;

public interface FriendService {
	User findUserUidByNickname(String nickname);
	void AddFriend(int friendRequesterUid, int friendReceiverUid);
}
