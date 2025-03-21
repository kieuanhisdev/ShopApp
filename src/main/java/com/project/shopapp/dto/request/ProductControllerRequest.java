package com.project.shopapp.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductControllerRequest {

    @JsonProperty("id")
    private Long id;

    @NotNull(message = "Product name must not be null")
    @Size(max = 100, message = "Product name must be at most 100 characters")
    @JsonProperty("product_name")
    private String productName;

    @JsonProperty("product_image")
    private String productImage;

    @NotNull(message = "Quantity must not be null")
    @Min(value = 0, message = "Quantity must be at least 0")
    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("description")
    private String description;

    @NotNull(message = "Price must not be null")
    @DecimalMin(value = "0.0", inclusive = true, message = "Price must be at least 0.0")
    @JsonProperty("price")
    private Double price;

    @NotBlank(message = "Category must not be blank")
    @JsonProperty("category")
    private String category;

    @NotNull(message = "Status must not be null")
    @JsonProperty("status")
    private Boolean status;

    @NotNull(message = "Import date must not be null")
    @JsonProperty("import_date")
    private LocalDate importDate;
}
