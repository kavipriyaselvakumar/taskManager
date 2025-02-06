package com.spring.taskmanager.controller;

import com.spring.taskmanager.dto.CreateTaskDto;
import com.spring.taskmanager.entities.TaskEntity;
import com.spring.taskmanager.services.TaskServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskServices taskService;

    public TaskController(TaskServices taskService) {
        this.taskService = taskService;
    }

    @GetMapping("")
    public ResponseEntity<List<TaskEntity>> getTasks(){
        var task = taskService.getTasks();
        return ResponseEntity.ok(task);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable("id") Integer id){
        var task = taskService.getTaskById(id);
        if(task == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }
    @PostMapping()
    public ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDto dto){
        var task = taskService.addTask(dto.getTile(),dto.getDescription(),dto.getDeadline());
        return ResponseEntity.ok(task);
    }
}
