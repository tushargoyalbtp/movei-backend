package com.practice.springboot.backend_project.Service.Implementation;

import com.practice.springboot.backend_project.Model.User;
import com.practice.springboot.backend_project.Repository.UserRepository;
import com.practice.springboot.backend_project.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired private UserRepository userRepository;


    /**
     * @param user
     * @return
     */
    @Override
    public User createUser(User user) {
       return userRepository.save(user);
    }
}
