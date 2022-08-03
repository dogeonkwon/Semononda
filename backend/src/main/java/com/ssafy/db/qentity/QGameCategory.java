package com.ssafy.db.qentity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;
import com.ssafy.db.entity.GameCategory;
import com.ssafy.db.entity.User;
import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGameCategory extends EntityPathBase<GameCategory> {

	private static final long serialVersionUID = 846542477L;
<<<<<<< HEAD
	public static final QGameCategory gameCategory = new QGameCategory("gameCategory");
=======
>>>>>>> branch 'feature/front/waiting-room' of https://lab.ssafy.com/s07-webmobile1-sub2/S07P12E103.git

	public final NumberPath<Integer> uid = createNumber("uid", Integer.class);

	public final StringPath subject = createString("subject");

	public final NumberPath<Integer> subjectCount = createNumber("subjectCount", Integer.class);

	public final StringPath subjectImg = createString("subjectImg");

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
