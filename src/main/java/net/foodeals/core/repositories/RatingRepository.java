package net.foodeals.core.repositories;


import net.foodeals.core.domain.entities.Rating;
import net.foodeals.core.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface RatingRepository extends JpaRepository<Rating, UUID> {
    List<Rating> findByUser(User user);
}
