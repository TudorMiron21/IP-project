package ip.project.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class StudyGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    public String name;

    public Integer studyYear;

    public Faculty faculty;

}
