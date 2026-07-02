package com.utkarsa.notes.service;

import com.utkarsa.notes.dto.request.CreateNoteRequest;
import com.utkarsa.notes.dto.response.NoteResponse;
import com.utkarsa.notes.entity.Note;
import com.utkarsa.notes.exception.NoteNotFoundException;
import com.utkarsa.notes.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;


    @Override
    public void createNote(CreateNoteRequest request) {
        log.info("Creating note");
        Note note = new Note();

        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        note.setPinned(request.isPinned());

        note.setDeleted(false);

        note.setCreatedAt(LocalDateTime.now());
        note.setUpdatedAt(LocalDateTime.now());

        noteRepository.save(note);
        log.info("Creating note");
    }

    /*
        @Override
        public List<Note> getAllNotes() {
          //  return noteRepository.findAll();
            return noteRepository.findByIsDeletedFalse();
        }
     */
    @Override
    public List<NoteResponse> getAllNotes() {

        return noteRepository.findByIsDeletedFalse()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    /*
        @Override
        public Note getNoteById(long id) {
           return noteRepository.findById(id).orElse(null);

            Note note = noteRepository.findById(id).orElse(null);

            if (note == null || note.isDeleted()) {
                return null;
            }

            return note;
        }
    */
/*
@Override
//public Note getNoteById(long id) {
    public NoteResponse getNoteById(long id) {
    Note note = noteRepository.findById(id)
            .orElseThrow(() -> new NoteNotFoundException("Note not found"));

    if (note.isDeleted()) {
        throw new NoteNotFoundException("Note not found");
    }

    //return note;
    return NoteResponse.builder()
            .id(note.getId())
            .title(note.getTitle())
            .content(note.getContent())
            .pinned(note.isPinned())
            .createdAt(note.getCreatedAt())
            .updatedAt(note.getUpdatedAt())
            .build();
}*/
    @Override
    public NoteResponse getNoteById(long id) {
        log.info("Fetching note with id {}", id);
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException("Note not found"));

        return mapToResponse(note);
    }

    /*
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
    */
    @Override
    public Note updateNote(long id, CreateNoteRequest request) {
        log.info("Updating note with id {}", id);
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException("Note not found"));

        note.setTitle(request.getTitle());
        note.setContent(request.getContent());
        note.setPinned(request.isPinned());
        note.setUpdatedAt(LocalDateTime.now());

        return noteRepository.save(note);
    }

    /*
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
 */
    @Override
    public void deleteNote(long id) {
        log.info("Soft deleting note with id {}", id);
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException("Note not found"));

        note.setDeleted(true);
        note.setUpdatedAt(LocalDateTime.now());

        noteRepository.save(note);
    }

    /*
     @Override
     public void deleteNotePerm(long id) {
         noteRepository.deleteById(id);
     }
 */
    @Override
    public void deleteNotePerm(long id) {

        log.info("Permanently deleting note with id {}", id);
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException("Note not found"));

        noteRepository.delete(note);
    }

    @Override
    public List<Note> searchNotes(String title) {
        log.info("Searching notes with title {}", title);
        // return noteRepository.findByTitleContainingIgnoreCase(title);
        return noteRepository.findByTitleContainingIgnoreCaseAndIsDeletedFalse(title);
    }

    /*
        @Override
        public Page<Note> getAllNotesPaginated(int page, int size) {
            Pageable pageable = PageRequest.of(page, size);
            return noteRepository.findAll(pageable);
        }
    */
    @Override
    public Page<NoteResponse> getAllNotesPaginated(int page, int size) {
        log.info("Fetching notes page {} with size {}", page, size);
        Pageable pageable = PageRequest.of(page, size);

        return noteRepository.findAll(pageable)
                .map(this::mapToResponse);
    }

    @Override
    public List<Note> getAllNotesSorted(String sortBy) {
        return noteRepository.findAll(Sort.by(sortBy));
    }

    private NoteResponse mapToResponse(Note note) {

        return NoteResponse.builder()
                .id(note.getId())
                .title(note.getTitle())
                .content(note.getContent())
                .pinned(note.isPinned())
                .createdAt(note.getCreatedAt())
                .updatedAt(note.getUpdatedAt())
                .build();
    }


}

