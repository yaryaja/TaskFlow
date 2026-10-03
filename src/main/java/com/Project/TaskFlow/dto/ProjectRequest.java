package com.Project.TaskFlow.dto;

import com.Project.TaskFlow.model.Project;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectRequest {
    private String name;
    private String description;

    public  Project toEntity(){
        Project project=new Project();
        project.setName(this.name);
        project.setDescription((this.description));
        return project;
    }




}
