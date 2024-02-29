package com.example.LoginRegister.Service.impl;

import com.example.LoginRegister.Dto.UserDto;
import com.example.LoginRegister.Entity.User;
import com.example.LoginRegister.Repo.UserRepo;
import com.example.LoginRegister.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addUser(UserDto userDto) {

        User user = new User(
                userDto.getUserid(),
                userDto.getUsername(),
                userDto.getEmail(),
                 this.passwordEncoder.encode(userDto.getPassword())
        );
        userRepo.save(user);
        return user.getUsername();




    }
}
