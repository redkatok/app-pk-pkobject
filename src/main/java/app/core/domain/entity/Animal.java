package app.core.domain.entity;

import io.github.wimdeblauwe.jpearl.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import javax.persistence.EmbeddedId;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "animal")
@NoArgsConstructor
@AllArgsConstructor
@javax.persistence.Entity
public class Animal extends AbstractEntity<AnimalId> {

    @GenericGenerator(
        name = "assigned-sequence",
        strategy = "app.core.domain.generator.AnimalIdIdentifierGenerator",
        parameters = {@Parameter(name = SequenceStyleGenerator.CONFIG_PREFER_SEQUENCE_PER_ENTITY,
            value = "true"),
            @Parameter(name = SequenceStyleGenerator.CONFIG_SEQUENCE_PER_ENTITY_SUFFIX,
                value = "_SEQUENCE")})
    @GeneratedValue(
        generator = "assigned-sequence",
        strategy = GenerationType.SEQUENCE)
    @EmbeddedId
    public AnimalId id;

    private String name;

    public Animal(String name) {
        this.name = name;
    }
}
