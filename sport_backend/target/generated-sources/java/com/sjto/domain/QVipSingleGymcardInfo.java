package com.sjto.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QVipSingleGymcardInfo is a Querydsl query type for VipSingleGymcardInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QVipSingleGymcardInfo extends EntityPathBase<VipSingleGymcardInfo> {

    private static final long serialVersionUID = -684716145L;

    public static final QVipSingleGymcardInfo vipSingleGymcardInfo = new QVipSingleGymcardInfo("vipSingleGymcardInfo");

    public final DateTimePath<java.util.Date> activeTime = createDateTime("activeTime", java.util.Date.class);

    public final StringPath authImgUrl = createString("authImgUrl");

    public final NumberPath<Integer> authState = createNumber("authState", Integer.class);

    public final NumberPath<Long> cid = createNumber("cid", Long.class);

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final DateTimePath<java.util.Date> endDate = createDateTime("endDate", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath loginName = createString("loginName");

    public final NumberPath<Long> phone = createNumber("phone", Long.class);

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final DateTimePath<java.util.Date> updateTime = createDateTime("updateTime", java.util.Date.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QVipSingleGymcardInfo(String variable) {
        super(VipSingleGymcardInfo.class, forVariable(variable));
    }

    public QVipSingleGymcardInfo(Path<? extends VipSingleGymcardInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVipSingleGymcardInfo(PathMetadata metadata) {
        super(VipSingleGymcardInfo.class, metadata);
    }

}

