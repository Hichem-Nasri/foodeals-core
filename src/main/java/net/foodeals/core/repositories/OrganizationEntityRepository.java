package net.foodeals.core.repositories;

import net.foodeals.core.domain.entities.OrganizationEntity;
import net.foodeals.core.domain.enums.EntityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface OrganizationEntityRepository extends BaseRepository<OrganizationEntity, UUID> {
    Page<OrganizationEntity> findByType(EntityType type, Pageable pageable);
    Optional<OrganizationEntity>findByName(String name);
}
