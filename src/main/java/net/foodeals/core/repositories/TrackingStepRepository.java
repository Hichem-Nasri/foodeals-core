package net.foodeals.core.repositories;

import net.foodeals.core.domain.entities.TrackingStep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackingStepRepository extends JpaRepository<TrackingStep,Long> {
}
