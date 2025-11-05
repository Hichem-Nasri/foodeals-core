package net.foodeals.core.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import net.foodeals.core.domain.enums.PublisherType;

import java.util.UUID;

public record PublisherInfo(@Column(name = "publisher_id")
                            UUID id,
                            @Enumerated(EnumType.STRING)
                            @Column(name = "publisherType")
                            PublisherType type) {}