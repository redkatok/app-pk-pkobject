package app.core.service;

import app.core.domain.entity.Animal;
import app.core.domain.repository.AnimalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalRepository animalRepository;

    public void saveAnimals(List<Animal> animals) {
        animalRepository.saveAll(animals);
    }
}
