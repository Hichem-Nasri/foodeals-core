package net.foodeals.core.repositories;

import net.foodeals.core.domain.entities.DeliveryOption;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeliveryOptionRepository extends JpaRepository<DeliveryOption, UUID> {
}
