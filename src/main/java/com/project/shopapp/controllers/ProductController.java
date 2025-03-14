package com.project.shopapp.controllers;


import ch.qos.logback.core.util.StringUtil;
import com.project.shopapp.dtos.ProductDTO;
import com.project.shopapp.dtos.ProductImageDTO;
import com.project.shopapp.exceptions.DataNotFoundException;
import com.project.shopapp.exceptions.InvalidParamException;
import com.project.shopapp.models.Product;
import com.project.shopapp.models.ProductImage;
import com.project.shopapp.services.IProductService;
import com.project.shopapp.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService productService;

    @GetMapping("") //localhost:8080/api/v1/products/?page=1&limit=10
    public ResponseEntity<String> getAllProducts(
            @RequestParam("page") int page,
            @RequestParam("limit") int limit
    ) {
        return ResponseEntity.ok(String.format("hien thi tat ca cac products page %d limit %d", page, limit));
    }

    @PostMapping(value = "")
    public ResponseEntity<?> createProduct(@Valid @RequestBody  ProductDTO productDTO,
//
                                            BindingResult result) {

        try {
            if(result.hasErrors()) {
                List<String> errorMessages = result.getFieldErrors()
                        .stream()
                        .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                        .toList();
                return ResponseEntity.badRequest().body(errorMessages);
            }
            Product newProduct = productService.createProduct(productDTO);

            return ResponseEntity.ok(newProduct);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping(value = "uploads/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> uploadImages(@PathVariable("id") Long productId, @ModelAttribute("file") List<MultipartFile> files)
    {
        Product existingProduct = null;
        try {
            existingProduct = productService.getProductById(productId);
            Product newProduct = productService.updateProduct(existingProduct.getId(), ProductDTO.builder()
                    .name(existingProduct.getName())
                    .price(existingProduct.getPrice())
                    .build());

            files = files == null ? List.of() : files;
            List<ProductImage> productImages = new ArrayList<>();
            for (MultipartFile file : files) {
                if (file.getSize() == 0) {
                    continue;
                }
                //kiem tra kich thuoc file va dinh dang
                if (file.getSize() > 10 * 1024 * 1024) {
//                    throw new ResponseStatusException(
//                            HttpStatus.PAYLOAD_TOO_LARGE, "kich thuoc file qua lon"
//                    );
                    return ResponseEntity.status(HttpStatus.PAYLOAD_TOO_LARGE)
                            .body("kich thuoc file qua lon");
                }
                String contentType = file.getContentType();
                if (contentType == null || !contentType.startsWith("image/")) {
                    return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
                            .body("file must be an image");
                }
                String fileName = storeFile(file);
                existingProduct.setThumbnail(fileName);

                //luu file vao bang product images
                ProductImage productImage = productService.createProductImage(newProduct.getId(), ProductImageDTO.builder()
                        .imageUrl(fileName)
                        .build());
                productImages.add(productImage);
            }
            return ResponseEntity.ok().body(productImages);
        } catch (DataNotFoundException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (InvalidParamException | IOException e) {
            throw new RuntimeException(e);
        }

    }


    private String storeFile(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        // tao ten file duy nhat
        String uniqueFileName = UUID.randomUUID().toString() + "_" + fileName;
        // luu file vao thu muc
        Path upLoadDir = Paths.get("uploads");
        // tao thu muc neu chua ton tai
        if (!Files.exists(upLoadDir)) {
            Files.createDirectory(upLoadDir);
        }
        // tao duong dan cua file
        Path destimation = Paths.get(upLoadDir.toString(), uniqueFileName);
        // copy file vao thu muc
        Files.copy(file.getInputStream(), destimation, StandardCopyOption.REPLACE_EXISTING);
        return uniqueFileName;
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
