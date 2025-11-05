package net.foodeals.core.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import net.foodeals.core.domain.enums.NotificationStatus;
import net.foodeals.core.domain.enums.TypeRequest;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "notifications")

@Getter
@Setter
public class Notification extends AbstractEntity<UUID> {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID Id;
    
    @Enumerated(EnumType.STRING)
	@Column(name = "type_request")
    private TypeRequest typeRequest;

    private String title;

    private String content;
    
    private String attachmentPath;
    
    private NotificationStatus status ;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "entity_id", nullable = false)
    private OrganizationEntity organizationEntity;

    @ManyToOne
    @JoinColumn(name = "subEntity_id", nullable = false)
    private SubEntity subEntity;

}
