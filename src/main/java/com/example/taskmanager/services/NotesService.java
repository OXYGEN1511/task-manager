package com.example.taskmanager.services;

import com.example.taskmanager.entity.NoteEntity;
import com.example.taskmanager.entity.TaskEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class NotesService {
    private TaskService taskService;
    private HashMap<Integer,TaskNoteHolder> taskNoteHolder = new HashMap<>();
    public NotesService(TaskService taskService){
        this.taskService = taskService;

    }
    class TaskNoteHolder{
        protected int noteId =  1;
        public ArrayList<NoteEntity> notes = new ArrayList<>();

    }

    public List<NoteEntity> getNotesForTask(int taskId){
        TaskEntity task = taskService.getTaskById(taskId);
        if(task == null){
            return null;
        }

        if(taskNoteHolder.get(taskId) == null){
            taskNoteHolder.put(taskId,new TaskNoteHolder());
        }
        return taskNoteHolder.get(taskId).notes;//what this line fo and why notes is added in this line
    }

    public NoteEntity addNoteForTask(int taskId,String title, String body){
        TaskEntity task = taskService.getTaskById(taskId);
        if(task == null){
            return null;
        }
        if(taskNoteHolder.get(taskId) == null){
            taskNoteHolder.put(taskId,new TaskNoteHolder());
        }
        TaskNoteHolder taskNote = taskNoteHolder.get(taskId);
        NoteEntity note = new NoteEntity();
        note.setId(taskNote.noteId);
        note.setTite(title);
        note.setBody(body);
        taskNote.notes.add(note);
        taskNote.noteId++;
        return note;
    }


}
