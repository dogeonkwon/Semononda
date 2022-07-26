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
public class Board extends BaseEntity{
	int uid;
	int categoryLarge;
	int categoryMiddle;
	String title;
	String content;
	String nickname;
	Date regTime;
	int viewCount;
	String img;
}
