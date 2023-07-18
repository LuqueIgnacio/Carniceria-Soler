package com.proyectoTaller1.taller1.repositories;

import com.proyectoTaller1.taller1.models.Product;
import com.proyectoTaller1.taller1.models.User;
import org.mapstruct.control.MappingControl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByDeletedAtFalse();

    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.address = :#{#user.address}, u.dni = :#{#user.dni}," +
            "u.email = :#{#user.email}, u.deletedAt = :#{#user.deletedAt}, u.lastName = :#{#user.lastName}, " +
            "u.name = :#{#user.name}, u.phone = :#{#user.phone}, u.role = :#{#user.role} " +
            "WHERE u.id = :#{#user.id}")
    int updateWithoutModifyPassword(@Param("user")User user);
}
