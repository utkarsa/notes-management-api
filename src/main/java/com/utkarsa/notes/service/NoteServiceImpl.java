package com.utkarsa.notes.service;

import com.utkarsa.notes.dto.request.CreateNoteRequest;
import com.utkarsa.notes.entity.Note;
import com.utkarsa.notes.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

private final NoteRepository noteRepository;


    @Override
        public void createNote(CreateNoteRequest request) {

            Note note = new Note();

            note.setTitle(request.getTitle());
            note.setContent(request.getContent());
            note.setPinned(request.isPinned());

            note.setDeleted(false);

            note.setCreatedAt(LocalDateTime.now());
            note.setUpdatedAt(LocalDateTime.now());

            noteRepository.save(note);
        }

    }

