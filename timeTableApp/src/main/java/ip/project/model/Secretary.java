package ip.project.model;


import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@NoArgsConstructor

public class Secretary{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_faculty")
    private Faculty faculty;

    @OneToOne(mappedBy = "secretary")
    private User user;

}
