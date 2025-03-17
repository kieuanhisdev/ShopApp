package com.project.shopapp.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ShoppingCartControllerRequest {

    @JsonProperty("id")
    Long id;

    @NotBlank(message = "User id must not be blank")
    @JsonProperty("user_id")
    String userId;

    @NotNull(message = "Created at must not be null")
    @JsonProperty("created_at")
    LocalDateTime createdAt;
}