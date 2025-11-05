package net.foodeals.core.repositories;

import net.foodeals.core.domain.entities.SubEntityProductCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface SubEntityProductCategoryRepository extends BaseRepository<SubEntityProductCategory
        , UUID> {

    @Query("SELECT sec FROM SubEntityProductCategory sec " +
            "JOIN sec.subEntityDomain sd " +
            "WHERE sec.subEntityDomain.id = :domainId")
    List<SubEntityProductCategory> findBySubEntityDomainId(@Param("domainId") UUID domainId);
    
    SubEntityProductCategory findByName(String name);

}
