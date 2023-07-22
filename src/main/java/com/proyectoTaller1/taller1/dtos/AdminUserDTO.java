package com.proyectoTaller1.taller1.dtos;

import com.proyectoTaller1.taller1.models.Role;
import com.proyectoTaller1.taller1.validators.Password;
import lombok.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminUserDTO {
    private Long id;

    @Size(max=50)
    @NotBlank
    private String name;

    @Size(max=50)
    @NotBlank
    private String lastName;

    @Size(max=9)
    @NotBlank
    private String dni;

    @Size(max=50)
    @NotBlank
    @Email
    private String email;

    @Size(max=60)
    @Password(skipMethod = {"PUT"})
    private String password;

    @Size(max=15)
    @NotBlank
    private String phone;

    @Size(max=50)
    @NotBlank
    private String address;

    @NotNull
    private RoleDTO role;

    @NotNull
    private boolean deletedAt = false;
}