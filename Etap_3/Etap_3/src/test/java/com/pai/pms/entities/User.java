package com.pai.pms.entities;

import com.pai.pms.model.entities.Role;
import com.pai.pms.model.enums.AuthProvider;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private int phone;
    private String password;
    private AuthProvider provider;
    private String providerId;
    private Set<Role> roles = new HashSet<>();

    public User(int id, String name, String lastName, String email, int phone, String password,
                AuthProvider provider, String providerId, Set<Role> roles) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.provider = provider;
        this.providerId = providerId;
        this.roles = roles;
    }
}
