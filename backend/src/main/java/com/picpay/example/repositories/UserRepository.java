package com.picpay.example.repositories;

import com.picpay.example.domain.User;
import com.picpay.example.domain.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    @Query(value = "SELECT u.id, u.name, u.username, (CASE WHEN p.priority = 1 THEN 1 WHEN p.priority = 2 THEN 2 ELSE 3 END) as priority FROM User u LEFT JOIN u.priority p ON u.id = p.id_user WHERE u.name like ?1% OR u.username like ?1% ORDER BY priority, u.name")
    List<User> findByNameOrUsername(String value);
//
//    @Query(value = "SELECT u.id, u.name, u.username, (CASE WHEN p.priority = 1 THEN 1 WHEN p.priority = 2 THEN 2 ELSE 3 END) as priority FROM User u LEFT JOIN u.priority p ON u.id = p.id_user WHERE u.name like ?1% OR u.username like ?1% ORDER BY priority, u.name")
//    Page<User> findByNameOrUsername(String value, Pageable pageable);

    @Query(value = "SELECT new com.picpay.example.domain.UserDTO(u.id, u.name, u.username, (CASE WHEN p.priority = 1 THEN 1 WHEN p.priority = 2 THEN 2 ELSE 3 END) as priority) FROM User u LEFT JOIN u.priority p ON u.id = p.id_user WHERE u.name like ?1% OR u.username like ?1% ORDER BY priority")
    Page<UserDTO> findByNameOrUsername(String value, Pageable pageable);

    @Query(value = "SELECT u.id, u.name, u.username, (CASE WHEN p.priority = 1 THEN 1 WHEN p.priority = 2 THEN 2 ELSE 3 END) as priority FROM User u LEFT JOIN u.priority p ON u.id = p.id_user WHERE u.name like %?1 OR u.username like %?1 ORDER BY priority, u.name")
    List<User> findByNameOrUsernameEndsWith(String value);

    @Query("select u.name from User u where u.name like %?1")
    List<User> findByNameEndsWith(String name);



}
