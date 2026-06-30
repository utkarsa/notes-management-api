package com.utkarsa.notes.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateNoteRequest {
    private String title;
    private String content;
    private boolean pinned;
}
