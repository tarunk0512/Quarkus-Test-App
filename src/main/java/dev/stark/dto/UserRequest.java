package dev.stark.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;

public class UserRequest {

    @NotBlank
    public String name;

    @Email
    @NotBlank
    public String email;

    @Min(1)
    public Integer age;
}