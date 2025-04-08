package com.practice.springboot.backend_project.request;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
