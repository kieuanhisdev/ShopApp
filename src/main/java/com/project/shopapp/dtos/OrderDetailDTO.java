package com.project.shopapp.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

@Data //tostroing
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDTO {
    @JsonProperty("order_id")
    @Min(value = 1, message = "order id must be greater than 0")
    private long orderId;

    @JsonProperty("product_id")
    @Min(value = 1, message = "product id must be greater than 0")
    private long productId;

    @Min(value = 0, message = "price must be greater than or equal to 0")
    private float price;

    @JsonProperty("number_of_products")
    @Min(value = 1, message = "number_of_products must be >=0")
    private int numberOfProducts;

    @JsonProperty("total_money")
    @Min(value = 0, message = "total_money must be >= 0")
    private float totalMoney;

    private String color;
}
