package com.utkarsa.notes.controller;

import com.utkarsa.notes.dto.request.CreateNoteRequest;
import com.utkarsa.notes.entity.Note;
import com.utkarsa.notes.service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @PostMapping("create")
    public void createNote(@Valid @RequestBody CreateNoteRequest request) {
        noteService.createNote(request);

    }

    @GetMapping("getAll")
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @GetMapping("getById/{id}")
    public Note getNoteById(@PathVariable long id) {
        return noteService.getNoteById(id);
    }

    @PutMapping("update/{id}")
    public Note updateNote(@PathVariable long id,
                           @RequestBody CreateNoteRequest request) {
        return noteService.updateNote(id, request);
    }

    @DeleteMapping("delete/{id}")
    public void deleteNote(@PathVariable long id) {
        noteService.deleteNote(id);
    }

    @DeleteMapping("permDelete/{id}")
    public void deleteNotePerm (@PathVariable long id) {
        noteService.deleteNotePerm(id);
    }

    @GetMapping("search")
    public List<Note> searchNotes(@RequestParam String title) {
        return noteService.searchNotes(title);
    }

    @GetMapping("getAllPaginated")
    public Page<Note> getAllNotesPaginated(
            @RequestParam int page,
            @RequestParam int size) {

        return noteService.getAllNotesPaginated(page, size);
    }

    @GetMapping("getAllSorted")
    public List<Note> getAllNotesSorted(@RequestParam String sortBy) {
        return noteService.getAllNotesSorted(sortBy);
    }
}
