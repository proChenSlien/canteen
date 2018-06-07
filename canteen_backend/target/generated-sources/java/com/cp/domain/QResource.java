package com.cp.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QResource is a Querydsl query type for Resource
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QResource extends EntityPathBase<Resource> {

    private static final long serialVersionUID = 94914596L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QResource resource1 = new QResource("resource1");

    public final ListPath<Resource, QResource> children = this.<Resource, QResource>createList("children", Resource.class, QResource.class, PathInits.DIRECT2);

    public final StringPath description = createString("description");

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public final QResource parent;

    public final StringPath path = createString("path");

    public final StringPath resource = createString("resource");

    public QResource(String variable) {
        this(Resource.class, forVariable(variable), INITS);
    }

    public QResource(Path<? extends Resource> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QResource(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QResource(PathMetadata metadata, PathInits inits) {
        this(Resource.class, metadata, inits);
    }

    public QResource(Class<? extends Resource> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.parent = inits.isInitialized("parent") ? new QResource(forProperty("parent"), inits.get("parent")) : null;
    }

}

