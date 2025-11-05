package net.foodeals.core.repositories;

import net.foodeals.core.domain.entities.NotificationSettings;
import net.foodeals.core.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface NotificationSettingsRepository extends JpaRepository<NotificationSettings, UUID> {
    Optional<NotificationSettings> findByUser(User user);
}