package com.Project.TaskFlow.Service;

import com.Project.TaskFlow.Exception.ResourceNotFoundException;
import com.Project.TaskFlow.dto.ProjectRequest;
import com.Project.TaskFlow.model.Project;
import com.Project.TaskFlow.model.User;
import com.Project.TaskFlow.repository.ProjectRepository;
import com.Project.TaskFlow.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProjectService {
    private  final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    public ProjectService(ProjectRepository repository, UserRepository Userrepository){
        this.projectRepository=repository;
        this.userRepository=Userrepository;
    }



    public Project createProject(ProjectRequest newProject){
        Project project = newProject.toEntity();
        return projectRepository.save(project);

    }

    public List<Project> getProject(){
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id){
        return projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id: " + id));
    }
    public Project addMemberToProject(Long projectId, Long userId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        project.getMembers().add(user);
        return projectRepository.save(project);
    }



}
