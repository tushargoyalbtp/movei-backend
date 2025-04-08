package com.practice.springboot.backend_project.Service;

import com.practice.springboot.backend_project.Model.Movie;
import com.practice.springboot.backend_project.Model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService  {
    User createUser(User user);
}
