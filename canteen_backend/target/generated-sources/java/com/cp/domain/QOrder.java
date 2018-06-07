package com.cp.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QOrder is a Querydsl query type for Order
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QOrder extends EntityPathBase<Order> {

    private static final long serialVersionUID = 2083744504L;

    public static final QOrder order = new QOrder("order1");

    public final StringPath addressId = createString("addressId");

    public final StringPath distributor = createString("distributor");

    public final StringPath id = createString("id");

    public final StringPath orderNum = createString("orderNum");

    public final DateTimePath<java.util.Date> orderTime = createDateTime("orderTime", java.util.Date.class);

    public final NumberPath<Integer> payType = createNumber("payType", Integer.class);

    public final DateTimePath<java.util.Date> prereachTime = createDateTime("prereachTime", java.util.Date.class);

    public final DateTimePath<java.util.Date> reachTime = createDateTime("reachTime", java.util.Date.class);

    public final StringPath remark = createString("remark");

    public final DateTimePath<java.util.Date> requireTime = createDateTime("requireTime", java.util.Date.class);

    public final StringPath shoppingId = createString("shoppingId");

    public final StringPath userId = createString("userId");

    public final NumberPath<Integer> valid = createNumber("valid", Integer.class);

    public QOrder(String variable) {
        super(Order.class, forVariable(variable));
    }

    public QOrder(Path<? extends Order> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOrder(PathMetadata metadata) {
        super(Order.class, metadata);
    }

}

