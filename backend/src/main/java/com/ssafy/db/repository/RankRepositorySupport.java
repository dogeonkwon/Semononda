package com.ssafy.db.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.ssafy.db.entity.QUser;
import com.ssafy.db.entity.User;

@Repository
public class RankRepositorySupport {
	@Autowired
	private   JPAQueryFactory jpaQueryFactory;
	QUser quser = QUser.user;
	
	public  List<User> findUserListAll() {
		List<User> users = jpaQueryFactory.select(quser).from(quser).orderBy(quser.rankpoint.desc()).fetch();
		return users;

	}

	public List<User> findUserListOfWeek() {
		return null;

	}
}
