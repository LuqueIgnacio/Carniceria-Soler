package com.proyectoTaller1.taller1.services;

import com.proyectoTaller1.taller1.dtos.AdminProductDTO;
import com.proyectoTaller1.taller1.dtos.CustomerProductDTO;
import com.proyectoTaller1.taller1.mappers.AdminProductMapper;
import com.proyectoTaller1.taller1.mappers.CustomerProductMapper;
import com.proyectoTaller1.taller1.models.Product;
import com.proyectoTaller1.taller1.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CustomerProductMapper productMapper;
    private final AdminProductMapper adminProductMapper;

    public List<AdminProductDTO> findAll(){
        return productRepository.findAll().stream()
                .map(product -> adminProductMapper.toDTO(product, product.getCategory(), product.getBrands())).collect(Collectors.toList());
    }
    public List<CustomerProductDTO> findAllProductsToSale(){
        return productRepository.findByIsListedTrueAndDeletedAtFalseAndStockGreaterThan(0)
                .stream()
                .map(product -> productMapper.toDTO(product, product.getCategory(), product.getBrands())).collect(Collectors.toList());
    }
}