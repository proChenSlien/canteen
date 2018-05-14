package com.sjto.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSysDictionaryGroup is a Querydsl query type for SysDictionaryGroup
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSysDictionaryGroup extends EntityPathBase<SysDictionaryGroup> {

    private static final long serialVersionUID = -1560195913L;

    public static final QSysDictionaryGroup sysDictionaryGroup = new QSysDictionaryGroup("sysDictionaryGroup");

    public final NumberPath<Long> groupId = createNumber("groupId", Long.class);

    public final StringPath groupName = createString("groupName");

    public final StringPath groupRemark = createString("groupRemark");

    public final NumberPath<Integer> orderNum = createNumber("orderNum", Integer.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public QSysDictionaryGroup(String variable) {
        super(SysDictionaryGroup.class, forVariable(variable));
    }

    public QSysDictionaryGroup(Path<? extends SysDictionaryGroup> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSysDictionaryGroup(PathMetadata metadata) {
        super(SysDictionaryGroup.class, metadata);
    }

}

