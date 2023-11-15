package ip.project.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table
public class StudyGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;

    public Integer studyYear;

    @ManyToOne
    @JoinColumn(name = "id_faculty")
    public Faculty faculty;


    @OneToMany(mappedBy = "studyGroup")
    public Set<Student> students;
}
