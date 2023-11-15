package ip.project.model;


import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Student extends User {

    @ManyToOne()
    private StudyGroup studyGroup;

}
