package com.project.shopapp.services;

import com.project.shopapp.dto.UserDTO;
import com.project.shopapp.dto.request.UserControllerRequest;
import com.project.shopapp.dto.respone.UserRespone;
import com.project.shopapp.exceptions.DataNotFoundException;
import com.project.shopapp.entity.Role;
import com.project.shopapp.entity.User;
import com.project.shopapp.mapper.UserMapper;
import com.project.shopapp.repositories.RoleRepository;
import com.project.shopapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;


    public UserRespone createUser(UserControllerRequest request) throws DataNotFoundException {
        String phoneNumber = request.getPhoneNumber();
        //kiem tra xem co sdt da dang ky chua
        if(userRepository.existsByPhoneNumber(phoneNumber)){
            throw new DataIntegrityViolationException("phone number already exists");
        }
        User newUser = userMapper.toUser(request);
//        Role role = roleRepository.findById(request.getRoleId())
//                .orElseThrow(()-> new DataNotFoundException("role not found"));
//        newUser.setRole(role);
        newUser.setActive(true);
        //kiem tra neu co accountid, khong yeu cau password
        if(request.getFacebookAccountId()==0 && request.getGoogleAccountId()==0){
            String password = request.getPassword();
            //String encodeePassword = passwordEncoder.encode(password);
            //newUser.setPassword(encodeePassword);
        }
        return userMapper.toUserRespone(userRepository.save(newUser));
    }


    public String login(String phoneNumber, String password) {
        return null;
    }
}
