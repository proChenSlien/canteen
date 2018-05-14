package com.sjto.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMemberPackages is a Querydsl query type for MemberPackages
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMemberPackages extends EntityPathBase<MemberPackages> {

    private static final long serialVersionUID = -1845230878L;

    public static final QMemberPackages memberPackages = new QMemberPackages("memberPackages");

    public final NumberPath<Integer> award = createNumber("award", Integer.class);

    public final StringPath awardType = createString("awardType");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final NumberPath<Integer> days = createNumber("days", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Double> money = createNumber("money", Double.class);

    public final StringPath remark = createString("remark");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath title = createString("title");

    public final DateTimePath<java.util.Date> updateTime = createDateTime("updateTime", java.util.Date.class);

    public QMemberPackages(String variable) {
        super(MemberPackages.class, forVariable(variable));
    }

    public QMemberPackages(Path<? extends MemberPackages> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberPackages(PathMetadata metadata) {
        super(MemberPackages.class, metadata);
    }

}

