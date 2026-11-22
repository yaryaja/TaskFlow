package com.Project.TaskFlow.Controller;

import com.Project.TaskFlow.Service.TaskService;
import com.Project.TaskFlow.dto.TaskDto;
import com.Project.TaskFlow.model.Task;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TaskController {
    private  final TaskService taskService;

    public TaskController( TaskService taskService) {

        this.taskService=taskService;
    }


    @PostMapping("/api/project/{projectId}/tasks")
    public ResponseEntity<Task> createTask(@Valid @RequestBody TaskDto newTask,@Valid @PathVariable Long projectId){
        Task result=taskService.createTask(projectId,newTask);
        return  new ResponseEntity<>(result, HttpStatus.CREATED);
    }
    @PutMapping("/api/tasks/{taskId}/assign/{projectId}")
    public ResponseEntity<Task>AssignTaskToProject(@RequestBody TaskDto newTask,@PathVariable Long taskId,@PathVariable Long projectId){
        Task result=taskService.assignTaskToProject(taskId,projectId,newTask);
        return new ResponseEntity<>(result,HttpStatus.CREATED);
    }



    @GetMapping("/api/projects/{projectId}/tasks")
    public ResponseEntity<Page<Task>> getAllTask(@PathVariable Long projectId,@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable){
        Page<Task> tasks=taskService.getTasksByProjectId(projectId,pageable);
        return new ResponseEntity<>(tasks,HttpStatus.OK);
    }

    @PatchMapping("/api/tasks/{taskId}/status")
    public ResponseEntity<Task> updateTaskStatus(@PathVariable Long taskId, @RequestBody TaskDto taskdto){
    String taskStatus=taskdto.getStatus();
    Task task=taskService.updateTaskStatus(taskId,taskStatus);
    return new ResponseEntity<>(task,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/api/tasks/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId){
        taskService.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }
}
