package com.picpay.example.services;

import com.picpay.example.domain.User;
import com.picpay.example.domain.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface UserService {

    User findUserById(UUID id);
    List<User> findAllUsers();

    List<User> findByNameOrUsername(String value);

//    Page<User> findByNameOrUsername(String value, Pageable pageable);

    Page<UserDTO> findByNameOrUsername(String value, Pageable pageable);

    //List<User> findByNameOrUsernameEndsWith(String value);

    List<User> findByNameEndsWith(String name);

    List<User> findByNameOrUsernameEndsWith(String value);
}
