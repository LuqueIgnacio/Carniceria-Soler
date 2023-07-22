package com.proyectoTaller1.taller1.mappers;

import com.proyectoTaller1.taller1.dtos.RoleDTO;
import com.proyectoTaller1.taller1.models.Role;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface RoleMapper {
    RoleDTO toDTO(Role role);
    Role toDTO(RoleDTO role);
}