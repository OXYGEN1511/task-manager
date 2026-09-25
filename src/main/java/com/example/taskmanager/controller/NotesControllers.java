package com.example.taskmanager.controller;

import com.example.taskmanager.dto.CreateNoteDto;
import com.example.taskmanager.dto.CreteNoteResponseDto;
import com.example.taskmanager.entity.NoteEntity;
import com.example.taskmanager.services.NotesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/{taskId}/notes")
public class NotesControllers {
    private NotesService  notesService;

    public NotesControllers(NotesService notesService){
        this.notesService = notesService;
    }
    @GetMapping("")
    public ResponseEntity<List<NoteEntity>> getNotes(@PathVariable("taskId") Integer taskId){
        var notes = notesService.getNotesForTask(taskId);
        return ResponseEntity.ok(notes);
    }

    @PostMapping("")
    public ResponseEntity<CreteNoteResponseDto> addNotes(@PathVariable("taskId") Integer taskId , @RequestBody CreateNoteDto dto){
    var res = notesService.addNoteForTask(taskId,dto.getTitle(),dto.getBody());
    return ResponseEntity.ok(new CreteNoteResponseDto(taskId,res));
    
    }




}
