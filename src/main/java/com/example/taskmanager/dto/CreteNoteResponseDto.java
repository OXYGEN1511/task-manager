package com.example.taskmanager.dto;

import com.example.taskmanager.entity.NoteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreteNoteResponseDto {
    private Integer taskId;
    private NoteEntity note;

}
