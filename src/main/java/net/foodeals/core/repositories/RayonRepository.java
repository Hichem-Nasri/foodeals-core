package net.foodeals.core.repositories;

import net.foodeals.core.domain.entities.Rayon;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface RayonRepository extends BaseRepository<Rayon, UUID> {
	
	@Query("SELECT r FROM Rayon r WHERE r.name = :name AND r.deletedAt IS NULL")
	public Optional<Rayon>  findByName(String name);
}
