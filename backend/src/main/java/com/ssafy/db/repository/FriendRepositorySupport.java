package com.ssafy.db.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.db.entity.User;
import com.ssafy.db.qentity.QUser;

@Repository
public class FriendRepositorySupport {
	@Autowired
	private JPAQueryFactory jpaQueryFactory;
	QUser quser = QUser.user;

	public List<User> findUserUidByNickname(String nickname1, String nickname2) {
		List<User> users = jpaQueryFactory.select(Projections.fields(com.ssafy.db.entity.User.class, quser.uid.as("uid")))
				.from(quser).where(quser.nickname.eq(nickname1).or(quser.nickname.eq(nickname2)))
				.fetch();
		return users;

	}
}
