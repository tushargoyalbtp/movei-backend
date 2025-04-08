package com.practice.springboot.backend_project.Repository;

import com.practice.springboot.backend_project.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    // ⭐ Find user by email
    Optional<User> findByEmail(String email);

    // ⭐ Check if email already exists
    boolean existsByEmail(String email);

    boolean existsByUserName(String username);
}
