package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGameRecord is a Querydsl query type for GameRecord
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGameRecord extends EntityPathBase<GameRecord> {

    private static final long serialVersionUID = -768403419L;

    public static final QGameRecord gameRecord = new QGameRecord("gameRecord");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final DateTimePath<java.util.Date> endTime = createDateTime("endTime", java.util.Date.class);

    public final NumberPath<Integer> gameCategoryTopicsUid = createNumber("gameCategoryTopicsUid", Integer.class);

    public final NumberPath<Integer> gameConferenceRoomUid = createNumber("gameConferenceRoomUid", Integer.class);

    public final BooleanPath isWinner = createBoolean("isWinner");

    public final DateTimePath<java.util.Date> startTime = createDateTime("startTime", java.util.Date.class);

    public final NumberPath<Integer> totalGoldfinch = createNumber("totalGoldfinch", Integer.class);

    public final NumberPath<Integer> uid = createNumber("uid", Integer.class);

    public final NumberPath<Integer> userUid = createNumber("userUid", Integer.class);

    public QGameRecord(String variable) {
        super(GameRecord.class, forVariable(variable));
    }

    public QGameRecord(Path<? extends GameRecord> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGameRecord(PathMetadata metadata) {
        super(GameRecord.class, metadata);
    }

}

