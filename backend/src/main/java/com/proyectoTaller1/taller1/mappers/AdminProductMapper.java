package com.proyectoTaller1.taller1.mappers;

import com.proyectoTaller1.taller1.dtos.AdminProductDTO;
import com.proyectoTaller1.taller1.dtos.CustomerBrandDTO;
import com.proyectoTaller1.taller1.dtos.CustomerCategoryDTO;
import com.proyectoTaller1.taller1.models.Brand;
import com.proyectoTaller1.taller1.models.Category;
import com.proyectoTaller1.taller1.models.Product;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {CustomerCategoryMapper.class, CustomerBrandMapper.class},componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface AdminProductMapper {
    @Mapping(target = "id", source = "product.id")
    @Mapping(target = "name", source = "product.name")
    @Mapping(target = "deletedAt", source = "product.deletedAt")
    AdminProductDTO toDTO(Product product, Category category, Brand brand);

    @Mapping(target = "id", source = "product.id")
    Product toModel(AdminProductDTO product, CustomerCategoryDTO category, CustomerBrandDTO brand);
}