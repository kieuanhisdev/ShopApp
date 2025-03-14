package com.project.shopapp.mapper;

import com.project.shopapp.dto.request.UserControllerRequest;
import com.project.shopapp.dto.respone.UserRespone;
import com.project.shopapp.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toUser(UserControllerRequest request);
    UserRespone toUserRespone(User user);
}
