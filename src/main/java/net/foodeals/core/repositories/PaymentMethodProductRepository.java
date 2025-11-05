package net.foodeals.core.repositories;


import net.foodeals.core.domain.entities.PaymentMethodProduct;

import java.util.Optional;
import java.util.UUID;

public interface PaymentMethodProductRepository extends BaseRepository<PaymentMethodProduct, UUID> {

    Optional<PaymentMethodProduct> findByMethodName(String methodName);
}
