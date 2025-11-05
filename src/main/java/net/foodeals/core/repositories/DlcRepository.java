package net.foodeals.core.repositories;

import net.foodeals.core.domain.entities.Dlc;
import net.foodeals.core.domain.enums.ValorisationType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface DlcRepository extends BaseRepository<Dlc, UUID> {
	
	 Page<Dlc> findByValorisationType(ValorisationType valorisationType, Pageable pageable);

    Optional<Dlc> findByProductBarcode(String barcode);
}
