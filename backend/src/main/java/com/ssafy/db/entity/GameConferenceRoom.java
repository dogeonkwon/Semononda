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
public class GameConferenceRoom extends BaseEntity{
	int uid;
	boolean isNormal;
	int subject;
	Date startTime;
	Date endTime;
	int customPassword;
	String roomAdmin;
	String title;
	String customTopicA;
	String customTopicB;
	int gameCategoryTopicsUid;
}
