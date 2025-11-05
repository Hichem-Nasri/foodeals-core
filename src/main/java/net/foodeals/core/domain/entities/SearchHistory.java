package net.foodeals.core.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "search_history")
public class SearchHistory  extends AbstractEntity<UUID> {

	@Id
	@GeneratedValue
	private UUID id;

	private String keyword;

	private Integer userId; // Identifiant de l'utilisateur

	private LocalDateTime searchedAt = LocalDateTime.now();
}
