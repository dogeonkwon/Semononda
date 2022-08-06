package com.ssafy.db.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 846542477L;

    public static final QUser user = new QUser("user");

    public final QBaseEntity _super = new QBaseEntity(this);

    public final StringPath authority = createString("authority");

    public final ListPath<Board, QBoard> boardList = this.<Board, QBoard>createList("boardList", Board.class, QBoard.class, PathInits.DIRECT2);

    public final StringPath description = createString("description");

    public final StringPath id = createString("id");

    public final StringPath img = createString("img");

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final NumberPath<Integer> numberOfLoses = createNumber("numberOfLoses", Integer.class);

    public final NumberPath<Integer> numberOfWins = createNumber("numberOfWins", Integer.class);

    public final StringPath password = createString("password");

    public final StringPath phonenumber = createString("phonenumber");

    public final NumberPath<Integer> rankpoint = createNumber("rankpoint", Integer.class);

    public final NumberPath<Integer> uid = createNumber("uid", Integer.class);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

