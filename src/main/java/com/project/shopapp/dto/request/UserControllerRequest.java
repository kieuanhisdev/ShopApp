package com.project.shopapp.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserControllerRequest {
    @JsonProperty("full_name")
    String fullName;

    @JsonProperty("phone_number")
    @NotBlank(message = "phone number is required")
    String phoneNumber;
    //    @NotBlank(message = "email is required")
    String address;

    @NotBlank(message = "password cannot be empty")
    String password;

    @JsonProperty("retype_password")
    String retypePassword;

    @JsonProperty("date_of_birth")
    Date dateOfBirth;

    @JsonProperty("facebook_account_id")
    int facebookAccountId;

    @JsonProperty("google_account_id")
    int googleAccountId;

//    @NotNull(message = "role id is required")
//    @JsonProperty("role_id")
//    Long roleId;
}
