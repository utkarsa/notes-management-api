package com.utkarsa.notes.service;


import com.utkarsa.notes.dto.request.CreateNoteRequest;
import com.utkarsa.notes.dto.response.NoteResponse;
import com.utkarsa.notes.entity.Note;
import org.springframework.data.domain.Page;

import java.util.List;

public interface NoteService {
    void createNote(CreateNoteRequest request);

    //List<Note> getAllNotes();
    List<NoteResponse> getAllNotes();

    //Note getNoteById(long id);
    NoteResponse getNoteById(long id);

    Note updateNote(long id, CreateNoteRequest request);

    void deleteNote(long id);

    void deleteNotePerm(long id);

    List<Note> searchNotes(String title);

    // Page<Note> getAllNotesPaginated(int page, int size);
    Page<NoteResponse> getAllNotesPaginated(int page, int size);

    List<Note> getAllNotesSorted(String sortBy);
}
