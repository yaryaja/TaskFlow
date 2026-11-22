package com.Project.TaskFlow.Controller;

import com.Project.TaskFlow.Service.ProjectService;
import  com.Project.TaskFlow.dto.ProjectRequest;
import com.Project.TaskFlow.model.Project;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }


    @GetMapping("/api/projects")
    public List<Project> getProjects() {
        return projectService.getProject();
    }

    @GetMapping("/api/projects/{id}")
    public Project getProject(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }



    @PostMapping("/api/projects")
    public ResponseEntity<Project> createProject(@Valid @RequestBody ProjectRequest newProject){

        Project result=projectService.createProject(newProject);
        return new ResponseEntity<>(result, HttpStatus.CREATED);



    }

    @PutMapping("api/projects/{projectId}/members/{userId}")
    public ResponseEntity<Project> addMember(@PathVariable Long projectId, @PathVariable Long userId){
        Project updateProject= projectService.addMemberToProject(projectId,userId);
        return new ResponseEntity<>(updateProject,HttpStatus.OK);
    }





}
