package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGameCategory is a Querydsl query type for GameCategory
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGameCategory extends EntityPathBase<GameCategory> {

    private static final long serialVersionUID = 1148437458L;

    public static final QGameCategory gameCategory = new QGameCategory("gameCategory");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath subject = createString("subject");

    public final NumberPath<Integer> subjectCount = createNumber("subjectCount", Integer.class);

    public final StringPath subjectImg = createString("subjectImg");

    public final NumberPath<Integer> uid = createNumber("uid", Integer.class);

    public QGameCategory(String variable) {
        super(GameCategory.class, forVariable(variable));
    }

    public QGameCategory(Path<? extends GameCategory> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGameCategory(PathMetadata metadata) {
        super(GameCategory.class, metadata);
    }

}

