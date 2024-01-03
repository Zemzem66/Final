package org.openapitools.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.*;
import org.openapitools.model.DTO.DocumentDTO;
import org.openapitools.model.DTO.GetDocument200ResponsePermissions;
import org.openapitools.persistance.dtoRepo.*;
import org.openapitools.persistance.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.HashSet;
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
    private Notes notesMapper;


    @Mapping(target = "correspondent", source = "correspondent", qualifiedByName = "correspondentDto")
    @Mapping(target = "documentType", source = "document", qualifiedByName = "documentTypeDto")
    @Mapping(target = "storagePath", source = "storagePath", qualifiedByName = "storagePathDto")
    @Mapping(target = "documentTagsEntities", source = "tags", qualifiedByName = "tagsDto")
    @Mapping(target = "archiveSerialNumber", source = "archiveSerialNumber", qualifiedByName = "archiveSerialNumberDto")
    @Mapping(target = "owner", source = "user", qualifiedByName = "ownerDto")
   // @Mapping(target = "documentNoteEntities", source = "notes", qualifiedByName = "notesDto")
    abstract public Document dtoToEntity(DocumentDTO dto);

    @Mapping(target = "correspondent", source = "correspondent", qualifiedByName = "correspondentEntity")
    @Mapping(target = "document", source = "documentType", qualifiedByName = "documentTypeEntity")
    @Mapping(target = "storagePath", source = "storagePath", qualifiedByName = "storagePathEntity")
    @Mapping(target = "tags", source = "documentTagsEntities", qualifiedByName = "tagsEntity")
    @Mapping(target = "createdDate", source = "created")
    @Mapping(target = "user", source = "owner", qualifiedByName = "ownerEntity")
   // @Mapping(target = "permissions", source = "owner", qualifiedByName = "permissionsEntity")
    //@Mapping(target = "notes", source = "documentNoteEntities", qualifiedByName = "notesEntity")
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
    /*
    @Named("notesEntity")
    List<DocumentDTO> mapNotes(Set<Note> notes) {
        if(notes == null) return null;
        return notes.stream().map( note->notesMapper.entityToDto(note) ).toList();
    }

     */
    OffsetDateTime mapCreatedDate(OffsetDateTime value) {
        return value!=null ? value.withOffsetSameInstant(ZoneOffset.UTC).toLocalDate().atStartOfDay().atOffset(ZoneOffset.UTC) : null;
    }
    OffsetDateTime map(String value){
        return value != null ? OffsetDateTime.parse(value) : null;
    }

    String map (OffsetDateTime value){
        return value != null ? value.toString() : null;
    }

    @Named("correspondentDto")
    Correspondent mapCorrespondent(Integer value) {
        if(value == null) return null;
        return correspondentRepository.findById(value).orElse(null);
    }

    @Named("documentTypeDto")
    DocumentType mapDocumentType(Integer value) {
        if(value == null) return null;
        return documentTypeRepository.findById(value).orElse(null);
    }

    @Named("storagePathDto")
    StoragePath mapStoragePath(Integer value) {
        if(value == null) return null;
        return storagePathRepository.findById(value).orElse(null);
    }
    @Named("ownerDto")
    AuthUser mapOwner(Integer value) {
        if(value == null) return null;
        return userRepository.findById(value).orElse(null);
    }
    @Named("tagsDto")
    Set<DocumentTag> mapDocTag(List<Integer> value) {
        if(value == null) return null;
        return new HashSet<DocumentTag>(documentTagsRepository.findAllById(value));
    }

    @Named("archiveSerialNumberDto")
    Integer mapArchiveSerialNumber(String value) {
        if(value==null || value.isEmpty()) return null;
        return Integer.parseInt(value);
    }

    /*
    @Named("notesDto")
    Set<Note> mapNotes(List<DocumentDTO> value) {
        if(value==null || value.isEmpty()) return null;

        HashSet<Note> notes = new HashSet<Note>();

        for(DocumentDTO note : value) {
            notes.add(notesMapper.dtoToEntity(note));
        }
        return notes;
    }

     */
}
