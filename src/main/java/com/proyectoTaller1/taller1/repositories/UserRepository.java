package com.proyectoTaller1.taller1.repositories;

import com.proyectoTaller1.taller1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
