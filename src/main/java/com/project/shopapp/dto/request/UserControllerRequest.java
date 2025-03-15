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
public class UserControllerRequest {

    @NotBlank(message = "Full name is required")
    @Size(min = 2, max = 100, message = "Full name must be between 2 and 100 characters")
    @JsonProperty("full_name")
    private String fullName;

    @NotBlank(message = "Username is required")
    @Size(min = 3, max = 50, message = "Username must be between 3 and 50 characters")
    @JsonProperty("username")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    @JsonProperty("password")
    private String password;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @JsonProperty("email")
    private String email;

    @NotBlank(message = "Gender is required")
    @JsonProperty("gender")
    private String gender;

    // Thêm trường date_of_birth kiểu LocalDate để nhất quán với entity
    @Past(message = "Date of birth must be in the past")
    @JsonProperty("date_of_birth")
    private LocalDate dateOfBirth;

    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid phone number format")
    @JsonProperty("phone_number")
    private String phoneNumber;

    @NotNull(message = "Role id is required")
    @JsonProperty("role_id")
    private Long roleId;
}
