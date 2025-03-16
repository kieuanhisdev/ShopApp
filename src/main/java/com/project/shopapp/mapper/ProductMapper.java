package com.project.shopapp.mapper;

import com.project.shopapp.dto.request.ProductControllerRequest;
import com.project.shopapp.dto.response.ProductResponse;
import com.project.shopapp.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper {
    // Chuyển từ Request DTO sang Entity
    Product toProduct(ProductControllerRequest request);

    // Chuyển từ Entity sang Response DTO
    ProductResponse toProductResponse(Product product);
}
