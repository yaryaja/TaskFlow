package com.Project.TaskFlow.repository;

import com.Project.TaskFlow.model.Project;
import com.Project.TaskFlow.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long > {
    List<Task> findByProjectId(Long projectId);
    List<Task> findByAssignedUserId(Long userId);
    }



