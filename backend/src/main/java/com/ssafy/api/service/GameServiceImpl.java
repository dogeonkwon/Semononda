package com.ssafy.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ssafy.api.request.UserRegisterPostReq;
import com.ssafy.db.entity.Player;
import com.ssafy.db.entity.User;
import com.ssafy.db.repository.PlayerRepository;
import com.ssafy.db.repository.PlayerRepositorySupport;
import com.ssafy.db.repository.UserRepository;
import com.ssafy.db.repository.UserRepositorySupport;

/**
 *	유저 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */
@Service("gameService")
public class GameServiceImpl implements GameService {
	@Autowired
	PlayerRepository playerRepository;
	
	@Autowired
	PlayerRepositorySupport playerRepositorySupport;

	@Override
	public Player getPlayerByUserId(String userId) {
		// TODO Auto-generated method stub
		Player player = playerRepositorySupport.findPlayerByUserId(userId).get();
		return player;
	}
}
