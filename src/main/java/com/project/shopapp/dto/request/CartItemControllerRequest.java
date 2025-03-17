package com.project.shopapp.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartItemControllerRequest {

    @JsonProperty("id")
    private Long id;

    @NotNull(message = "Shopping cart id must not be null")
    @JsonProperty("shopping_cart_id")
    private Long shoppingCartId;

    @NotNull(message = "Product id must not be null")
    @JsonProperty("product_id")
    private Long productId;

    @NotNull(message = "Quantity must not be null")
    @Min(value = 1, message = "Quantity must be at least 1")
    @JsonProperty("quantity")
    private Integer quantity;
}