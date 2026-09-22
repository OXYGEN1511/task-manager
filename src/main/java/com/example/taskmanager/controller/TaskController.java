package com.example.taskmanager.controller;


import com.example.taskmanager.dto.CreateTaskDto;
import com.example.taskmanager.entity.TaskEntity;
import com.example.taskmanager.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService task){
        this.taskService = task;
    }

    @GetMapping("")
    public ResponseEntity<List<TaskEntity>> getTasks(){  //What is ResponseEntity and Why it used here;
       var tasks =  taskService.getTasks();
       if(tasks == null){
           ResponseEntity.notFound().build(); //why build is used in this line; :-
       }
       return ResponseEntity.ok(tasks);  //What ResponseEntity Do and How it works here;
    }

    @PostMapping("")
    public ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDto dto){

        var task = taskService.addTask(dto.getTitle(), dto.getDescription(), dto.getDeadline());

        return ResponseEntity.ok(task)  ;
    }

}
