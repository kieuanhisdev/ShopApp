package com.project.shopapp.mapper;

import com.project.shopapp.dto.request.UserControllerRequest;
import com.project.shopapp.dto.response.UserResponse;
import com.project.shopapp.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // Chuyển từ Request DTO sang Entity
    User toUser(UserControllerRequest request);

    // Chuyển từ Entity sang Response DTO
    @Mapping(source = "role.id", target = "roleId")
    UserResponse toUserResponse(User user);
}
