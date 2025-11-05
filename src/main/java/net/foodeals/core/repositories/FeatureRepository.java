package net.foodeals.core.repositories;


import net.foodeals.core.domain.entities.Features;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface FeatureRepository extends BaseRepository<Features, UUID> {
    Set<Features> findByNameIn(List<String> features);
}
