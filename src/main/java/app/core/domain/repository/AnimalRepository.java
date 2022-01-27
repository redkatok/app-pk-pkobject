package app.core.domain.repository;

import app.core.domain.entity.Animal;
import app.core.domain.entity.compositepk.AnimalId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, AnimalId> {
}