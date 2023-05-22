package com.proyectoTaller1.taller1.repositories;

import com.proyectoTaller1.taller1.dtos.AdminProductDTO;
import com.proyectoTaller1.taller1.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByIsListedTrueAndDeletedAtFalseAndStockGreaterThan(int stock);

    @Modifying
    @Transactional
    @Query("UPDATE Product p SET p.code = :#{#product.code}, p.costPrice = :#{#product.costPrice}, p.isListed = :#{#product.isListed}," +
            "p.name = :#{#product.name}, p.price = :#{#product.price}, p.stock = :#{#product.stock}, p.brand = :#{#product.brand}," +
            "p.category = :#{#product.category}, p.deletedAt = :#{#product.deletedAt}, p.updatedAt = current_date " +
            "WHERE p.id = :#{#product.id}")
    int updateWithoutModifyImg(@Param("product")Product product);

    @Query("SELECT image FROM Product p WHERE p.id = :id")
    String getImage(@Param("id")Long id);
}
