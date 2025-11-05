package net.foodeals.core.repositories;

import net.foodeals.core.domain.entities.BusinessApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BusinessApplicationRepository extends JpaRepository<BusinessApplication, UUID> {
}
