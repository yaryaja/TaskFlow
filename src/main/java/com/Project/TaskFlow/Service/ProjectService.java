package com.Project.TaskFlow.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.Project.TaskFlow.dto.ProjectRequest;



@Service
public class ProjectService {

    public String createProject(ProjectRequest newProject){
        System.out.println("Processing project in service: " + newProject.getName());
        return "Project created successfully!";

    }


}
