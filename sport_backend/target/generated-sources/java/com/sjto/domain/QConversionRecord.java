package com.sjto.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QConversionRecord is a Querydsl query type for ConversionRecord
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QConversionRecord extends EntityPathBase<ConversionRecord> {

    private static final long serialVersionUID = -1010726014L;

    public static final QConversionRecord conversionRecord = new QConversionRecord("conversionRecord");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final NumberPath<Integer> days = createNumber("days", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> pid = createNumber("pid", Long.class);

    public final NumberPath<Long> sid = createNumber("sid", Long.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public final StringPath userName = createString("userName");

    public QConversionRecord(String variable) {
        super(ConversionRecord.class, forVariable(variable));
    }

    public QConversionRecord(Path<? extends ConversionRecord> path) {
        super(path.getType(), path.getMetadata());
    }

    public QConversionRecord(PathMetadata metadata) {
        super(ConversionRecord.class, metadata);
    }

}

