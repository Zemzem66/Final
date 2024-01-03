package org.openapitools.persistance.dtoRepo;

import org.openapitools.persistance.entity.AuthGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface AuthGroupRepository extends JpaRepository<AuthGroup, Integer> {
}
