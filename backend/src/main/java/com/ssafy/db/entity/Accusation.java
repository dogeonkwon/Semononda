package com.ssafy.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

/**
 * 유저 모델 정의.
 */
@Entity
@Getter
@Setter
public class Accusation extends BaseEntity{
	int uid;
	int accusationInfosUid;
	String reporterNickname;
	String attackerNickname;
}
