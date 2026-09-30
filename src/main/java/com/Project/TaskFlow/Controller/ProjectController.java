package com.Project.TaskFlow.Controller;
import com.Project.TaskFlow.Service.ProjectService;
import  com.Project.TaskFlow.dto.ProjectRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class ProjectController {
    private final ProjectService projectService;
    public ProjectController(ProjectService projectService){
        this.projectService=projectService;
    }


    @PostMapping("/api/projects")
    public ResponseEntity<String> createProject(@RequestBody ProjectRequest newProject){

        String result=projectService.createProject(newProject);
        return new ResponseEntity<>(result, HttpStatus.CREATED);



    }


}
