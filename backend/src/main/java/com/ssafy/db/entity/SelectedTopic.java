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
public class SelectedTopic extends BaseEntity{
	int uid;
	int gameConferenceRoomUid;
	int gameCategoryTopicsUid;
	boolean isSelected;
}
