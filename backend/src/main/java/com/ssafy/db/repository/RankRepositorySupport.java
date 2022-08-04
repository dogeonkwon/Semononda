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
		System.err.println("여기는????????");
		List<User> users = jpaQueryFactory.select(quser).from(quser).fetch();
		System.err.println("쿼리가 이상한가????????");
		return users;

	}

	public List<User> findUserListOfWeek() {
		return null;

	}
}
