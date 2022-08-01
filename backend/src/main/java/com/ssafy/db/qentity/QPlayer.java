package com.ssafy.db.qentity;

import static com.querydsl.core.types.PathMetadataFactory.forVariable;

import javax.annotation.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.BooleanPath;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.NumberPath;
import com.querydsl.core.types.dsl.StringPath;
import com.ssafy.db.entity.Player;

/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPlayer extends EntityPathBase<Player> {

	private static final long serialVersionUID = 846542478L;

	public static final QPlayer player = new QPlayer("player");

	public final QBaseEntity _super = new QBaseEntity(this);

	// inherited
	public final NumberPath<Long> uid = createNumber("uid", Long.class);

	public final NumberPath<Long> usersUid = createNumber("usersUid", Long.class);

	public final NumberPath<Long> gameConferenceRoomUid = createNumber("gameConferenceRoomUid", Long.class);

	public final NumberPath<Long> goldfinch = createNumber("goldfinch", Long.class);
	public final NumberPath<Long> roleUid = createNumber("roleUid", Long.class);


	public final NumberPath<Long> kingCount = createNumber("kingCount", Long.class);

	public final StringPath team = createString("team");

	public final NumberPath<Long> accusationCount = createNumber("accusationCount", Long.class);

	public final NumberPath<Long> totalGoldfinch = createNumber("totalGoldfinch", Long.class);

	public final BooleanPath randomKing = createBoolean("randomKing");

	public final BooleanPath readyState = createBoolean("readyState");

	public QPlayer(String variable) {
		super(Player.class, forVariable(variable));
	}

	public QPlayer(Path<? extends Player> path) {
		super(path.getType(), path.getMetadata());
	}

	public QPlayer(PathMetadata metadata) {
		super(Player.class, metadata);
	}

}
