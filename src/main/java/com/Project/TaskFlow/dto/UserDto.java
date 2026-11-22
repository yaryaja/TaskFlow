package com.Project.TaskFlow.dto;

import com.Project.TaskFlow.model.User;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    @NotBlank(message = "User name cannot be blank")
    private String name;
    private String designation;

    public User toEntity(){
        User user= new User();
        user.setName(this.name);
        user.setDesignation(this.designation);

        return user;
    }
}
