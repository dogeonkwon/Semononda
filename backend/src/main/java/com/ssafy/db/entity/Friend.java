package com.ssafy.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 유저 모델 정의.
 */
@Entity
@Getter
@Setter
@Table(name="friends")
public class Friend extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int uid;
	
	@Column(name="friend_requester_uid")
	int friendRequesterUid;
	@Column(name="friend_receiver_uid")
	int friendReceiverUid;
}
