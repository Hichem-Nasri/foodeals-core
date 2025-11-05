package net.foodeals.core.repositories;


import net.foodeals.core.domain.entities.State;

import java.util.UUID;

public interface StateRepository extends BaseRepository<State, UUID> {
    State findByName(String name);

    State findByCode(String number);
}
