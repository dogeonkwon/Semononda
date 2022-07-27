package com.ssafy.db.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.*;
/**
 * 유저 모델 정의.
 */
@Entity
@Getter
@Setter
@Table(name="game_category_topics")
public class GameCategoryTopics extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int uid;
	
	@Column(name="category")
	int category;
	
	@Column(name="topic_A")
	String topicA;
	
	@Column(name="topic_B")
	String topicB;
	
	@Column(name="team_A_win_count")
	int teamAWinCount;
	
	@Column(name="team_B_win_count")
	int teamBWinCount;
}
