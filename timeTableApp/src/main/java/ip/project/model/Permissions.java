package ip.project.model;

import lombok.Getter;

@Getter
public enum Permissions {


    PROFESSOR_READ("professor:read"),
    PROFESSOR_WRITE("professor:write"),
    PROFESSOR_UPDATE("professor:update"),
    PROFESSOR_DELETE("professor:delete"),


    SECRETARY_READ("secretary:read"),
    SECRETARY_WRITE("secretary:write"),
    SECRETARY_UPDATE("secretary:update"),
    SECRETARY_DELETE("secretary:delete"),


    ADMIN_READ("admin:read"),
    ADMIN_WRITE("admin:write"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_DELETE("admin:delete");

    private final String permission;

    Permissions(String permission) {
        this.permission = permission;
    }

    public String getPermission()
    {
        return this.permission;
    }
}