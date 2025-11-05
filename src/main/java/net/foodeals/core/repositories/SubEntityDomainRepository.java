package net.foodeals.core.repositories;

import net.foodeals.core.domain.entities.SubEntityDomain;
import net.foodeals.core.domain.entities.SubEntityProductCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SubEntityDomainRepository extends BaseRepository<SubEntityDomain, UUID> {
    @Query("SELECT s FROM SubEntityDomain s WHERE s.name = :name AND s.deletedAt IS NULL")
    public Optional<SubEntityDomain> findByName(String name);

    @Query("SELECT sed.subEntityProductCategories FROM SubEntityDomain sed JOIN sed.subEntities se WHERE se.id = :subEntityId")
    List<SubEntityProductCategory> findCategoriesBySubEntityId(@Param("subEntityId") UUID subEntityId);


}
