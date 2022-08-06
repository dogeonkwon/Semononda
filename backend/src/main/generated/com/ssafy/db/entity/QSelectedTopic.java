package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSelectedTopic is a Querydsl query type for SelectedTopic
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSelectedTopic extends EntityPathBase<SelectedTopic> {

    private static final long serialVersionUID = 605094610L;

    public static final QSelectedTopic selectedTopic = new QSelectedTopic("selectedTopic");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final NumberPath<Integer> gameCategoryTopicsUid = createNumber("gameCategoryTopicsUid", Integer.class);

    public final NumberPath<Integer> gameConferenceRoomUid = createNumber("gameConferenceRoomUid", Integer.class);

    public final NumberPath<Integer> uid = createNumber("uid", Integer.class);

    public QSelectedTopic(String variable) {
        super(SelectedTopic.class, forVariable(variable));
    }

    public QSelectedTopic(Path<? extends SelectedTopic> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSelectedTopic(PathMetadata metadata) {
        super(SelectedTopic.class, metadata);
    }

}

