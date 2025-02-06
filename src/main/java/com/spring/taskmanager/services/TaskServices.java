package com.spring.taskmanager.services;

import com.spring.taskmanager.entities.TaskEntity;
import lombok.Getter;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;

@Service
public class TaskServices {
    private ArrayList<TaskEntity> tasks = new ArrayList<>();
    private int taskId =1;
    public TaskEntity addTask(String tile, String description, String deadline){
        TaskEntity task = new TaskEntity();
        task.setId(taskId);
        task.setTitle(tile);
        //task.setDeadline(new Date(deadline));
        task.setDescription(description);
        task.setCompleted(false);

        tasks.add(task);
        taskId++;
        return task;
    }

    public ArrayList<TaskEntity> getTasks() {
        return tasks;
    }
    public TaskEntity getTaskById(int id) {
        return tasks.stream().findAny().filter(task -> task.getId() == id).orElse(null);
    }

}
