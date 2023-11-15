package ip.project.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table
@Builder
public class Subject {

    @Id
    private Long id;

    private String name;

    private Integer nrOreCurs;
    private Integer nrOreLab;

    private Integer nrOreSeminar;

    private Integer nrCredite;

    private Integer semester;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Subject_Professor",
            joinColumns = @JoinColumn(name = "id_subject"),
            inverseJoinColumns = @JoinColumn(name = "id_professor")
    )
    private Set<Professor> professors;

}
