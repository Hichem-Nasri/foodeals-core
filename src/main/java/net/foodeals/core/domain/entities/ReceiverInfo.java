package net.foodeals.core.domain.entities;


import net.foodeals.core.domain.enums.DonationReceiverType;

import java.util.UUID;

public interface ReceiverInfo {
    UUID getId();

    DonationReceiverType getReceiverType();
}