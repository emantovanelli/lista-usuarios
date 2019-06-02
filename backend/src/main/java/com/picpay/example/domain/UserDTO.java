package com.picpay.example.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
public class UserDTO implements Serializable {
    String id;
    String name;
    String username;
    int priority;
}
