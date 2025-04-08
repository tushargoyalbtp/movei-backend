package com.practice.springboot.backend_project.Service;

import com.practice.springboot.backend_project.request.AuthRequest;
import com.practice.springboot.backend_project.request.RegisterRequest;
import com.practice.springboot.backend_project.response.AuthResponse;

public interface AuthService {

    AuthResponse authenticate(AuthRequest request);
    AuthResponse register(RegisterRequest request);
}
