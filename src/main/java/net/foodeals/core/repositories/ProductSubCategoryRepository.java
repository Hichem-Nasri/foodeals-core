package net.foodeals.core.repositories;

import net.foodeals.core.domain.entities.ProductSubCategory;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface ProductSubCategoryRepository extends BaseRepository<ProductSubCategory, UUID>
        {
	
	@Query("SELECT sc FROM ProductSubCategory sc WHERE sc.name = :name AND sc.deletedAt IS NULL")
	public Optional<ProductSubCategory>  findByName(String name);
	
	
	@Query("SELECT c FROM ProductSubCategory c WHERE c.slug = :slug AND c.deletedAt IS NULL")
    Optional<ProductSubCategory> findBySlug(String slug);
}

