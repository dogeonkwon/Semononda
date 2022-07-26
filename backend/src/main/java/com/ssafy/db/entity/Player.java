package com.ssafy.db.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import javax.persistence.Entity;

/**
 * 유저 모델 정의.
 */
@Entity
@Getter
@Setter
public class Player extends BaseEntity{
	int uid;
	int usersUid;
	int gameConferenceRoomUid;
	int goldfinch;
	String role;
	int kingCount;
	String team;
	int accusationCount;
	int totalGoldfinch;
	boolean randomKing;
	boolean readyState;
}
