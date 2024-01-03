package org.openapitools.persistance.dtoRepo;

import org.openapitools.persistance.entity.AuthUserUserPermissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface AuthUserPermissionRepository extends JpaRepository<AuthUserUserPermissions,Integer> {
}
