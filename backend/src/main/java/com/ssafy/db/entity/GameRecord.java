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
	
<<<<<<< HEAD
	@Column(name="user_uid")
	int userUid;
	
=======
>>>>>>> branch 'feature/front/waiting-room' of https://lab.ssafy.com/s07-webmobile1-sub2/S07P12E103.git
	@Column(name="player_uid")
	int playerUid;
	
	@Column(name="total_goldfinch")
	int totalGoldfinch;
	
	@Column(name="is_winner")
	boolean isWinner;
	
	@Column(name="game_conference_room_uid")
	int gameConferenceRoomUid;
	
	@Column(name="game_category_topics_uid")
	int gameCategoryTopicsUid;
	
	@Column(name="start_time")
	Date startTime;
	
	@Column(name="end_time")
	Date endTime;
}
