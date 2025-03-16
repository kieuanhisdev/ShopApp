package com.project.shopapp.controllers;

import com.project.shopapp.dto.request.ProductControllerRequest;
import com.project.shopapp.dto.response.ApiResponse;
import com.project.shopapp.dto.response.ProductResponse;
import com.project.shopapp.services.ProductService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductController {

    ProductService productService;

    @GetMapping("/products")
    public String getProducts() {
        return "products";
    }

    @PostMapping("/create")
    public ApiResponse<ProductResponse> createProduct(@Valid @RequestBody ProductControllerRequest request) {
        ApiResponse<ProductResponse> response = new ApiResponse<>();
        response.setData(productService.createProduct(request));
        return response;
    }

}
