package com.cp.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMidShoppingGoods is a Querydsl query type for MidShoppingGoods
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMidShoppingGoods extends EntityPathBase<MidShoppingGoods> {

    private static final long serialVersionUID = 1373725564L;

    public static final QMidShoppingGoods midShoppingGoods = new QMidShoppingGoods("midShoppingGoods");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final StringPath goodsId = createString("goodsId");

    public final StringPath id = createString("id");

    public final StringPath shoppingId = createString("shoppingId");

    public final NumberPath<Integer> valid = createNumber("valid", Integer.class);

    public QMidShoppingGoods(String variable) {
        super(MidShoppingGoods.class, forVariable(variable));
    }

    public QMidShoppingGoods(Path<? extends MidShoppingGoods> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMidShoppingGoods(PathMetadata metadata) {
        super(MidShoppingGoods.class, metadata);
    }

}

