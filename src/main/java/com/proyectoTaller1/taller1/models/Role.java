package com.proyectoTaller1.taller1.models;

import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Setter
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false, length = 30)
    @Size(max = 30)
    @NotBlank
    private String name;

    @Column(name = "display_name", nullable = false, length = 30)
    @Size(max = 30)
    @NotBlank
    private String displayName;
}