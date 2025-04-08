package com.practice.springboot.backend_project.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
public class AuthResponse {
    private String token;
}
