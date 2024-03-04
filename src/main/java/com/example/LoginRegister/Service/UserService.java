package com.example.LoginRegister.Service;

import com.example.LoginRegister.Dto.LogInDto;
import com.example.LoginRegister.Dto.UserDto;
import com.example.LoginRegister.response.LoginResponse;

public interface UserService {
    String addUser(UserDto userDto);

    LoginResponse loginUser(LogInDto logInDto);


}
