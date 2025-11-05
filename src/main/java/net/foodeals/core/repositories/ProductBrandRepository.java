package net.foodeals.core.repositories;
import net.foodeals.core.domain.entities.ProductBrand;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface ProductBrandRepository extends BaseRepository<ProductBrand, UUID> {


	@Query("SELECT b FROM ProductBrand b WHERE b.name = :name AND b.deletedAt IS NULL")
	public Optional<ProductBrand>  findByName(String name);
}
