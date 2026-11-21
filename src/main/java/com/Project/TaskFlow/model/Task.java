package com.Project.TaskFlow.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "tasks")
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private  String status;

    @ManyToOne
    @JoinColumn(name="project_id")
    private  Project project;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User assignedUser;

}
