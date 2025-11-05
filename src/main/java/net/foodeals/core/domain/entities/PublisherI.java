package net.foodeals.core.domain.entities;

import net.foodeals.core.domain.enums.PublisherType;

import java.util.UUID;

public interface PublisherI {
    UUID getId();

    PublisherType getPublisherType();
}