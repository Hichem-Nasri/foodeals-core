package net.foodeals.core.exceptions;

import java.util.UUID;

public class DealNotFoundException extends RuntimeException {
    private final UUID id;

    public DealNotFoundException(UUID id) {
        super("Deal with id" + id + " not found");
        this.id = id;
    }
}