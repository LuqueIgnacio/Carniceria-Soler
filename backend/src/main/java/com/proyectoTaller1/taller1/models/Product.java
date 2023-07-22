package com.proyectoTaller1.taller1.models;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
@DynamicUpdate
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false, length = 20, unique = true)
    @Size(max = 20)
    @NotBlank
    private String code;

    @Column(name = "name", nullable = false, length = 30)
    @Size(max = 30)
    @NotBlank
    private String name;

    @Column(name = "image", nullable = false, length = 50)
    @Size(max = 50)
    @NotBlank
    private String image;

    @Column(name = "price", scale = 2, precision = 5)
    private BigDecimal price = new BigDecimal(0.0);

    @Column(name = "cost_price")
    private BigDecimal costPrice = new BigDecimal(0.0);

    @Column(name = "stock")
    private int stock = 0;

    @Column(name = "listed")
    private boolean isListed = true;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate updatedAt;

    @Column(name = "deleted_at", nullable = false)
    @NotNull
    private boolean deletedAt = false;
}
