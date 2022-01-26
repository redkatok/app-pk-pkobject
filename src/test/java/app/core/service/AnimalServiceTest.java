package app.core.service;

import app.core.domain.entity.Animal;
import app.core.domain.repository.AnimalRepository;
import org.assertj.core.api.ListAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@TestPropertySource(properties = {
    "logging.level.root=error",
    "spring.jpa.properties.hibernate.show_sql=true",
    "spring.jpa.properties.hibernate.use_sql_comments=true",
    "spring.jpa.properties.hibernate.format_sql=true",
    "logging.level.org.hibernate.type=trace",

    "spring.main.log-startup-info=OFF",
    "logging.level.org.springframework=error",
    "spring.main.banner-mode=off",

})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AnimalServiceTest {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private AnimalRepository animalRepository;

    @Test
    @Sql(statements = "CREATE SEQUENCE IF NOT EXISTS ANIMAL_SEQUENCE")
    void saveAnimals() {

        List<Animal> animals = List.of(
            new Animal("Cat"),
            new Animal("Dog")
        );

        animalService.saveAnimals(animals);

        ListAssert<Animal> notEmpty = assertThat(animalRepository.findAll()).isNotEmpty();
    }
}