package net.foodeals.core.repositories;

import net.foodeals.core.domain.entities.Modification;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ModificationRepository extends BaseRepository<Modification, UUID> {

	 List<Modification> findByDlcId(UUID dlcId);
	 @Query("SELECT m FROM Modification m WHERE m.dlc.id = :dlcId AND m.user.id = :userId ORDER BY m.modificationDate DESC")
	 List<Modification>  findLastModificationByDlcIdAndUserId(UUID dlcId, Integer userId);
}
