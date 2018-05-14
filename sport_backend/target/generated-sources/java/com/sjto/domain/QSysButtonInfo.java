package com.sjto.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSysButtonInfo is a Querydsl query type for SysButtonInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSysButtonInfo extends EntityPathBase<SysButtonInfo> {

    private static final long serialVersionUID = 423938322L;

    public static final QSysButtonInfo sysButtonInfo = new QSysButtonInfo("sysButtonInfo");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath image = createString("image");

    public final StringPath remark = createString("remark");

    public final StringPath title = createString("title");

    public final StringPath type = createString("type");

    public QSysButtonInfo(String variable) {
        super(SysButtonInfo.class, forVariable(variable));
    }

    public QSysButtonInfo(Path<? extends SysButtonInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSysButtonInfo(PathMetadata metadata) {
        super(SysButtonInfo.class, metadata);
    }

}

