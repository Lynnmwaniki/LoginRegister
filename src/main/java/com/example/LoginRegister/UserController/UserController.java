package com.example.LoginRegister.UserController;

import com.example.LoginRegister.Dto.LogInDto;
import com.example.LoginRegister.Dto.UserDto;
import com.example.LoginRegister.Service.UserService;
import com.example.LoginRegister.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")


public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping(path ="/save")
    public String saveUser(@RequestBody UserDto userDto)
    {
        String id = userService.addUser(userDto);
        return id;
    }
    @PostMapping(path = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LogInDto logInDto)
    {
        LoginResponse loginResponse = userService.loginUser(logInDto);
        return ResponseEntity.ok(loginResponse);
    }

}
