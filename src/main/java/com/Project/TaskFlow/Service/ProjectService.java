package com.Project.TaskFlow.Service;

import com.Project.TaskFlow.model.Project;
import com.Project.TaskFlow.repository.ProjectRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.Project.TaskFlow.dto.ProjectRequest;
import com.Project.TaskFlow.repository.ProjectRepository;


@Service
public class ProjectService {
    private  final ProjectRepository projectRepository;
    public ProjectService(ProjectRepository repository){
        this.projectRepository=repository;
    }



    public Project createProject(ProjectRequest newProject){
        Project project = newProject.toEntity();
        return projectRepository.save(project);

    }


}
