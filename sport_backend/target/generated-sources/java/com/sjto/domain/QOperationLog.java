package com.sjto.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QOperationLog is a Querydsl query type for OperationLog
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOperationLog extends EntityPathBase<OperationLog> {

    private static final long serialVersionUID = -1675553704L;

    public static final QOperationLog operationLog = new QOperationLog("operationLog");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> operaId = createNumber("operaId", Long.class);

    public final NumberPath<Long> operaType = createNumber("operaType", Long.class);

    public QOperationLog(String variable) {
        super(OperationLog.class, forVariable(variable));
    }

    public QOperationLog(Path<? extends OperationLog> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOperationLog(PathMetadata metadata) {
        super(OperationLog.class, metadata);
    }

}

