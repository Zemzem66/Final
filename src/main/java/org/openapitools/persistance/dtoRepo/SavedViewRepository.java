package org.openapitools.persistance.dtoRepo;

import org.openapitools.persistance.entity.Savedview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface SavedViewRepository extends JpaRepository<Savedview,Integer> {
}
