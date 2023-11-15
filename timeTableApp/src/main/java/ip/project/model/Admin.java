package ip.project.model;


import jakarta.persistence.*;

@Entity
@Table(name = "admin")

public class Admin{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "admin")
    private User user;
}
