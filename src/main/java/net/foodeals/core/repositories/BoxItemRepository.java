package net.foodeals.core.repositories;

import net.foodeals.core.domain.entities.BoxItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BoxItemRepository extends JpaRepository<BoxItem, UUID> {
}
