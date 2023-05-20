package com.proyectoTaller1.taller1.controllers;

import com.proyectoTaller1.taller1.dtos.CustomerProductDTO;
import com.proyectoTaller1.taller1.models.Product;
import com.proyectoTaller1.taller1.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
@AllArgsConstructor
public class ProductsControllers {
    private final ProductService productService;

    @GetMapping("productsToSale")
    public ResponseEntity<List<CustomerProductDTO>> getAllProducts(){
        return new ResponseEntity<>(productService.findAllProductsToSale(), HttpStatus.OK);
    }
}