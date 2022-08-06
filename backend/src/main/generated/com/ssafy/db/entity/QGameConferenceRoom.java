package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGameConferenceRoom is a Querydsl query type for GameConferenceRoom
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGameConferenceRoom extends EntityPathBase<GameConferenceRoom> {

    private static final long serialVersionUID = 245621739L;

    public static final QGameConferenceRoom gameConferenceRoom = new QGameConferenceRoom("gameConferenceRoom");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath conferenceRoomUrl = createString("conferenceRoomUrl");

    public final StringPath customAnswerA = createString("customAnswerA");

    public final StringPath customAnswerB = createString("customAnswerB");

    public final StringPath customPassword = createString("customPassword");

    public final StringPath customTopic = createString("customTopic");

    public final DateTimePath<java.util.Date> endTime = createDateTime("endTime", java.util.Date.class);

    public final NumberPath<Integer> gameCategoriesUid = createNumber("gameCategoriesUid", Integer.class);

    public final NumberPath<Integer> gameCategoryTopicsUid = createNumber("gameCategoryTopicsUid", Integer.class);

    public final BooleanPath gameStart = createBoolean("gameStart");

    public final BooleanPath normal = createBoolean("normal");

    public final NumberPath<Integer> roomAdminUserUid = createNumber("roomAdminUserUid", Integer.class);

    public final DateTimePath<java.util.Date> startTime = createDateTime("startTime", java.util.Date.class);

    public final StringPath title = createString("title");

    public final NumberPath<Integer> uid = createNumber("uid", Integer.class);

    public QGameConferenceRoom(String variable) {
        super(GameConferenceRoom.class, forVariable(variable));
    }

    public QGameConferenceRoom(Path<? extends GameConferenceRoom> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGameConferenceRoom(PathMetadata metadata) {
        super(GameConferenceRoom.class, metadata);
    }

}

