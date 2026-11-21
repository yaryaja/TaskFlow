package com.Project.TaskFlow.dto;

import com.Project.TaskFlow.model.Task;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskDto {
    private String title;
    private String status;

    public Task toEntity(){
        Task task= new Task();
        task.setStatus(this.status);
        task.setTitle(this.title);
        return task;
    }
}
