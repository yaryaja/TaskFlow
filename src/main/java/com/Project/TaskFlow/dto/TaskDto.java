package com.Project.TaskFlow.dto;

import com.Project.TaskFlow.model.Task;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDto {
    @NotBlank(message = "Task title cannot be blank")
    private String title;
    private String status;

    public Task toEntity(){
        Task task= new Task();
        task.setStatus(this.status);
        task.setTitle(this.title);
        return task;
    }
}
