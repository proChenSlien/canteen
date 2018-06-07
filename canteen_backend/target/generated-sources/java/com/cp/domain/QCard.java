package com.cp.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCard is a Querydsl query type for Card
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCard extends EntityPathBase<Card> {

    private static final long serialVersionUID = 1175222822L;

    public static final QCard card = new QCard("card");

    public final StringPath bgImgUrl = createString("bgImgUrl");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final NumberPath<Integer> type = createNumber("type", Integer.class);

    public final DateTimePath<java.util.Date> updateTime = createDateTime("updateTime", java.util.Date.class);

    public QCard(String variable) {
        super(Card.class, forVariable(variable));
    }

    public QCard(Path<? extends Card> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCard(PathMetadata metadata) {
        super(Card.class, metadata);
    }

}

