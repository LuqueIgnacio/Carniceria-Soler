package com.proyectoTaller1.taller1.dtos;

import com.proyectoTaller1.taller1.models.Brand;
import com.proyectoTaller1.taller1.models.Category;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdminProductDTO {
    private Long id;

    @Size(max = 20)
    @NotBlank
    private String code;

    @Size(max = 30)
    @NotBlank
    private String name;

    @Size(max = 50)
    @NotBlank
    private String image;

    @NotNull
    private BigDecimal price = new BigDecimal(0.0);

    @NotNull
    private BigDecimal costPrice = new BigDecimal(0.0);

    @NotNull
    private int stock = 0;

    @NotNull
    private boolean isListed = true;

    @NotNull
    private CustomerCategoryDTO category;

    @NotNull
    private CustomerBrandDTO brand;

    @NotNull
    private boolean deletedAt = false;
}