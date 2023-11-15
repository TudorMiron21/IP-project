package ip.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;
@Data
@Entity
@Table

public class Professor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "professor")
    private User user;


    @ManyToMany(mappedBy = "professors")
    @JsonIgnore
    private Set<Faculty> faculties;

    @ManyToMany(mappedBy = "professors")
    @JsonIgnore
    private Set<Subject> subjects;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable( name = "Professor_ClassType",
            joinColumns = @JoinColumn(name = "id_professor"),
            inverseJoinColumns = @JoinColumn(name = "id_classtype")
    )
    private Set<ClassType> classTypeSet;


    private Integer yearOfExperience;
}
