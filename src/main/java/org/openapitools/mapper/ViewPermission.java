package org.openapitools.mapper;

import org.mapstruct.*;
import org.openapitools.model.GetDocument200ResponsePermissionsView;
import org.openapitools.persistance.dtoRepo.*;
import org.openapitools.persistance.entity.AuthGroupPermissions;
import org.openapitools.persistance.entity.AuthPermission;
import org.openapitools.persistance.entity.AuthUserUserPermissions;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Service
public abstract class ViewPermission implements MapperMain<AuthPermission, GetDocument200ResponsePermissionsView>{
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

    @Mapping(target = "permissionUserPermissions", source = "users", qualifiedByName = "usersDto")
    @Mapping(target = "permissionGroupPermissions", source = "groups", qualifiedByName = "groupsDto")
    abstract public AuthPermission dtoToEntity(GetDocument200ResponsePermissionsView dto);

    @Mapping(target = "users", source = "permissionUserPermissions", qualifiedByName = "usersEntity")
    @Mapping(target = "groups", source = "permissionGroupPermissions", qualifiedByName = "groupsEntity")
    abstract public GetDocument200ResponsePermissionsView entityToDto(AuthPermission entity);

    @Named("usersEntity")
    List<Integer> map1(Set<AuthUserUserPermissions> userPermissions) {
        return userPermissions.stream().map( userPermission->(int)userPermission.getUser().getId() ).toList();
    }

    @Named("groupsEntity")
    List<Integer> map2(Set<AuthGroupPermissions> groupPermissions) {
        return groupPermissions.stream().map( groupPermission->(int)groupPermission.getGroup().getId() ).toList();
    }

    @Named("usersDto")
    Set<AuthUserUserPermissions> map3(List<Integer> users) {
        Set<AuthUserUserPermissions> userPermissions = new HashSet<>();
        for (Integer user : users) {
            AuthUserUserPermissions userPermission = new AuthUserUserPermissions();
            userPermission.setUser(userRepository.getReferenceById(user));
            userPermissions.add(userPermission);
        }
        return userPermissions;
    }

    @Named("groupsDto")
    Set<AuthGroupPermissions> map4(List<Integer> groups) {
        Set<AuthGroupPermissions> groupPermissions = new HashSet<>();
        for (Integer group : groups) {
            AuthGroupPermissions groupPermission = new AuthGroupPermissions();
            groupPermission.setGroup(groupRepository.getReferenceById(group));
            groupPermissions.add(groupPermission);
        }
        return groupPermissions;
    }


}
