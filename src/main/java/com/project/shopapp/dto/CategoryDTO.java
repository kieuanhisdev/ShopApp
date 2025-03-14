package com.project.shopapp.dto;


import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data //tostroing
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    @NotEmpty(message = "name is required")
    private String name;
    private long id;
}
