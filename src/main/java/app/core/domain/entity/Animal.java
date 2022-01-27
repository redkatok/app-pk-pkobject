package app.core.domain.entity;

import app.core.domain.entity.compositepk.AnimalId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "animal")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Animal {

    @EmbeddedId
    @GenericGenerator(
        name = "assigned-sequence",
        strategy = "app.core.domain.entity.compositepk.AnimalIdentifierGenerator",
        parameters = {@Parameter(name = SequenceStyleGenerator.CONFIG_PREFER_SEQUENCE_PER_ENTITY,
            value = "true"),
            @Parameter(name = SequenceStyleGenerator.CONFIG_SEQUENCE_PER_ENTITY_SUFFIX,
                value = "_SEQUENCE")})
    @GeneratedValue(
        generator = "assigned-sequence",
        strategy = GenerationType.SEQUENCE)
    public AnimalId id;

    private String name;

    public Animal(String name) {
        this.name = name;
    }
}
