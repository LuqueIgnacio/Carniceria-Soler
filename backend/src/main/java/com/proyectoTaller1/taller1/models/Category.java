package com.proyectoTaller1.taller1.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    @NotNull
    private LocalDate createdAt;

    @Column(name = "deleted_at", nullable = false)
    @NotNull
    private boolean deletedAt = false;
}
