package com.sjto.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QContentInfo is a Querydsl query type for ContentInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QContentInfo extends EntityPathBase<ContentInfo> {

    private static final long serialVersionUID = 1366438252L;

    public static final QContentInfo contentInfo = new QContentInfo("contentInfo");

    public final StringPath content = createString("content");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath type = createString("type");

    public QContentInfo(String variable) {
        super(ContentInfo.class, forVariable(variable));
    }

    public QContentInfo(Path<? extends ContentInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QContentInfo(PathMetadata metadata) {
        super(ContentInfo.class, metadata);
    }

}

