package net.foodeals.core.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import net.foodeals.core.domain.enums.ActionType;
import net.foodeals.core.domain.enums.ReasonType;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "deletion_reason")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeletionReason extends AbstractEntity<UUID> {

    @Id
    @UuidGenerator
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "action_type", nullable = false)
    private ActionType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "reason_type", nullable = false)
    private ReasonType reason;

    @Column(name = "details", length = 2000)
    private String details;
}