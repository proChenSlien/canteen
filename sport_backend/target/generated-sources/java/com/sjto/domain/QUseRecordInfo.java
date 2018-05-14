package com.sjto.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUseRecordInfo is a Querydsl query type for UseRecordInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUseRecordInfo extends EntityPathBase<UseRecordInfo> {

    private static final long serialVersionUID = -1173500693L;

    public static final QUseRecordInfo useRecordInfo = new QUseRecordInfo("useRecordInfo");

    public final DateTimePath<java.util.Date> beginTime = createDateTime("beginTime", java.util.Date.class);

    public final DateTimePath<java.util.Date> endTime = createDateTime("endTime", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> pid = createNumber("pid", Long.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QUseRecordInfo(String variable) {
        super(UseRecordInfo.class, forVariable(variable));
    }

    public QUseRecordInfo(Path<? extends UseRecordInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUseRecordInfo(PathMetadata metadata) {
        super(UseRecordInfo.class, metadata);
    }

}

