package app.core.domain.entity.compositepk;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractLongEntityId implements EntityId<Long> {
    @Column(name = "id")
    private  Long value;

    protected AbstractLongEntityId(Long value) {
        this.value = value;
    }

    protected AbstractLongEntityId() {
    }

    @Override
    public Long getValue() {
        return value;
    }

    @Override
    public String asString() {
        return String.valueOf(value);
    }
}
