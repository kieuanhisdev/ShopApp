package com.project.shopapp.controllers;


import com.project.shopapp.dto.request.UserControllerRequest;
import com.project.shopapp.dto.request.UserUpdateRequest;
import com.project.shopapp.dto.response.ApiResponse;
import com.project.shopapp.dto.response.UserResponse;
import com.project.shopapp.exceptions.DataNotFoundException;
import com.project.shopapp.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ApiResponse<UserResponse> createUser(@Valid @RequestBody UserControllerRequest request){
            ApiResponse<UserResponse> response = new ApiResponse<>();
            response.setData(userService.createUser(request));
            return response;
    }

    @GetMapping("/{id}")
    public ApiResponse<UserResponse> getUserById(@PathVariable String id){
        ApiResponse<UserResponse> response = new ApiResponse<>();
        response.setData(userService.getUserById(id));
        return response;
    }

    @GetMapping
    public ApiResponse<List<UserResponse>> getAllUsers(){
        ApiResponse<List<UserResponse>> response = new ApiResponse<>();
        response.setData(userService.getAllUsers());
        return response;
    }

    @PutMapping("/{id}")
    public ApiResponse<UserResponse> updateUser(@PathVariable String id, @RequestBody UserUpdateRequest request) {
        ApiResponse<UserResponse> response = new ApiResponse<>();
        userService.updateUser(id, request);
        response.setData(userService.getUserById(id));
        return response;
    }


    @DeleteMapping("/{id}")
    String deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return "deleted successfully";
    }


}
