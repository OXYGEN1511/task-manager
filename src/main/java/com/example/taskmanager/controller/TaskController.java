package com.example.taskmanager.controller;


import com.example.taskmanager.dto.CreateTaskDto;
import com.example.taskmanager.dto.UpdateTaskDto;
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

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity> getTaskById(@PathVariable("id") Integer id){

        var task = taskService.getTaskById(id);
        if(task == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TaskEntity> updateTask(@PathVariable("id") Integer id , @RequestBody UpdateTaskDto dto){
        var updatedTask = taskService.updateTask(id,dto.getDescription(), dto.getDescription(), dto.getCompleted());
        if(updatedTask == null){
            return  ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedTask);
    }

    @PostMapping("")
    public ResponseEntity<TaskEntity> addTask(@RequestBody CreateTaskDto dto){

        var task = taskService.addTask(dto.getTitle(), dto.getDescription(), dto.getDeadline());

        return ResponseEntity.ok(task)  ;
    }

}
