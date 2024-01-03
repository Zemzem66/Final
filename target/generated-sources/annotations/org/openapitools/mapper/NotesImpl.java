package org.openapitools.mapper;

import javax.annotation.processing.Generated;
import org.openapitools.model.DTO.DocumentDTO;
import org.openapitools.persistance.entity.Note;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-04T12:50:36+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class NotesImpl extends Notes {

    @Override
    public Note dtoToEntity(DocumentDTO documentDTO) {
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
    public DocumentDTO entityToDto(Note noteEntity) {
        if ( noteEntity == null ) {
            return null;
        }

        DocumentDTO documentDTO = new DocumentDTO();

        documentDTO.setDocument( map( noteEntity.getDocument() ) );
        documentDTO.setUser( map( noteEntity.getUser() ) );
        documentDTO.setId( noteEntity.getId() );
        documentDTO.setNote( noteEntity.getNote() );
        documentDTO.setCreated( map( noteEntity.getCreated() ) );

        return documentDTO;
    }
}
