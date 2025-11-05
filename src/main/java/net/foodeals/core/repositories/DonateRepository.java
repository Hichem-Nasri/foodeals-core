package net.foodeals.core.repositories;


import net.foodeals.core.domain.entities.Donate;
import net.foodeals.core.domain.entities.User;

import java.util.List;
import java.util.UUID;

public interface DonateRepository extends BaseRepository<Donate, UUID> {
    List<Donate> findByUserDonor(User user);
}
