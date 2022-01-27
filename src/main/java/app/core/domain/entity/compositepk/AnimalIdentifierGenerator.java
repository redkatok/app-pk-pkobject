package app.core.domain.entity.compositepk;

public class AnimalIdentifierGenerator extends AbstractLongEntityIdIdentifierGenerator<AnimalId> {

    @Override
    protected AnimalId createEntityId(long seqValue) {
        return new AnimalId(seqValue);
    }
}
