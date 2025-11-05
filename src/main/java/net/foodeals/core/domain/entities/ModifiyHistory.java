package net.foodeals.core.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "modify_history")
@Getter
@Setter
public class ModifiyHistory extends AbstractEntity<UUID> {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private OrganizationEntity organization;  

    @ManyToOne
    @JoinColumn(name = "box_id", nullable = false)
    private Box box;

    private LocalDateTime modifyDate;
    
    

    public ModifiyHistory(OrganizationEntity organization, Box box, LocalDateTime modifyDate) {
        this.organization = organization;
        this.box = box;
        this.modifyDate = modifyDate;
    }



	public ModifiyHistory() {
		super();
	}
}