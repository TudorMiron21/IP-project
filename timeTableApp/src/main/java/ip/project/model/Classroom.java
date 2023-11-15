package ip.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table
public class Classroom {
    @Id
    private Long id;

    @ManyToMany(mappedBy = "classrooms")
    @JsonIgnore
    private Set<Faculty> faculties;

    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "id_classtype")
    private ClassType classType;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Classroom_Equipment",
            joinColumns = @JoinColumn(name = "id_classroom"),
            inverseJoinColumns = @JoinColumn(name = "id_equipment")
    )
    private Set<Equipment> equipmentSet;


}
