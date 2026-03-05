package dev.stark.dto;

public class UserResponse {

    public Long id;
    public String name;
    public String email;
    public Integer age;

    public UserResponse(Long id, String name, String email, Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }
}