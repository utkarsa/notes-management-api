package com.utkarsa.notes.service;


import com.utkarsa.notes.dto.request.CreateNoteRequest;

public interface NoteService {
void createNote(CreateNoteRequest request);
}
