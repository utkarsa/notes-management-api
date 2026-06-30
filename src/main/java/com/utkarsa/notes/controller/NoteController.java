package com.utkarsa.notes.controller;

import com.utkarsa.notes.dto.request.CreateNoteRequest;
import com.utkarsa.notes.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @PostMapping
    public void createNote(@RequestBody CreateNoteRequest request) {
        noteService.createNote(request);

    }
}
