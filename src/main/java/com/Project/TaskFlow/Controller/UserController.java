package com.Project.TaskFlow.Controller;

import com.Project.TaskFlow.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import com.Project.TaskFlow.model.User;
import  com.Project.TaskFlow.dto.UserDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    private  final UserService userService;

    public UserController( UserService userService) {

        this.userService=userService;
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleNotFound(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @PostMapping("/api/Users")
    public ResponseEntity<User> createUser(@RequestBody UserDto newUser){
        User result=userService.createUser(newUser);
        return  new ResponseEntity<>(result, HttpStatus.CREATED);
    }
}
