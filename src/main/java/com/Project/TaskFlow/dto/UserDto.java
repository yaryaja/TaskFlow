package com.Project.TaskFlow.dto;

import com.Project.TaskFlow.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String name;
    private String designation;

    public User toEntity(){
        User user= new User();
        user.setName(this.name);
        user.setDesignation(this.designation);

        return user;
    }
}
