package com.project.shopapp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("phone_number")
    @NotBlank(message = "phone number is required")
    private String phoneNumber;

//    @NotBlank(message = "email is required")
    private String address;

    @NotBlank(message = "password cannot be empty")
    private String password;

    @JsonProperty("retype_password")
    private String retypePassword;

    @JsonProperty("date_of_birth")
    private Date dateOfBirth;

    @JsonProperty("facebook_account_id")
    private int facebookAccountId;

    @JsonProperty("google_account_id")
    private int googleAccountId;

    @NotNull(message = "role id is required")
    @JsonProperty("role_id")
    private Long roleId;
}
