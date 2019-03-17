package com.github.jayakumarc.taskdashboard.rest;

import java.util.List;
import javax.validation.Valid;
import com.github.jayakumarc.taskdashboard.model.Task;
import com.github.jayakumarc.taskdashboard.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    TaskRepository taskRepository;

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @PostMapping("/tasks")
    public Task createTask(@Valid @RequestBody Task task) {
        return taskRepository.save(task);
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskById(@PathVariable(value = "id") Long taskId) {
        return taskRepository.findById(taskId).orElseThrow(
                () -> new RuntimeException(String.format("Task with id %s not found", taskId)));
    }

    @PutMapping("/tasks/{id}")
    public Task updateTaskStatus(@PathVariable(value = "id") Long taskId,
            @RequestBody Task taskDetails) {

        Task task = taskRepository.findById(taskId).orElseThrow(
                () -> new RuntimeException(String.format("Task with id %s not found", taskId)));

        task.setStatus(taskDetails.getStatus());

        Task updatedTask = taskRepository.save(task);
        return updatedTask;
    }

}
