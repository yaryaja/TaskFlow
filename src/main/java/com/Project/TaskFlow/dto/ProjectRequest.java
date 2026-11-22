package com.Project.TaskFlow.dto;

import com.Project.TaskFlow.model.Project;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectRequest {
    @NotBlank(message = "Project name cannot be blank")
    private String name;
    private String description;

    public  Project toEntity(){
        Project project=new Project();
        project.setName(this.name);
        project.setDescription((this.description));
        return project;
    }




}
