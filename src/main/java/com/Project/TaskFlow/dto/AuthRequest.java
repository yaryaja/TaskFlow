package com.Project.TaskFlow.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {
    private String email;
    private String password;
    // Generate getters and setters
}