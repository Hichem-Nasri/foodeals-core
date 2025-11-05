package net.foodeals.core.repositories;

import net.foodeals.core.domain.entities.Referral;
import net.foodeals.core.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ReferralRepository extends JpaRepository<Referral, UUID> {
    List<Referral> findBySender(User sender);
    boolean existsBySenderAndEmail(User sender, String email);
    Optional<Referral> findBySenderAndEmail(User sender, String email);
}