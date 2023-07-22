package com.proyectoTaller1.taller1.services;

import com.proyectoTaller1.taller1.dtos.AdminProductDTO;
import com.proyectoTaller1.taller1.dtos.CustomerProductDTO;
import com.proyectoTaller1.taller1.mappers.AdminProductMapper;
import com.proyectoTaller1.taller1.mappers.CustomerProductMapper;
import com.proyectoTaller1.taller1.models.Product;
import com.proyectoTaller1.taller1.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final CustomerProductMapper productMapper;
    private final AdminProductMapper adminProductMapper;
    private final String imagesPath = new File("").getAbsolutePath() + "/src/main/resources/productsImages/";

    public List<AdminProductDTO> findAll(){
        return productRepository.findAll().stream()
                .map(product -> adminProductMapper.toDTO(product, product.getCategory(), product.getBrand())).collect(Collectors.toList());
    }

    public List<CustomerProductDTO> findAllProductsToSale(){
        return productRepository.findByIsListedTrueAndDeletedAtFalseAndStockGreaterThan(0)
                .stream()
                .map(product -> productMapper.toDTO(product, product.getCategory(), product.getBrand())).collect(Collectors.toList());
    }

    public AdminProductDTO findById(Long id) throws RuntimeException{
        Product product = productRepository.findById(id).orElseThrow(RuntimeException::new);
        return adminProductMapper.toDTO(product, product.getCategory(), product.getBrand());
    }

    public boolean createProduct(AdminProductDTO adminProductDTO){
        try {
            setImgToProduct(adminProductDTO);
            productRepository.save(adminProductMapper.toModel(adminProductDTO, adminProductDTO.getCategory(), adminProductDTO.getBrand()));
            saveImg(adminProductDTO);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    public boolean updateProduct(AdminProductDTO adminProductDTO){
        try {
            if(adminProductDTO.getImageFile() == null){
                productRepository.updateWithoutModifyImg(adminProductMapper.toModel(adminProductDTO, adminProductDTO.getCategory(), adminProductDTO.getBrand()));
            }else{
                deletePreviousImg(adminProductDTO);
                setImgToProduct(adminProductDTO);
                productRepository.save(adminProductMapper.toModel(adminProductDTO, adminProductDTO.getCategory(), adminProductDTO.getBrand()));
                saveImg(adminProductDTO);
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean deleteProduct(Long id) throws RuntimeException{
        Product product = productRepository.findById(id).orElseThrow(RuntimeException::new);
        product.setDeletedAt(true);
        productRepository.save(product);
        return true;
    }
    public void deletePreviousImg(AdminProductDTO adminProductDTO){
        new File(imagesPath + productRepository.getImage(adminProductDTO.getId())).delete();
    }

    public void saveImg(AdminProductDTO adminProductDTO) throws IOException, IllegalStateException{
        adminProductDTO.getImageFile().transferTo(new File(imagesPath + adminProductDTO.getImage()));
    }

    public void setImgToProduct(AdminProductDTO adminProductDTO){
        adminProductDTO.setImage(this.randomImgName());
    }

    public String randomImgName(){
        return UUID.randomUUID().toString() + ".jpg";
    }
}