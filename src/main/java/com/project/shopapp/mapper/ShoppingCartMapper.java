package com.project.shopapp.mapper;

import com.project.shopapp.dto.request.ShoppingCartControllerRequest;
import com.project.shopapp.dto.response.ShoppingCartResponse;
import com.project.shopapp.entity.ShoppingCart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ShoppingCartMapper {
    // Chuyển từ Request DTO sang Entity
    // Lưu ý: Trường "user" và "cartItems" được ignore, sẽ được set ở tầng service
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "cartItems", ignore = true)
    ShoppingCart toShoppingCart(ShoppingCartControllerRequest request);

    // Chuyển từ Entity sang Response DTO
    // Map trường user.id thành userId
    @Mapping(source = "user.id", target = "userId")
    ShoppingCartResponse toShoppingCartResponse(ShoppingCart shoppingCart);

    // Cập nhật ShoppingCart với dữ liệu từ Request DTO
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "cartItems", ignore = true)
    ShoppingCart updateShoppingCart(@MappingTarget ShoppingCart shoppingCart, ShoppingCartControllerRequest request);
}