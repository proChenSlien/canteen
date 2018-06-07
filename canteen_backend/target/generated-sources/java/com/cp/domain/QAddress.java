package com.cp.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAddress is a Querydsl query type for Address
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAddress extends EntityPathBase<Address> {

    private static final long serialVersionUID = 1083129118L;

    public static final QAddress address1 = new QAddress("address1");

    public final StringPath address = createString("address");

    public final StringPath id = createString("id");

    public final NumberPath<Integer> isDefault = createNumber("isDefault", Integer.class);

    public final NumberPath<Integer> state = createNumber("state", Integer.class);

    public final StringPath userId = createString("userId");

    public final NumberPath<Integer> valid = createNumber("valid", Integer.class);

    public QAddress(String variable) {
        super(Address.class, forVariable(variable));
    }

    public QAddress(Path<? extends Address> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAddress(PathMetadata metadata) {
        super(Address.class, metadata);
    }

}

