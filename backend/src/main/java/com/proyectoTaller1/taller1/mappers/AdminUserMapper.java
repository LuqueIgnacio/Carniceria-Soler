package com.proyectoTaller1.taller1.mappers;

import com.proyectoTaller1.taller1.dtos.AdminUserDTO;
import com.proyectoTaller1.taller1.models.User;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

@Mapper(uses = {RoleMapper.class},componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface AdminUserMapper {
    User toModel(AdminUserDTO user);
    AdminUserDTO toDTO(User user);
}
