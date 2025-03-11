package com.project.shopapp.dtos;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Data //tostroing
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @NotBlank(message = "name is required")
    @Size(min = 3, max = 200, message = "name must be between 3 and 200 characters")
    private String name;

    @Min(value = 0, message = "price must be greater than or equal to 0")
    @Max(value = 1000, message = "price must be less than or equal to 1000")
    private Float price;
    private String thumbnail;
    private String description;

    @JsonProperty("category_id")
    private String categoryId;

    private List<MultipartFile> files;
}
