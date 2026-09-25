package com.example.taskmanager.dto;

import com.example.taskmanager.entity.NoteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TaskResponseDto {
    private int id;
    String title;
    String description;
    String deadline;
    Boolean completed;
    private List<NoteEntity> notes;
}
