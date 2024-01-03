package org.openapitools.persistance.dtoRepo;

import org.openapitools.persistance.entity.TagEnt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface TagEntRepository extends JpaRepository<TagEnt,Integer> {
}
