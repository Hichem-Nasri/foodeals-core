package net.foodeals.core.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public record AuthenticationTokenDetails(
        @Column(name = "access_token")
        String accessToken,

        @Column(name = "refresh_token")
        String refreshToken,

        @Column(name = "expires_at")
        String expiresAt,

        @Column(name = "token_type")
        String tokenType
) {
}