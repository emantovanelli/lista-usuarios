package com.picpay.example.services;

import com.picpay.example.domain.User;
import com.picpay.example.domain.UserDTO;
import com.picpay.example.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findUserById(UUID id) {
        return userRepository.findById(id).get();
    }

    @Override
    public List<User> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

    @Override
    public List<User> findByNameOrUsername(String value) {

        return userRepository.findByNameOrUsername(value);
    }

    @Override
    public Page<UserDTO> findByNameOrUsername(String value, Pageable pageable) {
        return userRepository.findByNameOrUsername(value, pageable);
    }

    @Override
    public List<User> findByNameEndsWith(String name) {
        return userRepository.findByNameEndsWith(name);
    }


    @Override
    public List<User> findByNameOrUsernameEndsWith(String value) {
        return userRepository.findByNameOrUsernameEndsWith(value);
    }


}
