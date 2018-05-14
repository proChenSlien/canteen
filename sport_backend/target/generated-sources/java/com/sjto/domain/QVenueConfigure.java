package com.sjto.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QVenueConfigure is a Querydsl query type for VenueConfigure
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVenueConfigure extends EntityPathBase<VenueConfigure> {

    private static final long serialVersionUID = -1478140302L;

    public static final QVenueConfigure venueConfigure = new QVenueConfigure("venueConfigure");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> kid = createNumber("kid", Long.class);

    public final NumberPath<Long> oid = createNumber("oid", Long.class);

    public QVenueConfigure(String variable) {
        super(VenueConfigure.class, forVariable(variable));
    }

    public QVenueConfigure(Path<? extends VenueConfigure> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVenueConfigure(PathMetadata metadata) {
        super(VenueConfigure.class, metadata);
    }

}

