package ip.project.model;


import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Set.of;

public enum Roles {
    STUDENT(Set.of()),

    PROFESSOR(
            of(
                    Permissions.PROFESSOR_READ,
                    Permissions.PROFESSOR_WRITE,
                    Permissions.PROFESSOR_UPDATE,
                    Permissions.PROFESSOR_DELETE
            )
    ),

    SECRETARY(
            of(
                    Permissions.PROFESSOR_READ,
                    Permissions.PROFESSOR_WRITE,
                    Permissions.PROFESSOR_UPDATE,
                    Permissions.PROFESSOR_DELETE,
                    Permissions.SECRETARY_READ,
                    Permissions.SECRETARY_WRITE,
                    Permissions.SECRETARY_UPDATE,
                    Permissions.SECRETARY_DELETE
            )
    ),

    ADMIN(
            of(
                    Permissions.PROFESSOR_READ,
                    Permissions.PROFESSOR_WRITE,
                    Permissions.PROFESSOR_UPDATE,
                    Permissions.PROFESSOR_DELETE,
                    Permissions.SECRETARY_READ,
                    Permissions.SECRETARY_WRITE,
                    Permissions.SECRETARY_UPDATE,
                    Permissions.SECRETARY_DELETE,
                    Permissions.ADMIN_READ,
                    Permissions.ADMIN_WRITE,
                    Permissions.ADMIN_UPDATE,
                    Permissions.ADMIN_DELETE
            )
    )

    ;

    @Getter
    private final Set<Permissions> permissions;

    public Set<Permissions> getPermissions()
    {
        return this.permissions;
    }


    Roles(Set<Permissions> permissions) {
        this.permissions = permissions;
    }


    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
