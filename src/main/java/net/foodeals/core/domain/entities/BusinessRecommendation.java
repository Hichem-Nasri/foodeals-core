package net.foodeals.core.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class BusinessRecommendation extends AbstractEntity<UUID> {

    @Id
    @GeneratedValue
    private UUID id;

    private String businessName;
    private String address;
    private String category;
    private String description;
}
