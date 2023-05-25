package com.proyectoTaller1.taller1.repositories;

import com.proyectoTaller1.taller1.models.User;
import org.mapstruct.control.MappingControl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByDeletedAtFalse();
}
