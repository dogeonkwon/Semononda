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
public class GameRecord extends BaseEntity{
	int uid;
	String playerId;
	int totalGoldfinch;
	boolean isWinner;
	int gameConferenceRoomUid;
	int subject;
	Date startTime;
	Date endTime;
}
