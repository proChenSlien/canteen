package com.cp.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QUserApi is a Querydsl query type for UserApi
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUserApi extends EntityPathBase<UserApi> {

    private static final long serialVersionUID = 2083659641L;

    public static final QUserApi userApi = new QUserApi("userApi");

    public final NumberPath<Long> accountNum = createNumber("accountNum", Long.class);

    public final StringPath id = createString("id");

    public final StringPath imgShow = createString("imgShow");

    public final DateTimePath<java.util.Date> loginTimeLast = createDateTime("loginTimeLast", java.util.Date.class);

    public final StringPath password = createString("password");

    public final NumberPath<Long> phone = createNumber("phone", Long.class);

    public final StringPath realName = createString("realName");

    public final NumberPath<Integer> sex = createNumber("sex", Integer.class);

    public final NumberPath<Integer> state = createNumber("state", Integer.class);

    public final StringPath userName = createString("userName");

    public final NumberPath<Integer> valid = createNumber("valid", Integer.class);

    public QUserApi(String variable) {
        super(UserApi.class, forVariable(variable));
    }

    public QUserApi(Path<? extends UserApi> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUserApi(PathMetadata metadata) {
        super(UserApi.class, metadata);
    }

}

