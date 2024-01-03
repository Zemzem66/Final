package org.openapitools.mapper;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.openapitools.jackson.nullable.JsonNullable;
import org.openapitools.model.DTO.DocumentDocumentDTO;
import org.openapitools.persistance.dtoRepo.*;
import org.openapitools.persistance.entity.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class Documents implements MapperMain<Document, DocumentDocumentDTO> {
    public static Documents INSTANCE = Mappers.getMapper(Documents.class);

    @Autowired
    private CorrespondentRepository correspondentRepository;
    @Autowired
    private StoragePathRepository storagePathRepository;

    @Autowired
    private DocumentTagRepository documentTagRepository;

    @Autowired
    private AuthUserRepository authUserRepository;

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    @Autowired
    private DocumentRepository documentRepository;


    @Mapping(target = "archiveSerialNumber", source = "archiveSerialNumber", qualifiedByName = "archiveSerialNumberDto")
    @Mapping(target = "correspondent", source = "correspondent", qualifiedByName = "correspondentDto")
    @Mapping(target = "documentType", source = "documentType", qualifiedByName = "documentTypeDto")
    @Mapping(target = "documentTagsEntities", source = "tags", qualifiedByName = "tagsDto")
    @Mapping(target = "storagePath",source = "storagePath",qualifiedByName = "storagePathDto")
    abstract public Document dtoToEntity(DocumentDocumentDTO documentDocumentDTO);

    @Mapping(target = "createdDate", source = "created", qualifiedByName = "createDateEntity")
    @Mapping(target = "correspondent", source = "correspondent", qualifiedByName = "correspondentEntity")
    @Mapping(target = "documentType", source = "documentType", qualifiedByName = "documentTypeEntity")
    @Mapping(target = "tags", source = "documentTagsEntities", qualifiedByName = "tagsEntity")
    @Mapping(target = "storagePath",source = "storagePath",qualifiedByName = "storagePathEntity")
    abstract public DocumentDocumentDTO entityToDto(Document documentEntity);

    @Named("correspondentEntity")
    JsonNullable<Integer> map(Correspondent correspondent) {
        return correspondent!=null ? JsonNullable.of(correspondent.getId()) : JsonNullable.undefined();
    }

    @Named("documentTypeEntity")
    JsonNullable<Integer> map(DocumentType documentType) {
        return documentType!=null ? JsonNullable.of(documentType.getId()) : JsonNullable.undefined();
    }

    @Named("storagePathEntity")
    JsonNullable<Integer> map(StoragePath storagePath) {
        return storagePath!=null ? JsonNullable.of(storagePath.getId()) : JsonNullable.undefined();
    }

    @Named("ownerEntity")
    JsonNullable<Integer> map(AuthUser owner) {
        return owner!=null ? JsonNullable.of(owner.getId()) : JsonNullable.undefined();
    }

    @Named("tagsEntity")
    JsonNullable<List<Integer>> map(Set<DocumentTag> tags) {
        return tags!=null ? JsonNullable.of( tags.stream().map( tag->(int)tag.getId() ).toList() ) : JsonNullable.undefined();
    }

    @Named("createDateEntity")
    OffsetDateTime mapCreatedDate(OffsetDateTime value) {
        return value!=null ? value.withOffsetSameInstant(ZoneOffset.UTC).toLocalDate().atStartOfDay().atOffset(ZoneOffset.UTC) : null;
    }
    @Named("correspondentDto")
    Correspondent mapCorrespondent(JsonNullable<Integer> value) {
        if(value==null || !value.isPresent() || value.get()==null) return null;
        return correspondentRepository.findById(value.get()).orElse(null);
    }
    @Named("documentTypeDto")
    DocumentType mapDocumentType(JsonNullable<Integer> value) {
        if(value==null || !value.isPresent() || value.get()==null) return null;
        return documentTypeRepository.findById(value.get()).orElse(null);
    }
    @Named("storagePathDto")
    StoragePath mapStoragePath(JsonNullable<Integer> value) {
        if(value==null || !value.isPresent() || value.get()==null) return null;
        return storagePathRepository.findById(value.get()).orElse(null);
    }

    @Named("ownerDto")
    AuthUser mapOwner(JsonNullable<Integer> value) {
        if(value==null || !value.isPresent() || value.get()==null) return null;
        return authUserRepository.findById(value.get()).orElse(null);
    }

    @Named("tagsDto")
    Set<DocumentTag> mapDocTag(JsonNullable<List<Integer>> value) {
        if(value==null || !value.isPresent() || value.get()==null) return null;
        return new HashSet<DocumentTag>(documentTagRepository.findAllById(value.get()));
    }

    @Named("archiveSerialNumberDto")
    Integer mapArchiveSerialNumber(JsonNullable<String> value) {
        if(value==null || !value.isPresent() || value.get()==null) return null;
        return Integer.parseInt(value.get());
    }

}
