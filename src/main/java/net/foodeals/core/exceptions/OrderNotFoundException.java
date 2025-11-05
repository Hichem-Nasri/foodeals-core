package net.foodeals.core.exceptions;

import java.util.UUID;

public class OrderNotFoundException extends RuntimeException {
    private final UUID id;

    public OrderNotFoundException(UUID id) {
        super("order with id " + id + " not found ");
        this.id = id;
    }
}
