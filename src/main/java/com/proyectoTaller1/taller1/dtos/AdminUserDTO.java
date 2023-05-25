package com.proyectoTaller1.taller1.dtos;

import com.proyectoTaller1.taller1.models.Role;
import lombok.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    @NotBlank
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