package org.openapitools.mapper;

import javax.annotation.processing.Generated;
import org.openapitools.model.GetDocument200ResponsePermissionsView;
import org.openapitools.persistance.entity.AuthPermission;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-04T23:04:53+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class ViewPermissionImpl extends ViewPermission {

    @Override
    public AuthPermission dtoToEntity(GetDocument200ResponsePermissionsView dto) {
        if ( dto == null ) {
            return null;
        }

        AuthPermission authPermission = new AuthPermission();

        authPermission.setPermissionUserPermissions( map3( dto.getUsers() ) );
        authPermission.setPermissionGroupPermissions( map4( dto.getGroups() ) );

        return authPermission;
    }

    @Override
    public GetDocument200ResponsePermissionsView entityToDto(AuthPermission entity) {
        if ( entity == null ) {
            return null;
        }

        GetDocument200ResponsePermissionsView getDocument200ResponsePermissionsView = new GetDocument200ResponsePermissionsView();

        getDocument200ResponsePermissionsView.setUsers( map1( entity.getPermissionUserPermissions() ) );
        getDocument200ResponsePermissionsView.setGroups( map2( entity.getPermissionGroupPermissions() ) );

        return getDocument200ResponsePermissionsView;
    }
}
