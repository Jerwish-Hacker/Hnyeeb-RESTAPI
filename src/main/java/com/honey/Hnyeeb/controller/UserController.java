package com.honey.Hnyeeb.controller;

import com.honey.Hnyeeb.dto.LoginResponse;
import com.honey.Hnyeeb.entity.Users;
import com.honey.Hnyeeb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/users")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public Users createUser(@RequestBody Users user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody Users user) {
        return userService.userLogin(user);
//        return  loginResponse;
    }
}
