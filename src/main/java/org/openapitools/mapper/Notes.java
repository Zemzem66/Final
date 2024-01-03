package org.openapitools.mapper;

import org.mapstruct.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.openapitools.model.DTO.DocumentDTO;
import org.openapitools.persistance.dtoRepo.*;
import org.openapitools.persistance.entity.AuthUser;
import org.openapitools.persistance.entity.Document;
import org.openapitools.persistance.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.openapitools.persistance.dtoRepo.*;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class Notes implements MapperMain<Note, DocumentDTO> {
    //TODO: dto fertig programmieren
    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private DocumentTagRepository documentTagRepository;
    @Autowired
    private AuthUserRepository authUserRepository;
    @Autowired
    private StoragePathRepository storagePathRepository;
    @Autowired
    private DocumentTypeRepository documentTypeRepository;
    @Autowired
    private CorrespondentRepository correspondentRepository;

    @Mapping(target = "document", source = "document", qualifiedByName = "dtoDocument")
    @Mapping(target = "user", source = "user", qualifiedByName = "DtoUser")
    abstract public Note dtoToEntity(DocumentDTO documentDTO);

    @Mapping(target = "document", source = "document", qualifiedByName = "entityDocument")
    @Mapping(target = "user",source = "user", qualifiedByName = "entityUser")
    abstract public DocumentDTO entityToDto(Note noteEntity);


    @Named("entityDocument")
    Integer map(Document document)
    {
        return document.getId();
    }
    @Named("entityUser")
    Integer map(AuthUser authUser){
        return authUser.getId();
    }

    String map(OffsetDateTime created) {
        return created != null ? created.toString() : null;
    }

    OffsetDateTime map(String value){
        return value != null ? OffsetDateTime.parse(value) : null;
    }
    @Named("DtoUser")
    AuthUser mapAuth(Integer val){
        return authUserRepository.findById(val).orElse(null);
    }

    @Named("dtoDocument")
    Document mapDoc(Integer val){
        return documentRepository.findById(val).orElse(null);
    }
}
