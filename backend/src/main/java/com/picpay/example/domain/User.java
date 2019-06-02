package com.picpay.example.domain;

import lombok.Data;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name= "name")
    private String name;

    @Column(name = "username")
    private String username;

    @OneToOne(cascade=CascadeType.ALL, mappedBy="id_user")
    private Priority priority;
}
