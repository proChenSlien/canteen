package com.cp.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QShoppingCar is a Querydsl query type for ShoppingCar
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QShoppingCar extends EntityPathBase<ShoppingCar> {

    private static final long serialVersionUID = -881477258L;

    public static final QShoppingCar shoppingCar = new QShoppingCar("shoppingCar");

    public final StringPath carName = createString("carName");

    public final NumberPath<Double> dishFee = createNumber("dishFee", Double.class);

    public final NumberPath<Double> distributionFee = createNumber("distributionFee", Double.class);

    public final NumberPath<Integer> goodsNum = createNumber("goodsNum", Integer.class);

    public final StringPath id = createString("id");

    public final NumberPath<Integer> state = createNumber("state", Integer.class);

    public final NumberPath<Double> total = createNumber("total", Double.class);

    public final StringPath userId = createString("userId");

    public final NumberPath<Integer> valid = createNumber("valid", Integer.class);

    public QShoppingCar(String variable) {
        super(ShoppingCar.class, forVariable(variable));
    }

    public QShoppingCar(Path<? extends ShoppingCar> path) {
        super(path.getType(), path.getMetadata());
    }

    public QShoppingCar(PathMetadata metadata) {
        super(ShoppingCar.class, metadata);
    }

}

