package net.foodeals.core.repositories;

import net.foodeals.core.domain.entities.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface CityRepository extends BaseRepository<City, UUID> {
	City findByName(String name);

	@Query("SELECT c FROM City c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))")
	List<City> findByNameLikeIgnoreCase(@Param("name") String name);
}
