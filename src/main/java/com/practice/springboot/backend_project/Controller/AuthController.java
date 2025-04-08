package com.practice.springboot.backend_project.Controller;


import com.practice.springboot.backend_project.Repository.UserRepository;
import com.practice.springboot.backend_project.Service.AuthService;
import com.practice.springboot.backend_project.Util.JwtUtil;
import com.practice.springboot.backend_project.request.AuthRequest;
import com.practice.springboot.backend_project.request.RegisterRequest;
import com.practice.springboot.backend_project.response.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AuthService authService;


    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        return authService.authenticate(request);
    }
}
