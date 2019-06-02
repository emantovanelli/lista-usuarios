package com.picpay.example.controllers;

import com.picpay.example.domain.User;
import com.picpay.example.domain.UserDTO;
import com.picpay.example.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL = "/api/v1/users";

    private final UserService userService;

    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping()
    List<User> getAllUsers(){
        return userService.findAllUsers();
    }

    @GetMapping("/search/{value}/{page}")
    Page<UserDTO> getByNameOrUsername(@PathVariable String value, @PathVariable int page){
        String x = value;
        return userService.findByNameOrUsername(value, new PageRequest(page, 20));
    }
}
