package org.openapitools.persistance.dtoRepo;

import org.openapitools.persistance.entity.Uisettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface UisettingsRepository  extends JpaRepository<Uisettings,Integer> {
}
