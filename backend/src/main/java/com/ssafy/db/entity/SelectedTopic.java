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
<<<<<<< HEAD
@Table(name="selected_topics")
public class SelectedTopic extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int uid;
	
	@Column(name="game_conference_rooms_uid")
=======
@Table(name="selected_topic")
public class SelectedTopic extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int uid;
	
	@Column(name="game_conference_room_uid")
>>>>>>> branch 'feature/front/waiting-room' of https://lab.ssafy.com/s07-webmobile1-sub2/S07P12E103.git
	int gameConferenceRoomUid;
	
	@Column(name="game_category_topics_uid")
	int gameCategoryTopicsUid;
}
