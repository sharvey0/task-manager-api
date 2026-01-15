package com.sharvey.taskmanager.repository;

import com.sharvey.taskmanager.model.Task;
import com.sharvey.taskmanager.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByProjectId(Long projectId);
    List<Task> findByStatus(TaskStatus status);
    List<Task> findByProjectIdAndStatus(Long projectId, TaskStatus status);

    @Query("""
    SELECT t FROM Task t
    WHERE t.dueDate < :now
    """)
    List<Task> findOverdueTasks(@Param("now") LocalDateTime now);

}
