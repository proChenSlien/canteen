package com.cp.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QGoods is a Querydsl query type for Goods
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGoods extends EntityPathBase<Goods> {

    private static final long serialVersionUID = 2076277504L;

    public static final QGoods goods = new QGoods("goods");

    public final StringPath goodsName = createString("goodsName");

    public final StringPath id = createString("id");

    public final StringPath img = createString("img");

    public final NumberPath<Double> price = createNumber("price", Double.class);

    public final StringPath remark = createString("remark");

    public final NumberPath<Integer> state = createNumber("state", Integer.class);

    public final NumberPath<Integer> stock = createNumber("stock", Integer.class);

    public final StringPath typeId = createString("typeId");

    public final NumberPath<Integer> valid = createNumber("valid", Integer.class);

    public final NumberPath<Integer> volumeDay = createNumber("volumeDay", Integer.class);

    public final NumberPath<Integer> volumeMonth = createNumber("volumeMonth", Integer.class);

    public final NumberPath<Integer> volumeYear = createNumber("volumeYear", Integer.class);

    public QGoods(String variable) {
        super(Goods.class, forVariable(variable));
    }

    public QGoods(Path<? extends Goods> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGoods(PathMetadata metadata) {
        super(Goods.class, metadata);
    }

}

