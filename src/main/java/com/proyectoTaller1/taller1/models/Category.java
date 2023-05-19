package com.proyectoTaller1.taller1.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Setter
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
public class Category {
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

    @Column(name = "created_at", nullable = false)
    @NotNull
    private LocalDate createdAt;

    @Column(name = "deleted_at", nullable = false)
    @NotNull
    private LocalDate deletedAt;
}
