package com.ssafy.db.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import javax.persistence.*;
/**
 * 유저 모델 정의.
 */
@Entity
@Getter
@Setter
@Table(name = "game_records")
public class GameRecord extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int uid;
	
	@Column(name="player_id")
	String playerId;
	
	@Column(name="total_goldfinch")
	int totalGoldfinch;
	
	@Column(name="is_winner")
	boolean isWinner;
	
	@Column(name="game_conference_room_uid")
	int gameConferenceRoomUid;
	
	int subject;
	
	@Column(name="start_time")
	Date startTime;
	
	@Column(name="end_time")
	Date endTime;
}
