package com.sharvey.taskmanager.config;

import com.sharvey.taskmanager.model.Project;
import com.sharvey.taskmanager.model.Task;
import com.sharvey.taskmanager.repository.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(ProjectRepository projectRepository) {
        return args -> {

            Project project = new Project(
                    "Portfolio Project",
                    "Task manager API for internship portfolio"
            );

            Task task1 = new Task(
                    "Design entities",
                    "Create Project and Task entities",
                    LocalDateTime.now().plusDays(3)
            );

            Task task2 = new Task(
                    "Create repositories",
                    "Implement Spring Data repositories",
                    LocalDateTime.now().plusDays(5)
            );

            project.addTask(task1);
            project.addTask(task2);

            projectRepository.save(project);
        };
    }
}