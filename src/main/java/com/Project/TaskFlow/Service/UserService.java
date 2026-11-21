package com.Project.TaskFlow.Service;

import com.Project.TaskFlow.dto.UserDto;
import com.Project.TaskFlow.model.User;
import com.Project.TaskFlow.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    };

    public User createUser(UserDto newUser){
        User user=newUser.toEntity();
        return userRepository.save(user);
    };

}
