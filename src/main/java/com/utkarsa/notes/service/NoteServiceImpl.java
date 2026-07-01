package com.utkarsa.notes.service;

import com.utkarsa.notes.dto.request.CreateNoteRequest;
import com.utkarsa.notes.entity.Note;
import com.utkarsa.notes.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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

    @Override
    public List<Note> getAllNotes() {
      //  return noteRepository.findAll();
        return noteRepository.findByIsDeletedFalse();
    }

    @Override
    public Note getNoteById(long id) {
     //   return noteRepository.findById(id).orElse(null);
        Note note = noteRepository.findById(id).orElse(null);

        if (note == null || note.isDeleted()) {
            return null;
        }

        return note;
    }

    @Override
    public Note updateNote(long id, CreateNoteRequest request) {
        Note note = noteRepository.findById(id).orElse(null);

        if (note == null) {
            return null;
        }

        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        note.setPinned(request.isPinned());

        note.setUpdatedAt(LocalDateTime.now());

        return noteRepository.save(note);
    }

    @Override
    public void deleteNote(long id) {
        Note note = noteRepository.findById(id).orElse(null);

        if (note == null) {
            return;
        }

        note.setDeleted(true);
        note.setUpdatedAt(LocalDateTime.now());
        noteRepository.save(note);
    }

    @Override
    public void deleteNotePerm(long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public List<Note> searchNotes(String title) {
     // return noteRepository.findByTitleContainingIgnoreCase(title);
        return noteRepository.findByTitleContainingIgnoreCaseAndIsDeletedFalse(title);
    }

    @Override
    public Page<Note> getAllNotesPaginated(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return noteRepository.findAll(pageable);
    }

    @Override
    public List<Note> getAllNotesSorted(String sortBy) {
        return noteRepository.findAll(Sort.by(sortBy));
    }


}

