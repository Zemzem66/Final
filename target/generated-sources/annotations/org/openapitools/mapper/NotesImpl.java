package org.openapitools.mapper;

import javax.annotation.processing.Generated;
import org.openapitools.model.DTO.NoteDTO;
import org.openapitools.persistance.entity.Note;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-04T23:04:53+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class NotesImpl extends Notes {

    @Override
    public Note dtoToEntity(NoteDTO documentDTO) {
        if ( documentDTO == null ) {
            return null;
        }

        Note note = new Note();

        note.setDocument( mapDoc( documentDTO.getDocument() ) );
        note.setUser( mapAuth( documentDTO.getUser() ) );
        note.setId( documentDTO.getId() );
        note.setNote( documentDTO.getNote() );
        note.setCreated( map( documentDTO.getCreated() ) );

        return note;
    }

    @Override
    public NoteDTO entityToDto(Note noteEntity) {
        if ( noteEntity == null ) {
            return null;
        }

        NoteDTO noteDTO = new NoteDTO();

        noteDTO.setDocument( map( noteEntity.getDocument() ) );
        noteDTO.setUser( map( noteEntity.getUser() ) );
        noteDTO.setId( noteEntity.getId() );
        noteDTO.setNote( noteEntity.getNote() );
        noteDTO.setCreated( map( noteEntity.getCreated() ) );

        return noteDTO;
    }
}
