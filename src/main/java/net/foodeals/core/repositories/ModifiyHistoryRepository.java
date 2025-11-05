package net.foodeals.core.repositories;

import net.foodeals.core.domain.entities.Box;
import net.foodeals.core.domain.entities.ModifiyHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ModifiyHistoryRepository extends JpaRepository<ModifiyHistory, UUID> {
	
	 List<ModifiyHistory> findByBox(Box box);
    
}