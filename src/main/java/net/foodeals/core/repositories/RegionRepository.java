package net.foodeals.core.repositories;


import net.foodeals.core.domain.entities.Region;

import java.util.UUID;

public interface RegionRepository extends BaseRepository<Region, UUID> {
    Region findByName(String name);
}
