package ip.project.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
@Table(name = "_user")
@Data
@Builder
public class User implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    protected String firstName;

    protected String lastName;

    protected String password;
    @Enumerated(EnumType.STRING)
    protected Roles role;

    protected String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_student")
    private Student student;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_professor")
    private Professor professor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_admin")
    private Admin admin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_secretary")
    private Secretary secretary;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }


    //we are going to use the email as the username
    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

