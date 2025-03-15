package com.project.shopapp.services;

import com.project.shopapp.dto.request.UserControllerRequest;

import com.project.shopapp.dto.response.UserResponse;
import com.project.shopapp.entity.Role;
import com.project.shopapp.exception.AppException;
import com.project.shopapp.exception.ErrorCode;
import com.project.shopapp.exceptions.DataNotFoundException;
import com.project.shopapp.entity.User;
import com.project.shopapp.mapper.UserMapper;
import com.project.shopapp.repositories.RoleRepository;
import com.project.shopapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;
//    private final PasswordEncoderService passwordEncoder;

    public UserResponse createUser(UserControllerRequest request) throws DataNotFoundException {
        Optional<User> existingUser = userRepository.findByUsernameOrEmail(request.getUsername(), request.getEmail());
        // Kiem tra xem username hoac email da ton tai chua
        if (existingUser.isPresent()) {
            User userFound = existingUser.get();
            if (userFound.getUsername().equals(request.getUsername())) {
                throw new AppException(ErrorCode.USER_EXISTED);
            } else if (userFound.getEmail().equals(request.getEmail())) {
                throw new AppException(ErrorCode.EMAIL_EXISTED);
            }
        }
        // Kiểm tra role tồn tại
        Role role = roleRepository.findById(request.getRoleId())
                .orElseThrow(() -> new AppException(ErrorCode.ROLE_NOT_FOUND));

        // Chuyển đổi DTO thành Entity (sử dụng mapper hoặc tự mapping)
        User user = userMapper.toUser(request);

        // Mã hóa password nếu cần
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        user.setPassword(passwordEncoder.encode(request.getPassword()));

        // Gán role cho user
        user.setRole(role);

        // Lưu user vào database
        User savedUser = userRepository.save(user);

        // Chuyển đổi entity sang response DTO
        return userMapper.toUserResponse(savedUser);
    }
}
