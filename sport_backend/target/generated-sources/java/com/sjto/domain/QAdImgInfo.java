package com.sjto.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QAdImgInfo is a Querydsl query type for AdImgInfo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAdImgInfo extends EntityPathBase<AdImgInfo> {

    private static final long serialVersionUID = 1468396371L;

    public static final QAdImgInfo adImgInfo = new QAdImgInfo("adImgInfo");

    public final StringPath bgImgUrl = createString("bgImgUrl");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath images = createString("images");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath title = createString("title");

    public final StringPath type = createString("type");

    public final DateTimePath<java.util.Date> updateTime = createDateTime("updateTime", java.util.Date.class);

    public final StringPath urlH5 = createString("urlH5");

    public final StringPath urlXCX = createString("urlXCX");

    public QAdImgInfo(String variable) {
        super(AdImgInfo.class, forVariable(variable));
    }

    public QAdImgInfo(Path<? extends AdImgInfo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAdImgInfo(PathMetadata metadata) {
        super(AdImgInfo.class, metadata);
    }

}

