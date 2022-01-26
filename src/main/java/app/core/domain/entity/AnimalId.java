package app.core.domain.entity;

import io.github.wimdeblauwe.jpearl.AbstractEntityId;

public class AnimalId extends AbstractEntityId<Long> {

    protected AnimalId() { //(1)
    }

    public AnimalId(Long id) { //(2)
        super(id);
    }

}
