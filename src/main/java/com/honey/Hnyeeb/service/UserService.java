package com.honey.Hnyeeb.service;

import com.honey.Hnyeeb.dto.LoginResponse;
import com.honey.Hnyeeb.entity.Users;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    LoginResponse userLogin(Users user);
    Users createUser(Users user);
    Users updateUser(Long userId);
    Users deleteUser(Long userId);
    Users getUserById(Long userId);
    List<Users> getAllUsers();
}
