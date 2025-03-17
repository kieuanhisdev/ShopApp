package com.project.shopapp.mapper;

import com.project.shopapp.dto.request.CartItemControllerRequest;
import com.project.shopapp.dto.response.CartItemResponse;
import com.project.shopapp.entity.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CartItemMapper {
    // Chuyển từ Request DTO sang Entity
    // Lưu ý: Trường "shoppingCart" và "product" được ignore, sẽ được set ở tầng service
    @Mapping(target = "shoppingCart", ignore = true)
    @Mapping(target = "product", ignore = true)
    CartItem toCartItem(CartItemControllerRequest request);

    // Chuyển từ Entity sang Response DTO
    // Map các trường liên quan tới shoppingCart và product
    @Mapping(source = "shoppingCart.id", target = "shoppingCartId")
    @Mapping(source = "product.id", target = "productId")
    CartItemResponse toCartItemResponse(CartItem cartItem);

    // Cập nhật CartItem với dữ liệu từ Request DTO
    @Mapping(target = "shoppingCart", ignore = true)
    @Mapping(target = "product", ignore = true)
    CartItem updateCartItem(@MappingTarget CartItem cartItem, CartItemControllerRequest request);
}