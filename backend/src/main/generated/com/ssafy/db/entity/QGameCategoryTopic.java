package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGameCategoryTopic is a Querydsl query type for GameCategoryTopic
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGameCategoryTopic extends EntityPathBase<GameCategoryTopic> {

    private static final long serialVersionUID = -1214534531L;

    public static final QGameCategoryTopic gameCategoryTopic = new QGameCategoryTopic("gameCategoryTopic");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath answerA = createString("answerA");

    public final StringPath answerB = createString("answerB");

    public final NumberPath<Integer> categoryUid = createNumber("categoryUid", Integer.class);

    public final NumberPath<Integer> teamAWinCount = createNumber("teamAWinCount", Integer.class);

    public final NumberPath<Integer> teamBWinCount = createNumber("teamBWinCount", Integer.class);

    public final StringPath topic = createString("topic");

    public final NumberPath<Integer> uid = createNumber("uid", Integer.class);

    public QGameCategoryTopic(String variable) {
        super(GameCategoryTopic.class, forVariable(variable));
    }

    public QGameCategoryTopic(Path<? extends GameCategoryTopic> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGameCategoryTopic(PathMetadata metadata) {
        super(GameCategoryTopic.class, metadata);
    }

}

