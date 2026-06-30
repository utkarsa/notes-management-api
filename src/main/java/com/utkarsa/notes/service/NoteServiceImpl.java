package com.utkarsa.notes.service;

import com.utkarsa.notes.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

private final NoteRepository noteRepository;


    @Override
    public void createNote() {

    }
}
