package com.example.taskmanager.services;


import com.example.taskmanager.entity.TaskEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.ArrayList;



@Service
public class TaskService {

    private ArrayList<TaskEntity> tasks = new ArrayList<>();
    private int taskId = 1;

    public TaskEntity addTask(String title, String description, String deadline) {

        TaskEntity task = new TaskEntity();

        task.setId(taskId);
        task.setDescription(description);
        task.setTitle(title);

        LocalDate deadlineDate = LocalDate.parse(deadline);
        task.setDeadline(deadlineDate);

        task.setCompleted(false);

        tasks.add(task);

        taskId++;

        return task;
    }
  public ArrayList<TaskEntity> getTasks(){
        return  tasks;
    }

    public TaskEntity getTaskById(int id){
       for(TaskEntity task: tasks ){
         if(task.getId() == id){
             return task;
         }
       }
       return null;
    }

    public  TaskEntity updateTask(int id, String description, String deadline,Boolean iscompleted){
        TaskEntity task = getTaskById(id);
        if( task == null ){
            return null;
        }
        if(description != null){
            task.setDescription(description);
        }
        if(deadline != null){
            LocalDate deadlineDate = LocalDate.parse(deadline);
            task.setDeadline(deadlineDate);
        }
        if(iscompleted != null){
            task.setCompleted(iscompleted);
        }
        return task;


    }

}
