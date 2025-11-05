package net.foodeals.core.repositories;
;

import net.foodeals.core.domain.entities.Contact;

import java.util.UUID;

public interface ContactRepository extends BaseRepository<Contact, UUID> {
    Contact findByEmail(String email);
}
