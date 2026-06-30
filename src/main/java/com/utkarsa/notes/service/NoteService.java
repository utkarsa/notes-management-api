package com.utkarsa.notes.service;


import com.utkarsa.notes.dto.request.CreateNoteRequest;
import com.utkarsa.notes.entity.Note;

import java.util.List;

public interface NoteService {
void createNote(CreateNoteRequest request);

    List<Note> getAllNotes();

    Note getNoteById(long id);
}
