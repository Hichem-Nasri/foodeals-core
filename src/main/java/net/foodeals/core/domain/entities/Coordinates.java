package net.foodeals.core.domain.entities;

import jakarta.persistence.Embeddable;

@Embeddable
public record Coordinates(Float latitude, Float longitude) {
}
