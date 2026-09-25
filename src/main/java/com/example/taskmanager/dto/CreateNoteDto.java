package com.example.taskmanager.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CreateNoteDto {
    public String title;
    public String body;

}
