package com.example.LoginRegister.Service.impl;

import com.example.LoginRegister.Dto.LogInDto;
import com.example.LoginRegister.Dto.UserDto;
import com.example.LoginRegister.appuser.User;
import com.example.LoginRegister.Repo.UserRepo;
import com.example.LoginRegister.Service.UserService;
import com.example.LoginRegister.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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

    @Override
    public LoginResponse loginUser(LogInDto logInDto) {
        String msg = "";
        User user1 = userRepo.findByEmail(logInDto.getEmail());
        if (user1 != null) {
            String password = logInDto.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userRepo.findOneByEmailAndPassword(logInDto.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginResponse("Login successful", true);

                } else {
                    return new LoginResponse("login failed", false);
                }
            } else {
                return new LoginResponse("Password not matched", false);
            }
        } else {
            return new LoginResponse("Email doesn't exist", false);
        }
    }
}

