package com.ssafy.db.qentity;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

import java.util.Date;

import javax.annotation.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.BooleanPath;
import com.querydsl.core.types.dsl.DatePath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.ssafy.db.entity.GameConferenceRoom;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGameConferenceRoom extends EntityPathBase<GameConferenceRoom> {

    private static final long serialVersionUID = 846542477L;

	public final NumberPath<Integer> uid = createNumber("uid", Integer.class);

    public final BooleanPath isNormal = createBoolean("isNormal");

    public final NumberPath<Integer> subject = createNumber("subject",Integer.class);
    
	public final DatePath<Date> startTime = createDate("startTime", Date.class);

	public final DatePath<Date> endTime = createDate("endTime", Date.class);
    
	public final NumberPath<Integer> customPassword = createNumber("customPassword",Integer.class);
    public final StringPath roomAdmin = createString("roomAdmin");

    public final StringPath title = createString("title");

    public final StringPath customTopicA = createString("customTopicA");
    public final StringPath customTopicB = createString("customTopicB");
    public final NumberPath<Integer> gameCategoryTopicsUid = createNumber("gameCategoryTopicsUid",Integer.class);

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

