package com.proyectoTaller1.taller1.mappers;

import com.proyectoTaller1.taller1.dtos.CustomerBrandDTO;
import com.proyectoTaller1.taller1.dtos.CustomerCategoryDTO;
import com.proyectoTaller1.taller1.models.Brand;
import com.proyectoTaller1.taller1.models.Category;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface CustomerBrandMapper {
    CustomerBrandDTO toDTO(Brand brand);
}
