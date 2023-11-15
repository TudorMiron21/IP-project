package ip.project.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table
public class Faculty {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Faculty_Classroom",
            joinColumns = @JoinColumn(name = "id_faculty"),
            inverseJoinColumns = @JoinColumn(name = "id_classroom")
    )
    private Set<Classroom> classrooms;



    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Faculty_Professor",
            joinColumns = @JoinColumn(name = "id_faculty"),
            inverseJoinColumns = @JoinColumn(name = "id_professor")
    )
    private Set<Professor> professors;


    @OneToMany(fetch = FetchType.LAZY,mappedBy = "faculty")
    private Set<StudyGroup> studyGroups;

    @OneToOne(mappedBy = "faculty")
    private Secretary secretary;
}
