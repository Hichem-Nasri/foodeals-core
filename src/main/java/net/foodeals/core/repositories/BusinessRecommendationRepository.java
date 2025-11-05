package net.foodeals.core.repositories;

import net.foodeals.core.domain.entities.BusinessRecommendation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BusinessRecommendationRepository extends JpaRepository<BusinessRecommendation, UUID> {}
