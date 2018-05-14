package com.sjto.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QVipChildCardInfo is a Querydsl query type for VipChildCardInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVipChildCardInfo extends EntityPathBase<VipChildCardInfo> {

    private static final long serialVersionUID = -1713332616L;

    public static final QVipChildCardInfo vipChildCardInfo = new QVipChildCardInfo("vipChildCardInfo");

    public final DateTimePath<java.util.Date> activeTime = createDateTime("activeTime", java.util.Date.class);

    public final StringPath authImgUrl = createString("authImgUrl");

    public final NumberPath<Integer> authState = createNumber("authState", Integer.class);

    public final StringPath babyName = createString("babyName");

    public final NumberPath<Integer> babySex = createNumber("babySex", Integer.class);

    public final NumberPath<Long> cid = createNumber("cid", Long.class);

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> mainUserId = createNumber("mainUserId", Long.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final DateTimePath<java.util.Date> updateTime = createDateTime("updateTime", java.util.Date.class);

    public QVipChildCardInfo(String variable) {
        super(VipChildCardInfo.class, forVariable(variable));
    }

    public QVipChildCardInfo(Path<? extends VipChildCardInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVipChildCardInfo(PathMetadata metadata) {
        super(VipChildCardInfo.class, metadata);
    }

}

