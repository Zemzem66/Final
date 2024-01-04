package org.openapitools.mapper;

import javax.annotation.processing.Generated;
import org.openapitools.model.DTO.DocumentDTO;
import org.openapitools.persistance.entity.Document;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-04T23:04:53+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class GetDocumentImpl extends GetDocument {

    @Override
    public Document dtoToEntity(DocumentDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Document.DocumentBuilder document = Document.builder();

        document.correspondent( mapCorrespondent( dto.getCorrespondent() ) );
        document.documentType( mapDocumentType( dto.getDocumentType() ) );
        document.storagePath( mapStoragePath( dto.getStoragePath() ) );
        document.documentTagsEntities( mapDocTag( dto.getTags() ) );
        if ( dto.getArchiveSerialNumber() != null ) {
            document.archiveSerialNumber( mapArchiveSerialNumber( String.valueOf( dto.getArchiveSerialNumber() ) ) );
        }
        document.owner( mapOwner( dto.getOwner() ) );
        document.documentNoteEntities( mapNotes( dto.getNotes() ) );
        document.id( dto.getId() );
        document.title( dto.getTitle() );
        document.created( map( dto.getCreated() ) );
        document.modified( map( dto.getModified() ) );
        document.added( map( dto.getAdded() ) );

        return document.build();
    }

    @Override
    public DocumentDTO entityToDto(Document entity) {
        if ( entity == null ) {
            return null;
        }

        DocumentDTO documentDTO = new DocumentDTO();

        documentDTO.setCorrespondent( map( entity.getCorrespondent() ) );
        documentDTO.setDocumentType( map( entity.getDocumentType() ) );
        documentDTO.setStoragePath( map( entity.getStoragePath() ) );
        documentDTO.setTags( map( entity.getDocumentTagsEntities() ) );
        documentDTO.setCreatedDate( map( entity.getCreated() ) );
        documentDTO.setOwner( map( entity.getOwner() ) );
        documentDTO.setNotes( mapNotes( entity.getDocumentNoteEntities() ) );
        documentDTO.setId( entity.getId() );
        documentDTO.setTitle( entity.getTitle() );
        documentDTO.content( entity.getContent() );
        documentDTO.setCreated( map( entity.getCreated() ) );
        documentDTO.setModified( map( entity.getModified() ) );
        documentDTO.setAdded( map( entity.getAdded() ) );
        documentDTO.setArchiveSerialNumber( entity.getArchiveSerialNumber() );

        return documentDTO;
    }
}
