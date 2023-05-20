package com.proyectoTaller1.taller1.repositories;

import com.proyectoTaller1.taller1.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByIsListedTrueAndDeletedAtFalseAndStockGreaterThan(int stock);
}
