package com.sjto.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QVenuePackages is a Querydsl query type for VenuePackages
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVenuePackages extends EntityPathBase<VenuePackages> {

    private static final long serialVersionUID = 729135073L;

    public static final QVenuePackages venuePackages = new QVenuePackages("venuePackages");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Double> money = createNumber("money", Double.class);

    public final NumberPath<Long> oid = createNumber("oid", Long.class);

    public final StringPath remark = createString("remark");

    public final StringPath title = createString("title");

    public final DateTimePath<java.util.Date> updateTime = createDateTime("updateTime", java.util.Date.class);

    public QVenuePackages(String variable) {
        super(VenuePackages.class, forVariable(variable));
    }

    public QVenuePackages(Path<? extends VenuePackages> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVenuePackages(PathMetadata metadata) {
        super(VenuePackages.class, metadata);
    }

}

