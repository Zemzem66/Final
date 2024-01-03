package org.openapitools.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.*;
import org.openapitools.model.DTO.DocumentDTO;
import org.openapitools.model.DTO.GetDocument200ResponsePermissions;
import org.openapitools.persistance.dtoRepo.*;
import org.openapitools.persistance.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.util.List;
import java.util.Set;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Service
public abstract class GetDocument implements MapperMain<Document, DocumentDTO>{
    @Autowired
    private CorrespondentRepository correspondentRepository;
    @Autowired
    private DocumentTypeRepository documentTypeRepository;
    @Autowired
    private StoragePathRepository storagePathRepository;
    @Autowired
    private AuthUserRepository userRepository;
    @Autowired
    private DocumentTagRepository documentTagsRepository;

    //@Autowired
   // private MapPermission mapPermission;
    @Autowired
    private Documents documents;


    @Mapping(target = "correspondent", source = "correspondent", qualifiedByName = "correspondentDto")
    @Mapping(target = "documentType", source = "document", qualifiedByName = "documentTypeDto")
    @Mapping(target = "storagePath", source = "storagePath", qualifiedByName = "storagePathDto")
    @Mapping(target = "documentTagsEntities", source = "tags", qualifiedByName = "tagsDto")
    @Mapping(target = "archiveSerialNumber", source = "archiveSerialNumber", qualifiedByName = "archiveSerialNumberDto")
    @Mapping(target = "owner", source = "user", qualifiedByName = "ownerDto")
    @Mapping(target = "documentNoteEntities", source = "note", qualifiedByName = "notesDto")
    abstract public Document dtoToEntity(DocumentDTO dto);

    @Mapping(target = "correspondent", source = "correspondent", qualifiedByName = "correspondentEntity")
    @Mapping(target = "document", source = "documentType", qualifiedByName = "documentTypeEntity")
    @Mapping(target = "storagePath", source = "storagePath", qualifiedByName = "storagePathEntity")
    @Mapping(target = "tags", source = "documentTagsEntities", qualifiedByName = "tagsEntity")
    @Mapping(target = "createdDate", source = "created")
    @Mapping(target = "user", source = "owner", qualifiedByName = "ownerEntity")
    @Mapping(target = "permissions", source = "owner", qualifiedByName = "permissionsEntity")
    @Mapping(target = "note", source = "documentNoteEntities", qualifiedByName = "notesEntity")
    abstract public DocumentDTO entityToDto(Document entity);

    @Named("correspondentEntity")
    Integer map(Correspondent correspondent) {
        if(correspondent == null) return null;

        return correspondent.getId();
    }

    @Named("documentTypeEntity")
    Integer map(DocumentType documentType) {
        if(documentType == null) return null;
        return documentType.getId();
    }

    @Named("storagePathEntity")
    Integer map(StoragePath storagePath) {
        if(storagePath == null) return null;
        return storagePath.getId();
    }

    @Named("ownerEntity")
    Integer map(AuthUser owner) {
        if(owner == null) return null;

        return owner.getId();
    }

    @Named("tagsEntity")
    List<Integer> map(Set<DocumentTag> tags) {
        if(tags == null) return null;
        return tags.stream().map( tag->(int)tag.getId() ).toList();
    }


}
