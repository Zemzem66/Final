package org.openapitools.mapper;

import javax.annotation.processing.Generated;
import org.openapitools.model.DTO.DocumentDocumentDTO;
import org.openapitools.persistance.entity.Document;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-04T23:04:53+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class DocumentsImpl extends Documents {

    @Override
    public Document dtoToEntity(DocumentDocumentDTO documentDocumentDTO) {
        if ( documentDocumentDTO == null ) {
            return null;
        }

        Document.DocumentBuilder document = Document.builder();

        document.archiveSerialNumber( mapArchiveSerialNumber( documentDocumentDTO.getArchiveSerialNumber() ) );
        document.correspondent( mapCorrespondent( documentDocumentDTO.getCorrespondent() ) );
        document.documentType( mapDocumentType( documentDocumentDTO.getDocumentType() ) );
        document.documentTagsEntities( mapDocTag( documentDocumentDTO.getTags() ) );
        document.storagePath( mapStoragePath( documentDocumentDTO.getStoragePath() ) );
        document.id( documentDocumentDTO.getId() );
        document.title( map( documentDocumentDTO.getTitle() ) );
        document.content( map( documentDocumentDTO.getContent() ) );
        document.created( documentDocumentDTO.getCreated() );
        document.modified( documentDocumentDTO.getModified() );
        document.added( documentDocumentDTO.getAdded() );

        return document.build();
    }

    @Override
    public DocumentDocumentDTO entityToDto(Document documentEntity) {
        if ( documentEntity == null ) {
            return null;
        }

        DocumentDocumentDTO.DocumentDocumentDTOBuilder documentDocumentDTO = DocumentDocumentDTO.builder();

        documentDocumentDTO.createdDate( mapCreatedDate( documentEntity.getCreated() ) );
        documentDocumentDTO.correspondent( map( documentEntity.getCorrespondent() ) );
        documentDocumentDTO.documentType( map( documentEntity.getDocumentType() ) );
        documentDocumentDTO.tags( map( documentEntity.getDocumentTagsEntities() ) );
        documentDocumentDTO.storagePath( map( documentEntity.getStoragePath() ) );
        documentDocumentDTO.id( documentEntity.getId() );
        documentDocumentDTO.title( map( documentEntity.getTitle() ) );
        documentDocumentDTO.content( map( documentEntity.getContent() ) );
        documentDocumentDTO.created( documentEntity.getCreated() );
        documentDocumentDTO.modified( documentEntity.getModified() );
        documentDocumentDTO.added( documentEntity.getAdded() );
        if ( documentEntity.getArchiveSerialNumber() != null ) {
            documentDocumentDTO.archiveSerialNumber( map( String.valueOf( documentEntity.getArchiveSerialNumber() ) ) );
        }

        return documentDocumentDTO.build();
    }
}
