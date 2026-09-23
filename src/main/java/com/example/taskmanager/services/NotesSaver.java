package com.example.taskmanager.services;

import com.example.taskmanager.entity.NoteEntity;
import com.example.taskmanager.entity.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class NotesSaver {
    private TaskService taskService;
    private HashMap<Integer,NoteEntity> task = new HashMap<>();
    public NotesSaver(TaskService taskService){
        this.taskService = taskService;

    }
     class TaskNoteHolder{
        protected int noteId =1;
        public ArrayList<NoteEntity> notes = new ArrayList<>();

    }

    public List<NoteEntity> getNotesForTask(int taskId){
        TaskEntity task = taskService.getTaskById(taskId);
        if(task == null){
            return null;
        }
return null;


    }
}
