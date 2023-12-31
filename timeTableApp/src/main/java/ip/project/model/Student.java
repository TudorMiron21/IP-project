package ip.project.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Student{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(mappedBy = "student")
    private User user;


    @ManyToOne
    @JoinColumn(name ="id_studygroup")
    private StudyGroup studyGroup;

}
