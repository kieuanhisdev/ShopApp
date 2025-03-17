package com.project.shopapp.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("username")
    private String username;


    @JsonProperty("date_of_birth")
    private LocalDate dateOfBirth;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("email")
    private String email;

    @JsonProperty("is_verified")
    private boolean isVerified;

    @JsonProperty("status")
    private boolean status;

    @JsonProperty("address")
    private String address;

    @JsonProperty("profile_picture")
    private String profilePicture;

    @JsonProperty("role_id")
    private Long roleId;
}
