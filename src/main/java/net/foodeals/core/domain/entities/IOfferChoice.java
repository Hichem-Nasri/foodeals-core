package net.foodeals.core.domain.entities;


import net.foodeals.core.domain.enums.OfferType;

import java.util.UUID;

public interface IOfferChoice {
    UUID getId();

    OfferType getOfferType();
}
