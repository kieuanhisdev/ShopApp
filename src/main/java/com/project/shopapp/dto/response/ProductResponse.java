package com.project.shopapp.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("product_image")
    private String productImage;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("description")
    private String description;

    @JsonProperty("price")
    private Double price;

    @JsonProperty("category")
    private String category;

    @JsonProperty("status")
    private Boolean status;

    @JsonProperty("import_date")
    private LocalDate importDate;

}
