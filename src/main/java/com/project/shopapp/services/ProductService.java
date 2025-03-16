package com.project.shopapp.services;

import com.project.shopapp.dto.request.ProductControllerRequest;
import com.project.shopapp.dto.response.ProductResponse;
import com.project.shopapp.entity.Product;
import com.project.shopapp.mapper.ProductMapper;
import com.project.shopapp.repositories.ProductRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductService {

    ProductMapper productMapper;
    ProductRepository productRepository;

    public ProductResponse createProduct(ProductControllerRequest request) {
        //chuyen doi request thanh entity
        Product newProduct = productMapper.toProduct(request);
        //luu entity vao database
        productRepository.save(newProduct);
        //chuyen doi entity thanh response
        return productMapper.toProductResponse(newProduct);
    }

}
