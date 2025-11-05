package net.foodeals.core.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record Name(
        @Column(name = "first_name")
        String firstName,

        @Column(name = "last_name")
        String lastName
) {
}
