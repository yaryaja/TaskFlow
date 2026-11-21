package com.Project.TaskFlow.Service;

import com.Project.TaskFlow.Exception.ResourceNotFoundException;
import com.Project.TaskFlow.dto.TaskDto;
import com.Project.TaskFlow.model.Project;
import com.Project.TaskFlow.model.Task;
import com.Project.TaskFlow.model.User;
import com.Project.TaskFlow.repository.ProjectRepository;
import com.Project.TaskFlow.repository.TaskRepository;
import com.Project.TaskFlow.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    public TaskService(TaskRepository taskRepository, ProjectRepository projectRepository, UserRepository userRepository){
        this.projectRepository=projectRepository;
        this.taskRepository=taskRepository;
        this.userRepository=userRepository;
    }



    public Task createTask(Long projectId,TaskDto taskDto){
        Task task=taskDto.toEntity();
        Project foundProject=projectRepository.findById(projectId).orElseThrow(() ->new ResourceNotFoundException("project does not exist"));
        task.setProject(foundProject);
        return taskRepository.save(task);
    }
    public Task assignTaskToProject(Long taskId,Long userId,TaskDto taskDto){
//        Task task=taskDto.toEntity();
        Task task=taskRepository.findById(taskId).orElseThrow(()->new ResourceNotFoundException("Task do not exist"));
        User foundUser=userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User does not exist"));
        task.setAssignedUser(foundUser);
        return taskRepository.save(task);
    }

    public List<Task> getTasksByProjectId(Long projectId) {
        // Calling your custom derived method
        return taskRepository.findByProjectId(projectId);
    }
}
