package com.example.spring_data_jpa_complete.entity;

import java.util.Set;

/**
 * @authour vindas
 **/
public enum Role {
    ADMIN(Set.of(Permissions.READ,Permissions.WRITE,Permissions.DELETE)),
    USER(Set.of(Permissions.READ));

    private final Set<Permissions> permissions;

    Role(Set<Permissions> permissions) {
        this.permissions = permissions;
    }

    public Set<Permissions> getPermissions() {
        return permissions;
    }
}
