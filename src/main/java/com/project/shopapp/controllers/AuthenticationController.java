package com.project.shopapp.controllers;

import com.project.shopapp.dto.request.AuthenticationRequest;
import com.project.shopapp.dto.response.ApiResponse;
import com.project.shopapp.dto.response.AuthenticationResponse;
import com.project.shopapp.services.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {

    AuthenticationService authenticationService;

    @PostMapping("/login")
    ApiResponse<AuthenticationResponse> authentication(@RequestBody AuthenticationRequest request) {
        boolean result = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder()
                .data(AuthenticationResponse
                        .builder()
                        .authenticated(result)
                        .build())
                .build();
    }
}
