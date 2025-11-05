package net.foodeals.core.repositories;

import net.foodeals.core.domain.entities.Notification;
import net.foodeals.core.domain.entities.User;
import net.foodeals.core.domain.enums.NotificationStatus;
import net.foodeals.core.domain.enums.TypeRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface NotificationRepository extends BaseRepository<Notification, UUID> {

    Page<Notification> findAllByStatus(NotificationStatus status, Pageable pageable);

    List<Notification> findByUser(User user);

    long countByUserAndTypeRequest(User user, TypeRequest typeRequest);
}
