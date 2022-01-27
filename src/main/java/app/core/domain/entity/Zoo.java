package app.core.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "zoo")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Zoo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String zooName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Animal> animals;

    public Zoo(String zooName) {
        this.zooName = zooName;
    }
}
