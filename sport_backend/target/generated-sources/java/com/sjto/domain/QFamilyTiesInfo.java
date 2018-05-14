package com.sjto.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QFamilyTiesInfo is a Querydsl query type for FamilyTiesInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFamilyTiesInfo extends EntityPathBase<FamilyTiesInfo> {

    private static final long serialVersionUID = -1014000144L;

    public static final QFamilyTiesInfo familyTiesInfo = new QFamilyTiesInfo("familyTiesInfo");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> phone = createNumber("phone", Long.class);

    public final StringPath shipName = createString("shipName");

    public final NumberPath<Long> sid = createNumber("sid", Long.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QFamilyTiesInfo(String variable) {
        super(FamilyTiesInfo.class, forVariable(variable));
    }

    public QFamilyTiesInfo(Path<? extends FamilyTiesInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFamilyTiesInfo(PathMetadata metadata) {
        super(FamilyTiesInfo.class, metadata);
    }

}

