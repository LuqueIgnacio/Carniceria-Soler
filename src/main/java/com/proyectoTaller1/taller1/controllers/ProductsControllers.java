package com.proyectoTaller1.taller1.controllers;

import com.proyectoTaller1.taller1.dtos.AdminProductDTO;
import com.proyectoTaller1.taller1.dtos.CustomerProductDTO;
import com.proyectoTaller1.taller1.models.Product;
import com.proyectoTaller1.taller1.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController("/")
@AllArgsConstructor
public class ProductsControllers {
    private final ProductService productService;

    @GetMapping("productsToSale")
    public ResponseEntity<List<CustomerProductDTO>> getAllProductsToSale(){
        return new ResponseEntity<>(productService.findAllProductsToSale(), HttpStatus.OK);
    }

    @GetMapping("products")
    public ResponseEntity<List<AdminProductDTO>> getAllProducts(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @PostMapping("products")
    public ResponseEntity<Void> createProduct(@Valid AdminProductDTO productDTO, Errors errors){
        try{
            if(errors.hasErrors()){
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
            }
            productService.createProduct(productDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }

    }
}