package brainslug.jpa.entity.query;

import brainslug.jpa.entity.InstancePropertyEntity;
import com.mysema.query.types.Path;
import com.mysema.query.types.PathMetadata;
import com.mysema.query.types.path.EntityPathBase;
import com.mysema.query.types.path.NumberPath;
import com.mysema.query.types.path.StringPath;

import javax.annotation.Generated;

import static com.mysema.query.types.PathMetadataFactory.forVariable;


/**
 * QInstancePropertyEntity is a Querydsl query type for InstancePropertyEntity
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QInstancePropertyEntity extends EntityPathBase<InstancePropertyEntity> {

    private static final long serialVersionUID = -1716537928L;

    public static final QInstancePropertyEntity instancePropertyEntity = new QInstancePropertyEntity("instancePropertyEntity");

    public final NumberPath<Long> created = createNumber("created", Long.class);

    public final NumberPath<Double> doubleValue = createNumber("doubleValue", Double.class);

    public final StringPath id = createString("id");

    public final StringPath instanceId = createString("instanceId");

    public final NumberPath<Long> longValue = createNumber("longValue", Long.class);

    public final StringPath propertyKey = createString("propertyKey");

    public final StringPath stringValue = createString("stringValue");

    public final StringPath valueType = createString("valueType");

    public final NumberPath<Long> version = createNumber("version", Long.class);

    public QInstancePropertyEntity(String variable) {
        super(InstancePropertyEntity.class, forVariable(variable));
    }

    public QInstancePropertyEntity(Path<? extends InstancePropertyEntity> path) {
        super(path.getType(), path.getMetadata());
    }

    public QInstancePropertyEntity(PathMetadata<?> metadata) {
        super(InstancePropertyEntity.class, metadata);
    }

}

