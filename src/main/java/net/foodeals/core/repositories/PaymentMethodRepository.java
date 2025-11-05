package net.foodeals.core.repositories;

import net.foodeals.core.domain.entities.PaymentMethod;

import java.util.Optional;
import java.util.UUID;

public interface PaymentMethodRepository extends BaseRepository<PaymentMethod, UUID> {

    Optional<PaymentMethod> findByLabel(String label);

}
