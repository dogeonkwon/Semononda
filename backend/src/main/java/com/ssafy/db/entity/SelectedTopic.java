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
@Table(name="selected_topic")
public class SelectedTopic extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int uid;
	
	@Column(name="game_conference_room_uid")
	int gameConferenceRoomUid;
	
	@Column(name="game_category_topics_uid")
	int gameCategoryTopicsUid;
	
	@Column(name="is_selected")
	boolean isSelected;
}
