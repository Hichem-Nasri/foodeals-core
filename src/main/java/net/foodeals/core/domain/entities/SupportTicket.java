package net.foodeals.core.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupportTicket extends AbstractEntity<UUID>
{
    @Id
    @GeneratedValue
    private UUID id;

    private String subject;
    private String message;
    private String category;
    private String status = "OPEN";
    @ManyToOne
    private User user;
}
