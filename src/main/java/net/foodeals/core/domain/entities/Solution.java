package net.foodeals.core.domain.entities;

import jakarta.persistence.*;
import lombok.*;

import org.hibernate.annotations.UuidGenerator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "solutions")

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Solution extends AbstractEntity<UUID> {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    private String name;

    @ManyToMany(mappedBy = "solutions")
    private Set<OrganizationEntity> organizationEntities = new HashSet<>();
    
    
    @ManyToMany(mappedBy = "solutions")  
    private List<SubEntity> subEntities;

}
