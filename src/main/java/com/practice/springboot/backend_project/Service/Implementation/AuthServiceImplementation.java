package com.practice.springboot.backend_project.Service.Implementation;

import com.practice.springboot.backend_project.Model.Role;
import com.practice.springboot.backend_project.Repository.UserRepository;
import com.practice.springboot.backend_project.Service.AuthService;
import com.practice.springboot.backend_project.Util.JwtUtil;
import com.practice.springboot.backend_project.Model.User;
import com.practice.springboot.backend_project.request.AuthRequest;
import com.practice.springboot.backend_project.request.RegisterRequest;
import com.practice.springboot.backend_project.response.AuthResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Service
public class AuthServiceImplementation implements AuthService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;


    /**
     * @param request
     * @return
     */
    @Override
    public AuthResponse authenticate(AuthRequest request) {

        Optional<User> userOptional = userRepository.findByEmail(request.getEmail());

        if (userOptional.isEmpty()) {
            throw new RuntimeException("Invalid email or password!");
        }

        User user = userOptional.get();

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password!");
        }

        String token = jwtUtil.generateToken(user.getEmail());

        return AuthResponse.builder()
                .token(token)
                .build();
    }

    /**
     * @param request
     * @return
     */
    @Override
    public AuthResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already registered!");
        }

        if (userRepository.existsByUserName(request.getUsername())) {
            throw new RuntimeException("Username already taken!");
        }

        User user = User.builder()
                .email(request.getEmail())
                .userName(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.ROLE_USER) // default role as USER
                .build();

        userRepository.save(user);

        String token = jwtUtil.generateToken(user.getEmail());

        return AuthResponse.builder()
                .token(token)
                .build();
    }

}
