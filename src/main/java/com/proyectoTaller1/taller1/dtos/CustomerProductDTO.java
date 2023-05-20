package com.proyectoTaller1.taller1.dtos;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerProductDTO {
    private Long id;
    private String name;
    private String image;
    private BigDecimal price = new BigDecimal(0.0);
    private CustomerCategoryDTO category;
    private CustomerBrandDTO brand;
}