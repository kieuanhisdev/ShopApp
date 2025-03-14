package com.project.shopapp.dto.respone;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class UserRespone {
    String fullName;
    String phoneNumber;
    String address;
    String password;
    String retypePassword;
    Date dateOfBirth;
    int facebookAccountId;
    int googleAccountId;
//    Long roleId;
}
