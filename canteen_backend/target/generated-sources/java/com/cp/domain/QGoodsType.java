package com.cp.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGoodsType is a Querydsl query type for GoodsType
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGoodsType extends EntityPathBase<GoodsType> {

    private static final long serialVersionUID = 2025061978L;

    public static final QGoodsType goodsType = new QGoodsType("goodsType");

    public final StringPath id = createString("id");

    public final StringPath typeName = createString("typeName");

    public final NumberPath<Integer> valid = createNumber("valid", Integer.class);

    public QGoodsType(String variable) {
        super(GoodsType.class, forVariable(variable));
    }

    public QGoodsType(Path<? extends GoodsType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGoodsType(PathMetadata metadata) {
        super(GoodsType.class, metadata);
    }

}

