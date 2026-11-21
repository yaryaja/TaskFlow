package com.Project.TaskFlow.Controller;

import com.Project.TaskFlow.Service.TaskService;
import com.Project.TaskFlow.dto.TaskDto;
import com.Project.TaskFlow.model.Task;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;


@Controller
public class TaskController {
    private  final TaskService taskService;

    public TaskController( TaskService taskService) {

        this.taskService=taskService;
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleNotFound(RuntimeException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
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
}
