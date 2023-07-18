package com.proyectoTaller1.taller1.services;

import com.proyectoTaller1.taller1.dtos.AdminUserDTO;
import com.proyectoTaller1.taller1.mappers.AdminUserMapper;
import com.proyectoTaller1.taller1.models.User;
import com.proyectoTaller1.taller1.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final AdminUserMapper adminUserMapper;

    public AdminUserDTO getAdminUserDTO(Long id) throws RuntimeException{
        User user = userRepository.findById(id).orElseThrow(RuntimeException::new);
        return adminUserMapper.toDTO(user);
    }
    public List<AdminUserDTO> getAllAdminUserDTO(){
        return userRepository.findByDeletedAtFalse().stream().map(adminUserMapper::toDTO).collect(Collectors.toList());
    }
    public User create(AdminUserDTO user){
        return userRepository.save(adminUserMapper.toModel(user));
    }

    public User update(AdminUserDTO userDTO){
        if(userDTO.getPassword() == null){
            User user = adminUserMapper.toModel(userDTO);
            userRepository.updateWithoutModifyPassword(user);
            return user;
        }
        userDTO.setPassword(new BCryptPasswordEncoder(12).encode(userDTO.getPassword()));
        return userRepository.save(adminUserMapper.toModel(userDTO));
    }

    public User delete(Long id){
        User user = userRepository.findById(id).orElseThrow();
        if(user.isDeletedAt()){
            return user;
        }
        user.setDeletedAt(true);
        return userRepository.save(user);
    }
}