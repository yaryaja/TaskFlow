package com.Project.TaskFlow.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.security.PrivateKey;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private  String Status;

    @ManyToOne
    @JoinColumn(name="project_id")
    private  Project project;

}
