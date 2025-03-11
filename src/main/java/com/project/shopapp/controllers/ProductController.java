package com.project.shopapp.controllers;

import com.project.shopapp.dtos.CategoryDTO;
import com.project.shopapp.dtos.ProductDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {

    @PostMapping(value = "", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)

    @GetMapping("") //localhost:8080/api/v1/products/?page=1&limit=10
    public ResponseEntity<String> getAllProducts(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    ) {
        return ResponseEntity.ok(String.format("hien thi tat ca cac products page %d limit %d", page, limit));
    }

    @PostMapping("")
    public ResponseEntity<?> insertCategory(@Valid @RequestBody ProductDTO productDTO, BindingResult result) {

        try {
            if(result.hasErrors()) {
                List<String> errorMessages = result.getFieldErrors()
                        .stream()
                        .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                        .toList();
                return ResponseEntity.badRequest().body(errorMessages);
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("nhap cat product " + productDTO);
    }


    @GetMapping("/{id}") //localhost:8080/api/v1/products/1
    public ResponseEntity<String> getProductById(@PathVariable("id") String productId) {
        return ResponseEntity.ok("hien thi product " + productId);
    }

    @DeleteMapping("/{id}") //localhost:8080/api/v1/products/1
    public ResponseEntity<String> deleteProductById(@PathVariable("id") String productId) {
        return ResponseEntity.status(HttpStatus.OK).body("xoa product " + productId);
    }

}
