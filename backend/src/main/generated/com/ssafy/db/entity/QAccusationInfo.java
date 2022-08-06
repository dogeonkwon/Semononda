package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAccusationInfo is a Querydsl query type for AccusationInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAccusationInfo extends EntityPathBase<AccusationInfo> {

    private static final long serialVersionUID = 950284678L;

    public static final QAccusationInfo accusationInfo1 = new QAccusationInfo("accusationInfo1");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath accusationInfo = createString("accusationInfo");

    public final NumberPath<Integer> uid = createNumber("uid", Integer.class);

    public QAccusationInfo(String variable) {
        super(AccusationInfo.class, forVariable(variable));
    }

    public QAccusationInfo(Path<? extends AccusationInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAccusationInfo(PathMetadata metadata) {
        super(AccusationInfo.class, metadata);
    }

}

