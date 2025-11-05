package net.foodeals.core.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import net.foodeals.core.domain.enums.ApplicationStatus;

import java.time.Instant;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BusinessApplication extends AbstractEntity<UUID> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String businessName;
    private String ownerName;
    private String email;
    private String phone;
    private String address;
    private String category;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    private Instant submittedAt;
}
