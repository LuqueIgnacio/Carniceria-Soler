package com.proyectoTaller1.taller1.controllers;

import com.proyectoTaller1.taller1.dtos.AdminProductDTO;
import com.proyectoTaller1.taller1.dtos.CustomerProductDTO;
import com.proyectoTaller1.taller1.services.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/")
@AllArgsConstructor
public class ProductsController {
    private final ProductService productService;

    @GetMapping("productsToSale")
    public ResponseEntity<List<CustomerProductDTO>> getAllProductsToSale(){
        return new ResponseEntity<>(productService.findAllProductsToSale(), HttpStatus.OK);
    }

    @GetMapping("products")
    public ResponseEntity<List<AdminProductDTO>> getAllProducts(){
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @GetMapping("products/{id}")
    public ResponseEntity<AdminProductDTO> getProduct(@PathVariable Long id){
        try{
            return new ResponseEntity<>(productService.findById(id), HttpStatus.OK);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
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

    @PutMapping("products/{id}")
    public ResponseEntity<Void> updateProduct(@Valid AdminProductDTO productDTO, Errors errors){
        try{
            if(errors.hasErrors()){
                return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
            }
            productService.updateProduct(productDTO);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
    }

    @DeleteMapping("products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        try{
            if(productService.deleteProduct(id)){
                return ResponseEntity.status(HttpStatus.OK).build();
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}