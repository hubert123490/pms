package com.pai.pms.payload.response;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Integer id;
    private String email;
    private List<String> roles;
    private String firstName;
    private String lastName;

    public JwtResponse(String accessToken, Integer id, String email, List<String> roles, String firstName, String lastName) {
        this.token = accessToken;
        this.id = id;
        this.email = email;
        this.roles = roles;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}