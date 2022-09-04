package ru.aston.trainee.team3_library.response;

import java.util.List;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private List<String> roleSet;

    public JwtResponse(String token, Long id, String username, List<String> roleSet) {
        this.token = token;
        this.id = id;
        this.username = username;
        this.roleSet = roleSet;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(List<String> roleSet) {
        this.roleSet = roleSet;
    }
}
