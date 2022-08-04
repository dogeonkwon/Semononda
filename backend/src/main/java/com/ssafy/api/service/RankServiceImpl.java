package com.ssafy.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.db.entity.User;
import com.ssafy.db.repository.RankRepository;
import com.ssafy.db.repository.RankRepositorySupport;

@Service("rankUserListService")
public class RankServiceImpl implements RankService {
	@Autowired
	RankRepository rankUserListRepository;

	@Autowired
	RankRepositorySupport rankRepositorySupport;

	@Override
	public List<User> findUserListAll() {
		System.err.println("여기까지 오는가");
		return rankRepositorySupport.findUserListAll();
	}

	@Override
	public List<User> findUserListOfWeek() {
		// TODO Auto-generated method stub
		return null;
	}

}
