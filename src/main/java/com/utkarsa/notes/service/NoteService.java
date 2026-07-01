package com.utkarsa.notes.service;


import com.utkarsa.notes.dto.request.CreateNoteRequest;
import com.utkarsa.notes.entity.Note;

import java.util.List;

public interface NoteService {
void createNote(CreateNoteRequest request);

    List<Note> getAllNotes();

    Note getNoteById(long id);

    Note updateNote(long id, CreateNoteRequest request);

    void deleteNote(long id);

    void deleteNotePerm(long id);

    List<Note> searchNotes(String title);
}
