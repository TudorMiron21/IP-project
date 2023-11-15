package ip.project.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Faculty {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    public String name;

}
