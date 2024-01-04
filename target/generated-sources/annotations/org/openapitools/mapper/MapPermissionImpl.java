package org.openapitools.mapper;

import javax.annotation.processing.Generated;
import org.openapitools.model.DTO.GetDocument200ResponsePermissions;
import org.openapitools.persistance.entity.AuthUser;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-04T23:04:53+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class MapPermissionImpl extends MapPermission {

    @Override
    public AuthUser dtoToEntity(GetDocument200ResponsePermissions dto) {
        if ( dto == null ) {
            return null;
        }

        AuthUser authUser = new AuthUser();

        return authUser;
    }

    @Override
    public GetDocument200ResponsePermissions entityToDto(AuthUser entity) {
        if ( entity == null ) {
            return null;
        }

        GetDocument200ResponsePermissions getDocument200ResponsePermissions = new GetDocument200ResponsePermissions();

        getDocument200ResponsePermissions.setView( map1( entity.getId() ) );
        getDocument200ResponsePermissions.setChange( map2( entity.getId() ) );

        return getDocument200ResponsePermissions;
    }
}
