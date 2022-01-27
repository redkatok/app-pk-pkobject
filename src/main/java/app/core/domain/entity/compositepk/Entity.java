package app.core.domain.entity.compositepk;

public interface Entity<T extends EntityId> {
    T getId();
}
