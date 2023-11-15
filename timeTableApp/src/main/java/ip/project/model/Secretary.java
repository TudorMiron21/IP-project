package ip.project.model;


import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Secretary extends User{

    private Faculty faculty;


}
