package com.ssafy.db.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * 유저 모델 정의.
 */
@Entity
@Getter
@Setter
@Table(name = "boards")
public class Board extends BaseEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int uid;

	@Id
	String nickname;

	@Column(name = "category_large")
	int categoryLarge;

	@Column(name = "category_middle")
	int categoryMiddle;

	String title;

	String content;

	@Column(name = "reg_time")
	Date regTime;

	@Column(name = "view_count")
	int viewCount;
	String img;
}
