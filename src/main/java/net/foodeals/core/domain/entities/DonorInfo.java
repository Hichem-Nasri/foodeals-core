package net.foodeals.core.domain.entities;


import net.foodeals.core.domain.enums.DonorType;

import java.util.UUID;

public interface DonorInfo {
    UUID getId();

    DonorType getDonorType();
}