package net.foodeals.core.repositories;


import net.foodeals.core.domain.entities.Offer;
import net.foodeals.core.domain.entities.SubEntity;

import java.util.List;
import java.util.UUID;

public interface OfferRepository extends BaseRepository<Offer, UUID> {
	
	List<Offer>getOffersBySubEntity(SubEntity subEntity);

    List<Offer> findByType(String type);
}
