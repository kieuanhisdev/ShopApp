package com.project.shopapp.services;

import com.project.shopapp.dto.request.UserControllerRequest;

import com.project.shopapp.dto.response.UserResponse;
import com.project.shopapp.entity.Role;
import com.project.shopapp.exceptions.DataNotFoundException;
import com.project.shopapp.entity.User;
import com.project.shopapp.mapper.UserMapper;
import com.project.shopapp.repositories.RoleRepository;
import com.project.shopapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
//    private final PasswordEncoderService passwordEncoder;

    public UserResponse createUser(UserControllerRequest request) throws DataNotFoundException {
        // Kiểm tra role tồn tại
        Role role = roleRepository.findById(request.getRoleId())
                .orElseThrow(() -> new DataNotFoundException("Role not found"));

        // Chuyển đổi DTO thành Entity (sử dụng mapper hoặc tự mapping)
        User user = userMapper.toUser(request);

        // Mã hóa password nếu cần
//        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // Gán role cho user
        user.setRole(role);

        // Lưu user vào database
        User savedUser = userRepository.save(user);

        // Chuyển đổi entity sang response DTO
        return userMapper.toUserResponse(savedUser);
    }
}
