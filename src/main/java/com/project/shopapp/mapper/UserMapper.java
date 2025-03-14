package com.project.shopapp.mapper;

import com.project.shopapp.dto.request.UserControllerRequest;
import com.project.shopapp.dto.request.UserUpdateRequest;
import com.project.shopapp.dto.response.UserResponse;
import com.project.shopapp.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {

    // Chuyển từ Request DTO sang Entity
    User toUser(UserControllerRequest request);

    // Chuyển từ Entity sang Response DTO
    @Mapping(source = "id", target = "id")
    @Mapping(source = "role.id", target = "roleId")
    UserResponse toUserResponse(User user);

//    @Mapping(source = "phoneNumber", target = "phoneNumber")
    User updateUser(@MappingTarget User user, UserUpdateRequest request);
}
