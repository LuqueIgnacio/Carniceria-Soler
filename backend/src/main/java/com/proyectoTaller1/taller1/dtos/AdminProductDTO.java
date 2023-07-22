package com.proyectoTaller1.taller1.dtos;

import com.proyectoTaller1.taller1.validators.Image;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;


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
    private String image;

    @Image(skipMethod = {"PUT"})
    private MultipartFile imageFile;

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