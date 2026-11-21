package com.Project.TaskFlow.Controller;

import com.Project.TaskFlow.Service.TaskService;
import com.Project.TaskFlow.dto.TaskDto;
import com.Project.TaskFlow.model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class TaskController {
    private  final TaskService taskService;

    public TaskController( TaskService taskService) {

        this.taskService=taskService;
    }


    @PostMapping("/api/project/{projectId}/tasks")
    public ResponseEntity<Task> createTask(@RequestBody TaskDto newTask, @PathVariable Long projectId){
        Task result=taskService.createTask(projectId,newTask);
        return  new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping("/api/tasks/{taskId}/assign/{projectId}")
    public ResponseEntity<Task>AssignTaskToProject(@RequestBody TaskDto newTask,@PathVariable Long taskId,@PathVariable Long projectId){
        Task result=taskService.assignTaskToProject(taskId,projectId,newTask);
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }

    //    List<Task> findByProjectId(Long projectId);


    @GetMapping("/api/projects/{projectId}/tasks")
    public ResponseEntity<List<Task>> getAllTask(@PathVariable Long projectId){
        List<Task> tasks=taskService.getTasksByProjectId(projectId);
        return new ResponseEntity<>(tasks,HttpStatus.OK);
    }
}
