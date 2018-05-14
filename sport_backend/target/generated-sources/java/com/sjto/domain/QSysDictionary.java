package com.sjto.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSysDictionary is a Querydsl query type for SysDictionary
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSysDictionary extends EntityPathBase<SysDictionary> {

    private static final long serialVersionUID = 512762536L;

    public static final QSysDictionary sysDictionary = new QSysDictionary("sysDictionary");

    public final NumberPath<Long> groupId = createNumber("groupId", Long.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> orderNum = createNumber("orderNum", Integer.class);

    public final StringPath remark = createString("remark");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath val = createString("val");

    public QSysDictionary(String variable) {
        super(SysDictionary.class, forVariable(variable));
    }

    public QSysDictionary(Path<? extends SysDictionary> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSysDictionary(PathMetadata metadata) {
        super(SysDictionary.class, metadata);
    }

}

