package net.foodeals.core.repositories;


import net.foodeals.core.domain.entities.CoveredZones;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CoveredZonesRepository extends JpaRepository<CoveredZones, UUID> {
}
