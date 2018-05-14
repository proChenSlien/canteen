package com.sjto.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QVenueInfo is a Querydsl query type for VenueInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVenueInfo extends EntityPathBase<VenueInfo> {

    private static final long serialVersionUID = -1680514654L;

    public static final QVenueInfo venueInfo = new QVenueInfo("venueInfo");

    public final DateTimePath<java.util.Date> endTime = createDateTime("endTime", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath venueName = createString("venueName");

    public QVenueInfo(String variable) {
        super(VenueInfo.class, forVariable(variable));
    }

    public QVenueInfo(Path<? extends VenueInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVenueInfo(PathMetadata metadata) {
        super(VenueInfo.class, metadata);
    }

}

