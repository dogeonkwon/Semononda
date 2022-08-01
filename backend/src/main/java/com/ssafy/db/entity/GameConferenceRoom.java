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
@Table(name="game_conference_rooms")
public class GameConferenceRoom extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int uid;
	
	@Column(name = "is_normal")
	boolean isNormal;
	

	int subject;
	
	@Column(name="start_time")
	Date startTime;
	
	@Column(name="end_time")
	Date endTime;
	
	@Column(name="custom_passworrd")
	int customPassword;
	
	@Column(name="room_admin")
	String roomAdmin;
	
	@Column(name="title")
	String title;
	
	@Column(name="custom_topic_A")
	String customTopicA;
	
	@Column(name="custom_topic_B")
	String customTopicB;
	
	@Column(name="game_category_topics_uid")
	int gameCategoryTopicsUid;
}
