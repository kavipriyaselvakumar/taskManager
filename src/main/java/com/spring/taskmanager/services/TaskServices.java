package com.spring.taskmanager.services;

import com.spring.taskmanager.entities.TaskEntity;
import lombok.Getter;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class TaskServices {
    private ArrayList<TaskEntity> tasks = new ArrayList<>();
    private int taskId =1;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public TaskEntity addTask(String tile, String description, String deadline) throws ParseException {
        TaskEntity task = new TaskEntity();
        task.setId(taskId);
        task.setTitle(tile);
        task.setDeadline(sdf.parse(deadline));
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
    public TaskEntity updateTask(int id,String description, String deadline,boolean completed) throws ParseException {
        TaskEntity task = getTaskById(id);
        if(task == null) return null;
        if(deadline!=null) {
            task.setDeadline(sdf.parse(deadline));
        }
        if(description!=null) {
            task.setDescription(description);
        }
        task.setCompleted(completed);
        return task;
    }

}
