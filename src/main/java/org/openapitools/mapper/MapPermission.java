package org.openapitools.mapper;

import org.mapstruct.*;
import org.openapitools.model.DTO.GetDocument200ResponsePermissions;
import org.openapitools.model.GetDocument200ResponsePermissionsView;
import org.openapitools.persistance.dtoRepo.*;
import org.openapitools.persistance.entity.AuthUser;
import org.springframework.beans.factory.annotation.*;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public abstract class MapPermission implements MapperMain<AuthUser, GetDocument200ResponsePermissions> {

    @Autowired
    private CorrespondentRepository correspondentRepository;
    @Autowired
    private DocumentTypeRepository documentTypeRepository;
    @Autowired
    private StoragePathRepository storagePathRepository;
    @Autowired
    private AuthUserRepository userRepository;
    @Autowired
    private AuthGroupRepository groupRepository;
    @Autowired
    private DocumentTagRepository documentTagsRepository;
    @Autowired
    private AuthPermissionRepository  permissionRepository;

    @Mapping(target = "view", source = "id", qualifiedByName = "viewEntity")
    @Mapping(target = "change", source = "id", qualifiedByName = "changeEntity")
    abstract public GetDocument200ResponsePermissions entityToDto(AuthUser entity);

    @Named("viewEntity")
    GetDocument200ResponsePermissionsView map1(Integer id) {
        if(id==null)
            return new GetDocument200ResponsePermissionsView();
        return new GetDocument200ResponsePermissionsView().addUsersItem(id);
    }

    @Named("changeEntity")
    GetDocument200ResponsePermissionsView map2(Integer id) {
        if(id==null)
            return new GetDocument200ResponsePermissionsView();
        return new GetDocument200ResponsePermissionsView().addUsersItem(id);
    }
}
