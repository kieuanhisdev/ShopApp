package com.project.shopapp.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class UserRespone {
    @JsonProperty("full_name")
    private String fullName;

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("date_of_birth")
    private LocalDate dateOfBirth;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("email")
    private String email;

    @JsonProperty("is_verified")
    private boolean isVerified = false;

    @JsonProperty("status")
    private boolean status = true;

    @JsonProperty("address")
    private String address;

    @JsonProperty("profile_picture")
    private String profilePicture;
//    Long roleId;
    @JsonProperty("roles")
    private String roles;
}
