package com.proyectoTaller1.taller1.services;

import com.proyectoTaller1.taller1.dtos.AdminUserDTO;
import com.proyectoTaller1.taller1.mappers.AdminUserMapper;
import com.proyectoTaller1.taller1.models.User;
import com.proyectoTaller1.taller1.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AdminUserMapper adminUserMapper;

    public User create(AdminUserDTO user){
        return userRepository.save(adminUserMapper.toModel(user));
    }
}