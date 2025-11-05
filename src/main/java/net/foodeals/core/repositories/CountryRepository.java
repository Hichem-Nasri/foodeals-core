package net.foodeals.core.repositories;

import net.foodeals.core.domain.entities.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface CountryRepository extends BaseRepository<Country, UUID> {
    @Query("SELECT SUM(SIZE(s.cities)) FROM Country c JOIN c.states s WHERE c.name = :countryName")
    int countTotalCitiesByCountryName(@Param("countryName") String countryName);

    Country findByName(String name);
}
