package com.project.shopapp.services;

import com.project.shopapp.dto.UserDTO;
import com.project.shopapp.exceptions.DataNotFoundException;
import com.project.shopapp.entity.User;

public interface IUserService {

    User createUser(UserDTO userDTO) throws DataNotFoundException;

    String login(String phoneNumber, String password);
}
