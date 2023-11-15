package ip.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;
@Data
@Entity
@Table
public class Professor extends User{

    private Set<Faculty> faculties;

    private Integer yearOfExperience;
}
